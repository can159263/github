package cn.szboc.platform.modules.parameter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import cn.szboc.platform.core.PlatformDao;
import cn.szboc.platform.core.PlatformDatabaseObjects;
import cn.szboc.platform.modules.parameter.domain.ParameterItemType;
import cn.szboc.platform.modules.parameter.domain.SystemParameterItem;

/**
 * Spring JDBC 模版 风格的参数模块Dao层
 */
@Repository("systemParameterDao")
public final class SystemParameterDao extends PlatformDao<PlatformDatabaseObjects> {

    /** 根据全限定名查询某一条目的个数,多为判断该条目(参数或包)是否存在 */
    private String sql_countWithQname;

    /** 根据全限定名查找条目Bean */
    private String sql_querySystemParameterBean;
    
    /** 新增参数Bean */
    private String sql_insertParameterItem;
    
    /** 删除参数Bean */
    private String sql_deleteParameterItem;

    /** 结果集转换器 */
    private ResultSetExtractor<SystemParameterItem> rsExtractor;

    @PostConstruct
    private void init() {

        PlatformDatabaseObjects DB = getPlatformDatabaseObjects();

        sql_countWithQname = "SELECT COUNT(1) AS cnt FROM " + DB.TABLE_TP_PARAMETERS + " WHERE qname = :qname";

        sql_querySystemParameterBean = "SELECT QNAME, PACKAGE_NAME, ITEM_NAME, ITEM_DISPLAY_NAME, ITEM_TYPE, ITEM_DESC, PARAM_VALUE, LAST_UPDATE_USER, LAST_UPDATE_DATE FROM "
                + DB.TABLE_TP_PARAMETERS + " WHERE qname = :qname";

		sql_insertParameterItem = "INSERT INTO "
				+ DB.TABLE_TP_PARAMETERS
				+ " (QNAME,PACKAGE_NAME,ITEM_NAME,ITEM_DISPLAY_NAME,ITEM_TYPE,ITEM_DESC,PARAM_VALUE,LAST_UPDATE_USER,LAST_UPDATE_DATE)"
				+ " VALUES (:qname,:packageName,:itemName,:itemDisplayName,:itemType,:itemDesc,:paramValue,:lastUpdateUser,:lastUpdateDate)";        
        
		sql_deleteParameterItem = "DELETE FROM "
				+ DB.TABLE_TP_PARAMETERS
				+ " WHERE qname = :qname";
		
        rsExtractor = new ResultSetExtractor<SystemParameterItem>() {

            @Override
            public SystemParameterItem extractData(ResultSet rs) throws SQLException, DataAccessException {
                SystemParameterItem item = null;
                if (rs.next()) {
                    item = new SystemParameterItem();
                    item.setQname(rs.getString("QNAME"));
                    item.setPackageName(rs.getString("PACKAGE_NAME"));
                    item.setParamValue(rs.getString("PARAM_VALUE"));
                    item.setItemDesc(rs.getString("ITEM_DESC"));
                    item.setItemDisplayName(rs.getString("ITEM_DISPLAY_NAME"));
                    item.setItemName(rs.getString("ITEM_NAME"));
                    item.setItemType(ParameterItemType.getInstance(rs.getString("ITEM_TYPE")));
                    item.setLastUpdateUser(rs.getString("LAST_UPDATE_USER"));
                    item.setLastUpdateDate(rs.getTimestamp("LAST_UPDATE_DATE"));
                    return item;
                }
                return item;
            }

        };

    }

    public int countWithQname(String qName) {
        SqlParameterSource sps = new MapSqlParameterSource().addValue("qname", qName);
        return this.getNamedParameterJdbcTemplate().queryForInt(sql_countWithQname, sps);
    }

    public SystemParameterItem querySystemParameterItem(String qName) {
        SqlParameterSource sps = new MapSqlParameterSource().addValue("qname", qName);
        return this.getNamedParameterJdbcTemplate().query(sql_querySystemParameterBean, sps, rsExtractor);
    }

	public int insertParameterItem(SystemParameterItem item) {
		SqlParameterSource sps = new MapSqlParameterSource()
					.addValue("qname", item.getQname())
					.addValue("packageName", item.getPackageName())
					.addValue("itemName", item.getItemName())
					.addValue("itemDisplayName", item.getItemDisplayName())
					.addValue("itemType", item.getItemType().toString())
					.addValue("itemDesc", item.getItemDesc())
					.addValue("paramValue", item.getParamValue())
					.addValue("lastUpdateUser", item.getLastUpdateUser())
					.addValue("lastUpdateDate", item.getLastUpdateDate());
		return this.getNamedParameterJdbcTemplate().update(sql_insertParameterItem, sps);
	}

	public int deleteParameterItem(String itemQname) {
		SqlParameterSource sps = new MapSqlParameterSource()
					.addValue("qname", itemQname);
		return this.getNamedParameterJdbcTemplate().update(sql_deleteParameterItem, sps);
	}

}
