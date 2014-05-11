package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "head", "body" })
@XmlRootElement(name = "C004_RESPONSE")
public class C004RESPONSE extends CommonResponseMessage {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "HEAD", required = true)
	protected TRESPONSEHEAD head;
	@XmlElement(name = "BODY", required = true)
	protected C004RESPONSE.BODY body;

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
	 *     {@link C004RESPONSE.BODY }
	 *     
	 */
	public C004RESPONSE.BODY getBODY() {
		return body;
	}

	/**
	 * Sets the value of the body property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link C004RESPONSE.BODY }
	 *     
	 */
	public void setBODY(C004RESPONSE.BODY value) {
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
	 *         &lt;element name="DETAILS">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
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
	@XmlType(name = "", propOrder = { "details" })
	public static class BODY implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@XmlElement(name = "DETAILS", required = true)
		protected C004RESPONSE.BODY.DETAILS details;

		/**
		 * Gets the value of the details property.
		 * 
		 * @return
		 *     possible object is
		 *     {@link C004RESPONSE.BODY.DETAILS }
		 *     
		 */
		public C004RESPONSE.BODY.DETAILS getDETAILS() {
			return details;
		}

		/**
		 * Sets the value of the details property.
		 * 
		 * @param value
		 *     allowed object is
		 *     {@link C004RESPONSE.BODY.DETAILS }
		 *     
		 */
		public void setDETAILS(C004RESPONSE.BODY.DETAILS value) {
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
		 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
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
		@XmlType(name = "", propOrder = { "detail" })
		public static class DETAILS implements Serializable {

			private static final long serialVersionUID = 1L;
			
			@XmlElement(name = "DETAIL")
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
