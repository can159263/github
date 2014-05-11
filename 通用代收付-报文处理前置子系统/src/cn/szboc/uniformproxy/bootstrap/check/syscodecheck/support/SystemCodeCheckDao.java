package cn.szboc.uniformproxy.bootstrap.check.syscodecheck.support;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import cn.szboc.uniformproxy.frontend.system.FrontendDaoSupport;
import cn.szboc.uniformproxy.frontend.system.FrontendDatabaseObjects;

@Repository("systemCodeCheckDao")
public class SystemCodeCheckDao extends FrontendDaoSupport {

	private String sql_checkSystemCodeExists;
	private String sql_getSystemCodeBean;

	@Override
	protected void initSQL(FrontendDatabaseObjects dbObjects) {
		sql_checkSystemCodeExists = "SELECT COUNT(1) AS cnt FROM " + dbObjects.TABLE_TB_PROXY_SYSTEM + " WHERE system_code = :system_code AND VALID_FLAG = 'Y'";
		sql_getSystemCodeBean = "SELECT system_code, system_name FROM " + dbObjects.TABLE_TB_PROXY_SYSTEM
				+ " WHERE system_code = :system_code";
	}

	/**
	 * 返回某个对应系统别的个数
	 * 
	 * @param sysCode
	 * @return
	 */
	public int checkSystemCodeExists(String systemCode) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("system_code", systemCode);
		return this.getNamedParameterJdbcTemplate().queryForInt(sql_checkSystemCodeExists, sps);
	}

	/**
	 * 返回某个对应系统别的对应领域模型
	 * 
	 * @param systemCode
	 * @return
	 */
	public SystemCodeBean findSystemCodeBean(String systemCode) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("system_code", systemCode);
		return this.getNamedParameterJdbcTemplate().query(sql_getSystemCodeBean, sps, new ResultSetExtractor<SystemCodeBean>() {

			@Override
			public SystemCodeBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (!rs.next()) {
					return null;
				}
				SystemCodeBean scb = new SystemCodeBean();
				scb.setSystemCode(rs.getString("system_code"));
				scb.setSystemName(rs.getString("system_name"));
				return scb;
			}
		});
	}

}
