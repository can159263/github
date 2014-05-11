package cn.szboc.platform.core.db;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;

import cn.szboc.platform.commons.ArrayUtils;
import cn.szboc.platform.commons.SimplePropertyUtils;
import cn.szboc.platform.commons.StringUtils;

/**
 * SQL结果集与返回Bean的映射 E为结果集中每个行集转换的类型
 */
@SuppressWarnings("all")
public class Result<E> {

	public static final int[] charTypes = { Types.CHAR, Types.NCHAR };
	public static final int[] vcharTypes = { Types.VARCHAR, Types.NVARCHAR };
	public static final int[] numericTypes = { Types.NUMERIC, Types.DECIMAL, Types.DOUBLE, Types.FLOAT, Types.INTEGER };
	public static final int[] dateTypes = { Types.DATE, Types.TIMESTAMP };
	public static final int[] blobTypes = { Types.BLOB };
	public static final int[] clobTypes = { Types.CLOB };

	/**
	 * SQL结果集
	 */
	protected ResultSet rs;

	/**
	 * SQL结果集行集要转换的对象类型
	 */
	protected Class<E> elementClazz;

	/**
	 * SQL结果集行集的列数
	 */
	protected int colCount;

	/**
	 * SQL结果集行集的列的名称
	 */
	protected String[] colNames;

	/**
	 * SQL结果集行集的列的类型
	 */
	protected int[] colTypes;

	/**
	 * SQL结果集行集的列的标度(只和number类型相关)
	 */
	protected int[] colScales;

	/**
	 * 目标bean的属性名称数组,目标bean中对应的属性名称
	 */
	protected String[] targetPropertyNames;

	/**
	 * 转换后的列表
	 */
	protected List<E> list;

	/**
	 * 从SQL结果集得到该结果的Java表示
	 * 
	 * @param rs
	 * @param elementClazz
	 * @throws SQLException
	 */
	public Result(final ResultSet rs, final Class<E> elementClazz) throws SQLException {

		this.rs = rs;
		this.elementClazz = elementClazz;

		// 拿到ResultSet的原型
		ResultSetMetaData rsmd = rs.getMetaData();

		// 得到返回结果集中行集的列数
		this.colCount = rsmd.getColumnCount();

		// 初始化列名称
		this.colNames = new String[this.colCount];

		// 初始化列类型
		this.colTypes = new int[this.colCount];

		this.colScales = new int[this.colCount];

		// 初始化列对应的bean属性名称
		this.targetPropertyNames = new String[this.colCount];

		String tmp = null;

		// 读取出所有列名、列类型
		for (int i = 1; i <= colCount; i++) {

			this.colNames[i - 1] = rsmd.getColumnLabel(i);

			this.colTypes[i - 1] = rsmd.getColumnType(i);

			// 如果是Numeric类型的,则要设置标度
			if (this.colTypes[i - 1] == Types.NUMERIC) {
				this.colScales[i - 1] = rsmd.getScale(i);
			} else {
				this.colScales[i - 1] = -1;
			}

			// 固定按照驼峰命名法进行转换
			this.targetPropertyNames[i - 1] = StringUtils.toCamelCase(this.colNames[i - 1]);
		}

		// 执行检测
		this.check();

		// 执行转换
		this.convert();

	}

	public List<E> getList() {
		return this.list;
	}

	/**
	 * 子类实现自己的检测规则
	 */
	protected void check() {
	}

	/**
	 * 如果传入的Map,则返回的是一个Map列表,否则是Bean列表
	 * 
	 * @throws SQLException
	 */
	protected void convert() throws SQLException {
		// 如果指定的Map,则默认使用HashMap进行装载数据
		if (Map.class.isAssignableFrom(elementClazz)) {
			this.convertToListWithMapElements();
		} else { // 否则按照JavaBean的逻辑进行转换
			this.convertToListWithBeanElements();
		}
	}

	/**
	 * 将结果集转成List,List中的元素是指定的Bean类型
	 * 
	 * @throws SQLException
	 */
	private void convertToListWithBeanElements() throws SQLException {

		List<E> data = new ArrayList<E>();
		E bean = null;

		String propertyName = null;

		Object objVal = null;

		while (this.rs.next()) {
			try {
				// 新建一个bean
				bean = this.elementClazz.newInstance();

				for (int i = 1; i <= this.colCount; i++) {

					objVal = rs.getObject(i);

					propertyName = targetPropertyNames[i - 1];

					// 如果可填充,则进行填充,否则也不抛出异常,实现交集的效果
					if (PropertyUtils.isWriteable(bean, propertyName)) {
						
						// 如果是null值,直接设置,不再转换
						if (objVal == null) {
							SimplePropertyUtils.setProperty(bean, propertyName, null);
							continue;
						}
						
						// 如果目标Bean的属性与结果集对应列的属性属于派生关系,则可以直接赋值
						if (PropertyUtils.getPropertyType(bean, propertyName).isAssignableFrom(objVal.getClass())) {
							PropertyUtils.setProperty(bean, propertyName, objVal);
						} else {
							// 否则就需要对其进行类型转换

							// 分别判断是字符类型/数值类型/日期时间类型
							if (ArrayUtils.isInArray(vcharTypes, colTypes[i - 1])) {
								objVal = rs.getString(i);
							} else if (ArrayUtils.isInArray(charTypes, colTypes[i - 1])) {
								// 对于char类型,要特别去除右边空白
								objVal = rs.getString(i).replaceAll("\u0020*$", "");
							} else if (ArrayUtils.isInArray(numericTypes, colTypes[i - 1])) {
								objVal = rs.getBigDecimal(i);
							} else if (ArrayUtils.isInArray(dateTypes, colTypes[i - 1])) {
								objVal = rs.getTimestamp(i);
							} else if (ArrayUtils.isInArray(blobTypes, colTypes[i - 1])) {
								objVal = processBlobColVal(i);
							} else if (ArrayUtils.isInArray(clobTypes, colTypes[i - 1])) {
								objVal = processClobColVal(i);
							}

							SimplePropertyUtils.setProperty(bean, propertyName, objVal);
						}
					}
				}
			} catch (Exception e) {
				throw new SQLException("填充bean[" + this.elementClazz.getName() + "]时发生错误，属性名：" + propertyName + "，错误信息：", e);
			}
			data.add(bean);
		}
		this.list = data.isEmpty() ? null : data;
	}

	/**
	 * 将结果集转为Map要素进行返回
	 * 
	 * @throws SQLException
	 */
	private void convertToListWithMapElements() throws SQLException {

		List data = new ArrayList();
		Map<String, Object> map = null;

		while (this.rs.next()) {
			map = new HashMap<String, Object>();
			for (int i = 1; i <= this.colCount; i++) {
				map.put(this.targetPropertyNames[i - 1], getColValAccordingDatabase(i));
			}
			data.add(map);
		}

		this.list = data.isEmpty() ? null : data;
	}

	/**
	 * 依据数据库的元数据信息，获取指定列的值。 值的类型依照对通用的格式进行转换 分别涉及到String, BigDecimal, int, long,
	 * BigInteger, byte[], java.util.Date 该方法已考虑BLOB-byte[], CLOB->String特殊类型的转换
	 * 
	 * @param colIndex
	 * @return
	 * @throws SQLException
	 */
	protected Object getColValAccordingDatabase(int colIndex) throws SQLException {

		if (rs.getObject(colIndex) == null) {
			return null;
		}

		// 字符串类型直接返回
		if (ArrayUtils.isInArray(charTypes, colTypes[colIndex - 1])) {
			return rs.getString(colIndex);
		}
		// 数值类型默认先转为BigDecimal,如果没有标度,则根据精度的承受能力由小到大依次转为Integer,Long,BigInteter
		if (ArrayUtils.isInArray(numericTypes, colTypes[colIndex - 1])) {
			BigDecimal bd = rs.getBigDecimal(colIndex);
			if (bd == null) {
				return null;
			}
			if (bd.scale() != 0) {
				return bd;
			}
			if (bd.precision() <= 9) {
				return bd.intValueExact();
			}
			if (bd.precision() <= 18) {
				return bd.longValueExact();
			}
			return bd.toBigIntegerExact();
		}
		// DATE/TIMESTAMP类型转为java.util.Date
		if (ArrayUtils.isInArray(dateTypes, colTypes[colIndex - 1])) {
			return new Date(rs.getTimestamp(colIndex).getTime());
		}
		// BLOB类型默认转为字节数组
		if (ArrayUtils.isInArray(blobTypes, colTypes[colIndex - 1])) {
			return processBlobColVal(colIndex);
		}
		// CLOB类型默认转为字符串
		if (ArrayUtils.isInArray(clobTypes, colTypes[colIndex - 1])) {
			return processClobColVal(colIndex);
		}
		// 剩余都按照默认规则进行转换
		return rs.getObject(colIndex);
	}

	protected byte[] processBlobColVal(int colIndex) throws SQLException {
		Blob blob = rs.getBlob(colIndex);
		return blob != null ? blob.getBytes(1L, (int) blob.length()) : null;
	}

	protected String processClobColVal(int colIndex) throws SQLException {
		Clob clob = rs.getClob(colIndex);
		return clob != null ? clob.getSubString(1L, (int) clob.length()) : null;
	}

}
