//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.27 at 10:12:35 ���� CST 
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
 *                   &lt;element name="BATCH" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_BATCH_HEAD"/>
 *                   &lt;element name="DETAILS" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_BATCH_DETAIL"/>
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
@XmlRootElement(name = "B005_REQUEST")
public class B005REQUEST extends CommonRequestMessage{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "HEAD", required = true)
    protected TREQUESTHEAD head;
    @XmlElement(name = "BODY", required = true)
    protected B005REQUEST.BODY body;

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
     *     {@link B005REQUEST.BODY }
     *     
     */
    public B005REQUEST.BODY getBODY() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link B005REQUEST.BODY }
     *     
     */
    public void setBODY(B005REQUEST.BODY value) {
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
     *         &lt;element name="BATCH" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_BATCH_HEAD"/>
     *         &lt;element name="DETAILS" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_BATCH_DETAIL"/>
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
		
		@XmlElement(name = "BATCH", required = true)
        protected TBATCHHEAD batch;
        @XmlElement(name = "DETAILS", required = true)
        protected TBATCHDETAIL details;

        /**
         * Gets the value of the batch property.
         * 
         * @return
         *     possible object is
         *     {@link TBATCHHEAD }
         *     
         */
        public TBATCHHEAD getBATCH() {
            return batch;
        }

        /**
         * Sets the value of the batch property.
         * 
         * @param value
         *     allowed object is
         *     {@link TBATCHHEAD }
         *     
         */
        public void setBATCH(TBATCHHEAD value) {
            this.batch = value;
        }

        /**
         * Gets the value of the details property.
         * 
         * @return
         *     possible object is
         *     {@link TBATCHDETAIL }
         *     
         */
        public TBATCHDETAIL getDETAILS() {
            return details;
        }

        /**
         * Sets the value of the details property.
         * 
         * @param value
         *     allowed object is
         *     {@link TBATCHDETAIL }
         *     
         */
        public void setDETAILS(TBATCHDETAIL value) {
            this.details = value;
        }

    }


	@Override
	public TTRANSMSGTYPE getTransType() {
		return TTRANSMSGTYPE.B_005;
	}

	@Override
	public String getArgumentInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
