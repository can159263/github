package cn.szboc.platform.core.db;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.szboc.platform.commons.ArrayUtils;
import cn.szboc.platform.commons.ConvertUtils;

/**
 * 单列（只查询一个字段）结果集转换
 */
@SuppressWarnings("all")
public class SingleColumnResult<E> extends Result<E> {

	/**
	 * 常用的单列基本数据类型
	 */
	private static Class[] validSingleTypes = {

	String.class,

	BigDecimal.class,

	java.util.Date.class,

	int.class, Integer.class,

	double.class, Double.class, float.class, Float.class, short.class, Short.class, char.class, Character.class, byte.class, Byte.class, long.class,
			Long.class, boolean.class, Boolean.class, byte[].class, Byte[].class, BigInteger.class, java.sql.Date.class, java.sql.Time.class,
			java.sql.Timestamp.class };

	public SingleColumnResult(ResultSet rs, Class<E> elementClazz) throws SQLException {

		super(rs, elementClazz);

	}

	protected void check() {
		// 如果行集的列数必须等于1
		if (colCount != 1) {
			throw new IllegalArgumentException("SingleColumnResult只支持单列结果集");
		}
		if (!ArrayUtils.isInArray(validSingleTypes, this.elementClazz)) {
			throw new IllegalArgumentException("SingleColumnResult不支持该类型的结果转换,class:" + this.elementClazz.getCanonicalName());
		}

	}

	/**
	 * 本简单类型是否支持该类
	 */
	public static boolean support(Class<?> clazz){
		return ArrayUtils.isInArray(validSingleTypes, clazz);
	}
	
	
	@Override
	protected void convert() throws SQLException {
		this.convertToList();
	}

	private void convertToList() throws SQLException {

		List data = new ArrayList();

		int colType = colTypes[0];

		while (this.rs.next()) {

			Object objVal = rs.getObject(1);

			if(objVal == null){
				data.add(null);
				continue;
			}
			
			if (ArrayUtils.isInArray(vcharTypes, colType)) {
				objVal = rs.getString(1);
			} if (ArrayUtils.isInArray(charTypes, colType)) {
				objVal = rs.getString(1).replaceAll("\u0020*$", "");
			} else if (ArrayUtils.isInArray(numericTypes, colType)) {
				BigDecimal bd = rs.getBigDecimal(1);
				if (bd == null) {
					objVal = null;
				} else if (bd.scale() != 0) {
					objVal = bd;
				} else if (bd.precision() <= 9) {
					objVal = bd.intValueExact();
				} else if (bd.precision() <= 18) {
					objVal = bd.longValueExact();
				} else {
					objVal = bd.toBigIntegerExact();
				}
			} else if (ArrayUtils.isInArray(dateTypes, colType)) {
				objVal = rs.getTimestamp(1);
			} else if (ArrayUtils.isInArray(blobTypes, colType)) {
				objVal = processBlobColVal(1);
			} else if (ArrayUtils.isInArray(clobTypes, colType)) {
				objVal = processClobColVal(1);
			}

			// 转成合适类型后返回
			data.add(ConvertUtils.convert(objVal, this.elementClazz));
		}

		this.list = data.isEmpty() ? null : data;
	}
}
