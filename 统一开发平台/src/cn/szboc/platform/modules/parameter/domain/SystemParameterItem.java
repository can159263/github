package cn.szboc.platform.modules.parameter.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import cn.szboc.platform.core.PlatformRegister;

/**
 * 与数据库表[TP_PARAMETERS]相映射 表示一个条目bean,可能为包,可能为参数
 */
public class SystemParameterItem {

    /** (参数/包)的全限定名 */
    private String qname;
    
    /** (参数/包)所在的上级包名 */
    private String packageName;
    
    /** (参数/包)英文名称 */
    private String itemName;
    
    /** (参数/包)中文名称 */
    private String itemDisplayName;
    
    /** 类型: 0-包, 1-参数 */
    private ParameterItemType itemType;
    
    /** 详细描述 */
    private String itemDesc;
    
    /** 参数值 */
    private String paramValue;
    
    
    /** 条目最近操作人 */
    private String lastUpdateUser;

    /** 条目最近操作时间 */
    private Timestamp lastUpdateDate;

    // 以下是set和get方法
    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDisplayName() {
        return itemDisplayName;
    }

    public void setItemDisplayName(String itemDisplayName) {
        this.itemDisplayName = itemDisplayName;
    }

    public ParameterItemType getItemType() {
        return itemType;
    }

    public void setItemType(ParameterItemType itemType) {
        this.itemType = itemType;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    
    /**
     * 覆盖toString方法,使用易读的方式打印该参数
     */
    @Override
    public String toString() {

        String lineSeparator = PlatformRegister.lineSeparator;
        return new StringBuilder()
                    .append("类型(0-包,1-参数)[").append(this.itemType).append("]").append(lineSeparator)
                    .append("参数全限定名[").append(this.qname).append("]").append(lineSeparator)
                    .append("参数包名[").append(this.packageName).append("]").append(lineSeparator)
                    .append("参数(英文)名称[").append(this.itemName).append("]").append(lineSeparator)
                    .append("参数(中文)名称[").append(this.itemDisplayName).append("]").append(lineSeparator)
                    .append("参数值[").append(this.paramValue).append("]").append(lineSeparator)
                    .append("描述[").append(this.itemDesc).append("]").append(lineSeparator)
                    .append("最后操作人[").append(this.lastUpdateUser).append("],").append(lineSeparator)
                    .append("最后操作时间[").append(this.lastUpdateDate == null ? "" : (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.lastUpdateDate))).append("]").append(lineSeparator)
                    .toString();
    }
}
