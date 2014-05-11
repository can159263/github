//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.16 at 10:28:18 ���� CST 
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
 *                   &lt;element name="TRANS_DATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
@XmlRootElement(name = "C104_REQUEST", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem")
public class C104REQUEST extends CommonRequestMessage{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "HEAD", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
    protected TREQUESTHEAD head;
    @XmlElement(name = "BODY", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
    protected C104REQUEST.BODY body;

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
     *     {@link C104REQUEST.BODY }
     *     
     */
    public C104REQUEST.BODY getBODY() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link C104REQUEST.BODY }
     *     
     */
    public void setBODY(C104REQUEST.BODY value) {
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
     *         &lt;element name="TRANS_DATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "transdate"
    })
    public static class BODY implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@XmlElement(name = "TRANS_DATE", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true, type = String.class)
        @XmlJavaTypeAdapter(Adapter2 .class)
        @XmlSchemaType(name = "date")
        protected Date transdate;

        /**
         * Gets the value of the transdate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public Date getTRANSDATE() {
            return transdate;
        }

        /**
         * Sets the value of the transdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTRANSDATE(Date value) {
            this.transdate = value;
        }

    }


	@Override
	public TTRANSMSGTYPE getTransType() {
		return TTRANSMSGTYPE.C_104;
	}

}
