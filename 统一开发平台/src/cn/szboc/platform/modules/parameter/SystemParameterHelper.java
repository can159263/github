package cn.szboc.platform.modules.parameter;

import org.springframework.beans.factory.annotation.Required;

import cn.szboc.platform.exception.PlatformRtException;
import cn.szboc.platform.modules.parameter.domain.ParameterItemType;
import cn.szboc.platform.modules.parameter.domain.SystemParameterItem;
import cn.szboc.platform.modules.parameter.service.SystemParamterService;

/**
 * 系统参数辅助类
 */
public class SystemParameterHelper {

    private static SystemParameterHelper helper;

    private SystemParamterService paramService;
    
    private SystemParameterHelper() {    }

    public static SystemParameterHelper getInstance() {
        if (helper == null) {
            synchronized (SystemParameterHelper.class) {
                if (helper == null) {
                    helper = new SystemParameterHelper();
                }
            }
        }
        return helper;
    }

    @Required
    public void setParamService(SystemParamterService paramService) {
        this.paramService = paramService;
    }
    
    /** 查询参数值的简单方法 */
    public String getParamValue(String paramName){
        SystemParameterItem item = paramService.getParameterItem(paramName);
        if(ParameterItemType.PARAMETER == item.getItemType()){
            return item.getParamValue();
        }else{
            throw new PlatformRtException("参数查询异常", new IllegalArgumentException("该条目为包(没有值),不是参数!"));
        }
    }
    
    /** 更方便的静态方法,查询参数值的简单方法 */
    public static String getParam(String paramName){
        return getInstance().getParamValue(paramName);
    }
    
}
