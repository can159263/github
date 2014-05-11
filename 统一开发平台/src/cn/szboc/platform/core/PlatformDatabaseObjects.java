package cn.szboc.platform.core;

/**
 * 平台数据库对象的集合,约定优于配置:
 *  ［表］名头部使用"TABLE_",可对应于表名 TP_(platform平台表), TS_(system系统表), TB_(base基础表), TD_(data数据表) 等表
 *  ［索引］名头部使用"INDEX_",可对应于索引名IDX_
 *  ［视图］名头部使用"VIEW_",可对应于视图名V_
 *  ［存储过程］名头部使用"PROCEDURE_",可对应于存储过程名PROC_
 *  ［函数］名头部使用"FUNCTION_",可对应于函数名FN_
 */
public class PlatformDatabaseObjects {

    /**
     * 数据库schema
     */
    private String platformDbSchema;

    /**
     * 子类需调用父类构造函数来初始化父类配置
     * 
     * @param sysDbSchema
     */
    public PlatformDatabaseObjects(String platformDbSchema) {

        this.platformDbSchema = platformDbSchema;

        // 初始化表名,视图,索引,存储过程等数据库对象名称
        platformInit();
    }

    /** 系统参数表 */
    public String TABLE_TP_PARAMETERS;

    /**
     * 对平台对象的相关初始化
     */
    private void platformInit() {
        
        TABLE_TP_PARAMETERS = this.platformDbSchema + ".tp_parameters";

    }
    
    /**
     * 子系统的数据库对象类应该能够统一用该方法初始化系统其它数据库对象名称
     */
    protected void systemInit(){
    	// Nop
    };
}
