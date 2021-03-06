//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.26 at 10:06:50 ���� CST 
//


package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_SINGLE_TRANSACTION_RESULT", propOrder = {
    "accountdate",
    "transamt",
    "handlefee",
    "actualdeductamt",
    "handlefeetype"
})
public class TSINGLETRANSACTIONRESULT  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "ACCOUNT_DATE", required = true, type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Date accountdate;
    @XmlElement(name = "TRANS_AMT", required = true, nillable = true)
    protected BigDecimal transamt;
    @XmlElement(name = "HANDLE_FEE", required = true, nillable = true)
    protected BigDecimal handlefee;
    @XmlElement(name = "ACTUAL_DEDUCT_AMT", required = true, nillable = true)
    protected BigDecimal actualdeductamt;
    @XmlElement(name = "HANDLE_FEE_TYPE", required = true, nillable = true)
    protected THANDLEFEETYPE handlefeetype;

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

    /**
     * Gets the value of the transamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTRANSAMT() {
        return transamt;
    }

    /**
     * Sets the value of the transamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTRANSAMT(BigDecimal value) {
        this.transamt = value;
    }

    /**
     * Gets the value of the handlefee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHANDLEFEE() {
        return handlefee;
    }

    /**
     * Sets the value of the handlefee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHANDLEFEE(BigDecimal value) {
        this.handlefee = value;
    }

    /**
     * Gets the value of the actualdeductamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getACTUALDEDUCTAMT() {
        return actualdeductamt;
    }

    /**
     * Sets the value of the actualdeductamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setACTUALDEDUCTAMT(BigDecimal value) {
        this.actualdeductamt = value;
    }

    /**
     * Gets the value of the handlefeetype property.
     * 
     * @return
     *     possible object is
     *     {@link THANDLEFEETYPE }
     *     
     */
    public THANDLEFEETYPE getHANDLEFEETYPE() {
        return handlefeetype;
    }

    /**
     * Sets the value of the handlefeetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link THANDLEFEETYPE }
     *     
     */
    public void setHANDLEFEETYPE(THANDLEFEETYPE value) {
        this.handlefeetype = value;
    }

}
