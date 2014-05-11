package cn.szboc.uniformproxy.bootstrap.check.netaddresscheck.support;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import cn.szboc.uniformproxy.frontend.system.FrontendDaoSupport;
import cn.szboc.uniformproxy.frontend.system.FrontendDatabaseObjects;

@Repository("netAddressCheckDao")
public class NetAddressCheckDao extends FrontendDaoSupport {

	private static String sql_getSystemDispatchBeans;

	@Override
	protected void initSQL(FrontendDatabaseObjects dbObjects) {
		sql_getSystemDispatchBeans = "SELECT system_id, socket_address_ip, socket_address_port, server_status as server_status_with_string FROM " + dbObjects.TABLE_TB_DISPATCH_ENPOINT_ADDRESSES
				+ " WHERE system_id = :system_id";
	}

	/**
	 * 获取当前系统别下的所有监听数据
	 * 
	 * @param systemCode
	 *            系统别
	 * @return
	 */
	public List<NetAddressCheckBean> getSystemDispatchBeans(String systemCode) {
		SqlParameterSource sps = new MapSqlParameterSource("system_id", systemCode);
		List<NetAddressCheckBean> o =  query(sql_getSystemDispatchBeans, sps, NetAddressCheckBean.class);
		return o;
	}

}
