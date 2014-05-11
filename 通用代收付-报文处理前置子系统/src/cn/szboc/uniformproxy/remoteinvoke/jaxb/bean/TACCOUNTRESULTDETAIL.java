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
@XmlType(name = "T_ACCOUNT_RESULT_DETAIL", propOrder = {
    "transno",
    "transstatus",
    "transmsgtype",
    "transamt",
    "handlefee",
    "actualdeductamt",
    "handlefeetype",
    "accountdate",
    "transdesc"
})
public class TACCOUNTRESULTDETAIL implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "TRANS_NO", required = true, nillable = true)
    protected String transno;
    @XmlElement(name = "TRANS_STATUS", required = true, nillable = true)
    protected TSTATUSCODE transstatus;
    @XmlElement(name = "TRANS_MSG_TYPE", required = true, nillable = true)
    protected TTRANSMSGTYPE transmsgtype;
    @XmlElement(name = "TRANS_AMT", required = true, nillable = true)
    protected BigDecimal transamt;
    @XmlElement(name = "HANDLE_FEE", required = true, nillable = true)
    protected BigDecimal handlefee;
    @XmlElement(name = "ACTUAL_DEDUCT_AMT", required = true, nillable = true)
    protected BigDecimal actualdeductamt;
    @XmlElement(name = "HANDLE_FEE_TYPE", required = true, nillable = true)
    protected THANDLEFEETYPE handlefeetype;
    @XmlElement(name = "ACCOUNT_DATE", required = true, type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Date accountdate;
    @XmlElement(name = "TRANS_DESC", required = true, nillable = true)
    protected String transdesc;

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
     * Gets the value of the transstatus property.
     * 
     * @return
     *     possible object is
     *     {@link TSTATUSCODE }
     *     
     */
    public TSTATUSCODE getTRANSSTATUS() {
        return transstatus;
    }

    /**
     * Sets the value of the transstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSTATUSCODE }
     *     
     */
    public void setTRANSSTATUS(TSTATUSCODE value) {
        this.transstatus = value;
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
     * Gets the value of the transdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSDESC() {
        return transdesc;
    }

    /**
     * Sets the value of the transdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSDESC(String value) {
        this.transdesc = value;
    }

}
