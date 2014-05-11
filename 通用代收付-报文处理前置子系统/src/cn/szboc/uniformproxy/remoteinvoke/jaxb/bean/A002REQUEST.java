//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.19 at 09:39:31 ���� CST 
//


package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean;

import java.io.Serializable;

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
 *         &lt;element name="BODY">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="COMPANY_CODE" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_CODE"/>
 *                   &lt;element name="COMPANY_NAME" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_NAME"/>
 *                   &lt;element name="COMPANY_LINKMAN" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_LINKMAN"/>
 *                   &lt;element name="COMPANY_TEL" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_TEL"/>
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
@XmlRootElement(name = "A002_REQUEST", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem")
public class A002REQUEST extends CommonRequestMessage{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "HEAD", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
    protected TREQUESTHEAD head;
    @XmlElement(name = "BODY", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
    protected A002REQUEST.BODY body;

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
     *     {@link A002REQUEST.BODY }
     *     
     */
    public A002REQUEST.BODY getBODY() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link A002REQUEST.BODY }
     *     
     */
    public void setBODY(A002REQUEST.BODY value) {
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
     *         &lt;element name="COMPANY_CODE" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_CODE"/>
     *         &lt;element name="COMPANY_NAME" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_NAME"/>
     *         &lt;element name="COMPANY_LINKMAN" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_LINKMAN"/>
     *         &lt;element name="COMPANY_TEL" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_TEL"/>
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
        "companycode",
        "companyname",
        "companylinkman",
        "companytel"
    })
    public static class BODY implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@XmlElement(name = "COMPANY_CODE", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
        protected String companycode;
        @XmlElement(name = "COMPANY_NAME", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
        protected String companyname;
        @XmlElement(name = "COMPANY_LINKMAN", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
        protected String companylinkman;
        @XmlElement(name = "COMPANY_TEL", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
        protected String companytel;

        /**
         * Gets the value of the companycode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMPANYCODE() {
            return companycode;
        }

        /**
         * Sets the value of the companycode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMPANYCODE(String value) {
            this.companycode = value;
        }

        /**
         * Gets the value of the companyname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMPANYNAME() {
            return companyname;
        }

        /**
         * Sets the value of the companyname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMPANYNAME(String value) {
            this.companyname = value;
        }

        /**
         * Gets the value of the companylinkman property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMPANYLINKMAN() {
            return companylinkman;
        }

        /**
         * Sets the value of the companylinkman property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMPANYLINKMAN(String value) {
            this.companylinkman = value;
        }

        /**
         * Gets the value of the companytel property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMPANYTEL() {
            return companytel;
        }

        /**
         * Sets the value of the companytel property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMPANYTEL(String value) {
            this.companytel = value;
        }

    }


	@Override
	public TTRANSMSGTYPE getTransType() {
		return TTRANSMSGTYPE.A_002;
	}

}
