package cn.szboc.platform.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import cn.szboc.platform.core.db.Result;
import cn.szboc.platform.core.db.SingleColumnResult;
import cn.szboc.platform.exception.PlatformRtException;

/**
 * 系统平台Dao,要求所有Dao层子类均继承该父类 主要用途: 1,注入Dao模版; 2,注入系统表名集合 另支持query的两种参数和命名参数查询方式
 * 提供反射式bean的支持(支持传入Map.class和任意JavaBean.class)
 */
public abstract class PlatformDao<T extends PlatformDatabaseObjects> extends NamedParameterJdbcDaoSupport {

	/**
	 * 分页内部标识符
	 */
	public static final String COLUMN_NAME_FORPAGE = "$RN";

	/**
	 * 系统表名集合
	 */
	private T platformDatabaseObjects;

	/**
	 * 自动映射,容器中bean名称是platformJdbcTemplate
	 */
	@Autowired
	@Qualifier("platformJdbcTemplate")
	public void setPlatFormJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.setJdbcTemplate(jdbcTemplate);
	}

	public T getPlatformDatabaseObjects() {
		return platformDatabaseObjects;
	}

	/**
	 * 获取系统数据库对象
	 * 
	 * @param platformDatabaseObjects
	 */
	@Autowired
	@Qualifier("platformDatabaseObjects")
	public void setPlatformDatabaseObjects(T platformDatabaseObjects) {
		this.platformDatabaseObjects = platformDatabaseObjects;
	}

	// =========================================== JDBC templeate扩展方法
	protected <E> E findSingleColumn(String sql, Object[] params, Class<E> recordTypeClazz) {
		E record = null;

		List<E> tmpList = query(sql, params, recordTypeClazz, null, false);
		if (tmpList != null) {
			if (tmpList.size() > 1) {
				throw new PlatformRtException("符合条件的记录数过多，期望的记录数是1");
			}
			record = tmpList.get(0);
		}
		return record;
	}

	protected <E> E find(String sql, final Class<E> type) {
		
		return find(sql, new Object[]{}, type);
		
	}
	
	protected <E> E find(String sql, Object[] params, final Class<E> type) {
		
		// 如果目标类型为简单类型,则直接返回即可
		if(SingleColumnResult.support(type)){
			return findSingleColumn(sql, params, type);
		}
		
		E record = null;

		List<E> tmpList = query(sql, params, type, null);
		if (tmpList != null) {
			if (tmpList.size() > 1) {
				throw new PlatformRtException("符合条件的记录数过多，期望的记录数是1");
			}
			record = tmpList.get(0);
		}

		return record;
	}

	protected <E> List<E> queryWithSingleColumn(String aSql, final Class<E> recordTypeClazz) {
		return query(aSql, new Object[] {}, recordTypeClazz, null, false);
	}

	protected <E> List<E> queryWithSingleColumn(String aSql, Object[] params, final Class<E> itemType) {
		return query(aSql, params, itemType, null, false);
	}

	protected <E> List<E> query(String aSql, Object[] params, final Class<E> recordTypeClazz) {
		return query(aSql, params, recordTypeClazz, null);
	}

	protected <E> List<E> query(String aSql, Object[] params, final Class<E> recordTypeClazz, Page page) {
		return query(aSql, params, recordTypeClazz, page, true);
	}

	protected <E> List<E> query(String aSql, Object[] params, final Class<E> recordTypeClazz, Page page, final boolean queryMultiColumn) {
		String sql = null;

		if (page != null) {
			sql = pageSqlForOracle(aSql, params, page);
		} else {
			sql = aSql;
		}

		Result<E> result = this.getJdbcTemplate().query(sql, params, new ResultSetExtractor<Result<E>>() {

			@Override
			public Result<E> extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (queryMultiColumn) {
					// 普通查询
					return new Result<E>(rs, recordTypeClazz);
				} else {
					// 单列查询（只查询一个字段）
					return new SingleColumnResult<E>(rs, recordTypeClazz);
				}
			}

		});

		return result.getList();
	}

	/**
	 * 生成Oracle分页包装
	 */
	private String pageSqlForOracle(final String aSql, Object[] params, final Page page) {
		StringBuilder pageSql = new StringBuilder();

		// 先取得总记录数
		int rowsCount = getRowsCount(aSql, params);
		page.setTotalRows(rowsCount);

		int pageRecorders = page.getPageRecorders();
		int currentPage = Integer.parseInt(page.getCurrentPage());

		// 确定结果范围
		int beginRowNum = pageRecorders * (currentPage - 1) + 1;
		int endRowNum = pageRecorders * currentPage;

		pageSql.append("SELECT * FROM (SELECT GLOBAL_TABLE.*, ROWNUM AS ").append(COLUMN_NAME_FORPAGE).append(" from (").append(aSql)
				.append(") GLOBAL_TABLE WHERE ROWNUM <= ").append(endRowNum).append(")  WHERE ").append(COLUMN_NAME_FORPAGE).append(" >= ")
				.append(beginRowNum);

		return pageSql.toString();
	}

	/**
	 * 获取某条SQL语句的结果集总数 JDBC Template版
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	private int getRowsCount(final String sql, Object[] parameters) {
		return this.getJdbcTemplate().queryForInt("SELECT COUNT(1) FROM (" + sql + ") TMP_COUNT_TB", parameters);
	}

	// =========================================== JDBC Named templeate扩展方法

	protected <E> E find(String sql, SqlParameterSource sps, final Class<E> recordTypeClazz) {
		
		// 如果目标类型为简单类型,则直接返回即可
		if(SingleColumnResult.support(recordTypeClazz)){
			return findSingleColumn(sql, sps, recordTypeClazz);
		}
		
		E record = null;

		List<E> tmpList = query(sql, sps, recordTypeClazz, null);
		if (tmpList != null) {
			if (tmpList.size() > 1) {
				throw new PlatformRtException("符合条件的记录数过多，期望的记录数是1");
			}
			record = tmpList.get(0);
		}

		return record;
	}

	protected <E> E findSingleColumn(String sql, SqlParameterSource sps, Class<E> recordTypeClazz) {
		E record = null;

		List<E> tmpList = query(sql, sps, recordTypeClazz, null, false);
		if (tmpList != null) {
			if (tmpList.size() > 1) {
				throw new PlatformRtException("符合条件的记录数过多，期望的记录数是1");
			}
			record = tmpList.get(0);
		}

		return record;
	}

	protected <E> List<E> queryWithSingleColumn(String aSql, SqlParameterSource sps, final Class<E> recordTypeClazz) {
		return query(aSql, sps, recordTypeClazz, null, false);
	}

	protected <E> List<E> query(String aSql, SqlParameterSource sps, final Class<E> recordTypeClazz) {
		return query(aSql, sps, recordTypeClazz, null);
	}

	protected <E> List<E> query(String aSql, SqlParameterSource sps, final Class<E> recordTypeClazz, Page page) {
		return query(aSql, sps, recordTypeClazz, page, true);
	}

	protected <E> List<E> query(String aSql, SqlParameterSource sps, final Class<E> recordTypeClazz, Page page, final boolean queryMultiColumn) {
		String sql = null;

		if (page != null) {
			sql = pageSqlForOracle(aSql, sps, page);
		} else {
			sql = aSql;
		}

		Result<E> result = this.getNamedParameterJdbcTemplate().query(sql, sps, new ResultSetExtractor<Result<E>>() {

			@Override
			public Result<E> extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (queryMultiColumn) {
					// 普通查询
					return new Result<E>(rs, recordTypeClazz);
				} else {
					// 单列查询（只查询一个字段）
					return new SingleColumnResult<E>(rs, recordTypeClazz);
				}
			}

		});

		return result.getList();
	}

	private String pageSqlForOracle(final String aSql, SqlParameterSource sps, final Page page) {
		StringBuilder pageSql = new StringBuilder();

		// 先取得总记录数
		int rowsCount = getRowsCount(aSql, sps);
		page.setTotalRows(rowsCount);

		int pageRecorders = page.getPageRecorders();
		int currentPage = Integer.parseInt(page.getCurrentPage());

		// 确定结果范围
		int beginRowNum = pageRecorders * (currentPage - 1) + 1;
		int endRowNum = pageRecorders * currentPage;

		pageSql.append("SELECT * FROM (SELECT GLOBAL_TABLE.*, ROWNUM AS ").append(COLUMN_NAME_FORPAGE).append(" from (").append(aSql)
				.append(") GLOBAL_TABLE WHERE ROWNUM <= ").append(endRowNum).append(")  WHERE ").append(COLUMN_NAME_FORPAGE).append(" >= ")
				.append(beginRowNum);

		return pageSql.toString();
	}

	/**
	 * 获取某条SQL语句的结果集总数 JDBC Named Template版
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	private int getRowsCount(final String sql, SqlParameterSource sps) {
		return this.getNamedParameterJdbcTemplate().queryForInt("SELECT COUNT(1) FROM (" + sql + ") TMP_COUNT_TB", sps);
	}

}
