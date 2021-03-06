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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;


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
 *         &lt;element name="HEAD" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_RESPONSE_HEAD"/>
 *         &lt;element name="BODY">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TRANS_NO" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_TRANS_NO"/>
 *                   &lt;element name="ACCOUNT_DATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlRootElement(name = "B003_RESPONSE")
public class B003RESPONSE extends CommonResponseMessage{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "HEAD", required = true)
    protected TRESPONSEHEAD head;
    @XmlElement(name = "BODY", required = true)
    protected B003RESPONSE.BODY body;

    /**
     * Gets the value of the head property.
     * 
     * @return
     *     possible object is
     *     {@link TRESPONSEHEAD }
     *     
     */
    public TRESPONSEHEAD getHEAD() {
        return head;
    }

    /**
     * Sets the value of the head property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRESPONSEHEAD }
     *     
     */
    public void setHEAD(TRESPONSEHEAD value) {
        this.head = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link B003RESPONSE.BODY }
     *     
     */
    public B003RESPONSE.BODY getBODY() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link B003RESPONSE.BODY }
     *     
     */
    public void setBODY(B003RESPONSE.BODY value) {
        this.body = value;
    }


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
     *         &lt;element name="TRANS_NO" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_TRANS_NO"/>
     *         &lt;element name="ACCOUNT_DATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "transno",
        "accountdate"
    })
    public static class BODY implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@XmlElement(name = "TRANS_NO", required = true, nillable = true)
        protected String transno;
        @XmlElement(name = "ACCOUNT_DATE", required = true, type = String.class, nillable = true)
        @XmlJavaTypeAdapter(Adapter2 .class)
        @XmlSchemaType(name = "date")
        protected Date accountdate;

        /**
         * Gets the value of the transno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTRANSNO() {
            return transno;
        }

        /**
         * Sets the value of the transno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTRANSNO(String value) {
            this.transno = value;
        }

        /**
         * Gets the value of the accountdate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public Date getACCOUNTDATE() {
            return accountdate;
        }

        /**
         * Sets the value of the accountdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setACCOUNTDATE(Date value) {
            this.accountdate = value;
        }

    }

}
