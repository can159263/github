//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.26 at 10:06:50 ���� CST 
//


package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HEAD" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_REQUEST_HEAD"/>
 *         &lt;element name="BODY" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_TRANS_DETAIL"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "head",
    "body"
})
@XmlRootElement(name = "B001_REQUEST")
public class B001REQUEST extends CommonRequestMessage{

	private static final long serialVersionUID = 1L;
	@XmlElement(name = "HEAD", required = true)
    protected TREQUESTHEAD head;
    @XmlElement(name = "BODY", required = true)
    protected TTRANSDETAIL body;

    /**
     * Gets the value of the head property.
     * 
     * @return
     *     possible object is
     *     {@link TREQUESTHEAD }
     *     
     */
    public TREQUESTHEAD getHEAD() {
        return head;
    }

    /**
     * Sets the value of the head property.
     * 
     * @param value
     *     allowed object is
     *     {@link TREQUESTHEAD }
     *     
     */
    public void setHEAD(TREQUESTHEAD value) {
        this.head = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link TTRANSDETAIL }
     *     
     */
    public TTRANSDETAIL getBODY() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTRANSDETAIL }
     *     
     */
    public void setBODY(TTRANSDETAIL value) {
        this.body = value;
    }

	@Override
	public TTRANSMSGTYPE getTransType() {
		return TTRANSMSGTYPE.B_001;
	}

	@Override
	public String getArgumentInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
