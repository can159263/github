//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.06 at 11:36:23 ���� CST 
//


package cn.szboc.uniformproxy.remoteinvoke.batch.bean.send;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="trade_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="rtn_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="rtn_msg" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "header"
})
@XmlRootElement(name = "root")
public class BatchDeductResponseSendBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
    protected BatchDeductResponseSendBean.Header header;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link BatchDeductResponseSendBean.Header }
     *     
     */
    public BatchDeductResponseSendBean.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchDeductResponseSendBean.Header }
     *     
     */
    public void setHeader(BatchDeductResponseSendBean.Header value) {
        this.header = value;
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
     *         &lt;element name="trade_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="rtn_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="rtn_msg" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "tradeType",
        "rtnCode",
        "rtnMsg"
    })
    public static class Header implements Serializable{

		private static final long serialVersionUID = 1L;
		
		@XmlElement(name = "trade_type", required = true)
        protected String tradeType;
        @XmlElement(name = "rtn_code", required = true)
        protected String rtnCode;
        @XmlElement(name = "rtn_msg", required = true)
        protected String rtnMsg;

        /**
         * Gets the value of the tradeType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTradeType() {
            return tradeType;
        }

        /**
         * Sets the value of the tradeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTradeType(String value) {
            this.tradeType = value;
        }

        /**
         * Gets the value of the rtnCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRtnCode() {
            return rtnCode;
        }

        /**
         * Sets the value of the rtnCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRtnCode(String value) {
            this.rtnCode = value;
        }

        /**
         * Gets the value of the rtnMsg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRtnMsg() {
            return rtnMsg;
        }

        /**
         * Sets the value of the rtnMsg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRtnMsg(String value) {
            this.rtnMsg = value;
        }

    }

}
