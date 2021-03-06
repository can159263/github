//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.28 at 12:50:36 ���� CST 
//


package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *                   &lt;element name="BATCH">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PACK_NO" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_PACK_NO"/>
 *                             &lt;element name="TRANS_MSG_TYPE" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_TRANS_MSG_TYPE"/>
 *                             &lt;element name="COUNT">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
 *                                   &lt;minInclusive value="1"/>
 *                                   &lt;maxInclusive value="2000"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="SUM" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_MONEY"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DETAILS">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="DETAIL" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_ACCOUNT_RESULT_DETAIL"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlRootElement(name = "C003_RESPONSE")
public class C003RESPONSE extends CommonResponseMessage{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "HEAD", required = true)
    protected TRESPONSEHEAD head;
    @XmlElement(name = "BODY", required = true)
    protected C003RESPONSE.BODY body;

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
     *     {@link C003RESPONSE.BODY }
     *     
     */
    public C003RESPONSE.BODY getBODY() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link C003RESPONSE.BODY }
     *     
     */
    public void setBODY(C003RESPONSE.BODY value) {
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
     *         &lt;element name="BATCH">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PACK_NO" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_PACK_NO"/>
     *                   &lt;element name="TRANS_MSG_TYPE" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_TRANS_MSG_TYPE"/>
     *                   &lt;element name="COUNT">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
     *                         &lt;minInclusive value="1"/>
     *                         &lt;maxInclusive value="2000"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="SUM" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_MONEY"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DETAILS">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence maxOccurs="unbounded">
     *                   &lt;element name="DETAIL" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_ACCOUNT_RESULT_DETAIL"/>
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
        "batch",
        "details"
    })
    public static class BODY implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@XmlElement(name = "BATCH", required = true, nillable = true)
        protected C003RESPONSE.BODY.BATCH batch;
        @XmlElement(name = "DETAILS", required = true, nillable = true)
        protected C003RESPONSE.BODY.DETAILS details;

        /**
         * Gets the value of the batch property.
         * 
         * @return
         *     possible object is
         *     {@link C003RESPONSE.BODY.BATCH }
         *     
         */
        public C003RESPONSE.BODY.BATCH getBATCH() {
            return batch;
        }

        /**
         * Sets the value of the batch property.
         * 
         * @param value
         *     allowed object is
         *     {@link C003RESPONSE.BODY.BATCH }
         *     
         */
        public void setBATCH(C003RESPONSE.BODY.BATCH value) {
            this.batch = value;
        }

        /**
         * Gets the value of the details property.
         * 
         * @return
         *     possible object is
         *     {@link C003RESPONSE.BODY.DETAILS }
         *     
         */
        public C003RESPONSE.BODY.DETAILS getDETAILS() {
            return details;
        }

        /**
         * Sets the value of the details property.
         * 
         * @param value
         *     allowed object is
         *     {@link C003RESPONSE.BODY.DETAILS }
         *     
         */
        public void setDETAILS(C003RESPONSE.BODY.DETAILS value) {
            this.details = value;
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
         *         &lt;element name="PACK_NO" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_PACK_NO"/>
         *         &lt;element name="TRANS_MSG_TYPE" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_TRANS_MSG_TYPE"/>
         *         &lt;element name="COUNT">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
         *               &lt;minInclusive value="1"/>
         *               &lt;maxInclusive value="2000"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="SUM" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_MONEY"/>
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
            "packno",
            "transmsgtype",
            "count",
            "sum"
        })
        public static class BATCH implements Serializable {

			private static final long serialVersionUID = 1L;
			
			@XmlElement(name = "PACK_NO", required = true)
            protected String packno;
            @XmlElement(name = "TRANS_MSG_TYPE", required = true)
            protected TTRANSMSGTYPE transmsgtype;
            @XmlElement(name = "COUNT")
            protected int count;
            @XmlElement(name = "SUM", required = true)
            protected BigDecimal sum;

            /**
             * Gets the value of the packno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPACKNO() {
                return packno;
            }

            /**
             * Sets the value of the packno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPACKNO(String value) {
                this.packno = value;
            }

            /**
             * Gets the value of the transmsgtype property.
             * 
             * @return
             *     possible object is
             *     {@link TTRANSMSGTYPE }
             *     
             */
            public TTRANSMSGTYPE getTRANSMSGTYPE() {
                return transmsgtype;
            }

            /**
             * Sets the value of the transmsgtype property.
             * 
             * @param value
             *     allowed object is
             *     {@link TTRANSMSGTYPE }
             *     
             */
            public void setTRANSMSGTYPE(TTRANSMSGTYPE value) {
                this.transmsgtype = value;
            }

            /**
             * Gets the value of the count property.
             * 
             */
            public int getCOUNT() {
                return count;
            }

            /**
             * Sets the value of the count property.
             * 
             */
            public void setCOUNT(int value) {
                this.count = value;
            }

            /**
             * Gets the value of the sum property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getSUM() {
                return sum;
            }

            /**
             * Sets the value of the sum property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setSUM(BigDecimal value) {
                this.sum = value;
            }

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
         *       &lt;sequence maxOccurs="unbounded">
         *         &lt;element name="DETAIL" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_ACCOUNT_RESULT_DETAIL"/>
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
            "detail"
        })
        public static class DETAILS implements Serializable {

			private static final long serialVersionUID = 1L;
			
			@XmlElement(name = "DETAIL", required = true)
            protected List<TACCOUNTRESULTDETAIL> detail;

            /**
             * Gets the value of the detail property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the detail property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDETAIL().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TACCOUNTRESULTDETAIL }
             * 
             * 
             */
            public List<TACCOUNTRESULTDETAIL> getDETAIL() {
                if (detail == null) {
                    detail = new ArrayList<TACCOUNTRESULTDETAIL>();
                }
                return this.detail;
            }

        }

    }

}
