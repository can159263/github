//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.26 at 10:06:50 ���� CST 
//


package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "T_STATUS_CODE")
@XmlEnum
public enum TSTATUSCODE {

    @XmlEnumValue("S00")
    S_00("S00"),
    @XmlEnumValue("S01")
    S_01("S01"),
    @XmlEnumValue("S90")
    S_90("S90"),
    @XmlEnumValue("S50")
    S_50("S50"),
    @XmlEnumValue("S51")
    S_51("S51"),
    @XmlEnumValue("S99")
    S_99("S99");
    private final String value;

    TSTATUSCODE(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TSTATUSCODE fromValue(String v) {
        for (TSTATUSCODE c: TSTATUSCODE.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
