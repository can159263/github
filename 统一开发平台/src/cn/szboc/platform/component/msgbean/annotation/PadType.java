package cn.szboc.platform.component.msgbean.annotation;

public enum PadType {

    /**
     * property转byte[]字节数不足时左补,byte[]转property时将从左侧trim
     * 通常用于数值型
     */
    LEFT,

    /**
     * property转byte[]字节数不足时右补,byte[]转property时将从右侧trim
     * 通常用于字符串
     */
    RIGHT,

    /**
     * 源自"刚刚好"的意思,即属性和字节数组刚刚好匹配上,不需要填充或去除
     * property转byte[]字节数不进行任何补充,要求字节数刚好匹配,
     * byte[]转property时不进行trim,直接转换
     */
    MATCH,

    /**
     * 源自"no operate"的意思,即不做任何操作
     * property转byte[]字节数时不使用属性的值,对数组的该段数据进行全部填充
     * byte[]转property不解析字节数组,不对属性值进行操作,bean中的属性值是其默认值
     * 特别注意: 只有NOP类型,不会被拦截器所识别
     */
    NOP

}
