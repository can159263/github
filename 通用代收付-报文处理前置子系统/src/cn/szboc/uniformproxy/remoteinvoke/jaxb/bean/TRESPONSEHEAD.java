//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.26 at 10:06:50 ���� CST 
//


package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_RESPONSE_HEAD", propOrder = {
    "syscode",
    "resultcode",
    "resultdesc",
    "sendtimestamp"
})
public class TRESPONSEHEAD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "SYS_CODE", required = true)
    protected String syscode;
    @XmlElement(name = "RESULT_CODE", required = true)
    protected TRESULTCODE resultcode;
    @XmlElement(name = "RESULT_DESC", required = true)
    protected String resultdesc;
    @XmlElement(name = "SEND_TIMESTAMP", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date sendtimestamp;

    /**
     * Gets the value of the syscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSYSCODE() {
        return syscode;
    }

    /**
     * Sets the value of the syscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSYSCODE(String value) {
        this.syscode = value;
    }

    /**
     * Gets the value of the resultcode property.
     * 
     * @return
     *     possible object is
     *     {@link TRESULTCODE }
     *     
     */
    public TRESULTCODE getRESULTCODE() {
        return resultcode;
    }

    /**
     * Sets the value of the resultcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRESULTCODE }
     *     
     */
    public void setRESULTCODE(TRESULTCODE value) {
        this.resultcode = value;
    }

    /**
     * Gets the value of the resultdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESULTDESC() {
        return resultdesc;
    }

    /**
     * Sets the value of the resultdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESULTDESC(String value) {
        this.resultdesc = value;
    }

    /**
     * Gets the value of the sendtimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getSENDTIMESTAMP() {
        return sendtimestamp;
    }

    /**
     * Sets the value of the sendtimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDTIMESTAMP(Date value) {
        this.sendtimestamp = value;
    }

}
