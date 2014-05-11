//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.18 at 04:12:29 ���� CST 
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


/**
 * <p>Java class for T_BATCH_TRANS_DETAIL_V2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_BATCH_TRANS_DETAIL_V2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TRANS_NO" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_TRANS_NO"/>
 *         &lt;element name="TRANS_DATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ACCOUNT_NO" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_ACCOUNT_NO"/>
 *         &lt;element name="ACCOUNT_NAME" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_ACCOUNT_NAME"/>
 *         &lt;element name="MONEY" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_MONEY"/>
 *         &lt;element name="ID_TYPE" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_ID_TYPE"/>
 *         &lt;element name="ID_NO" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_ID_NO"/>
 *         &lt;element name="AGREEMENT_NO" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_AGREEMENT_NO"/>
 *         &lt;choice>
 *           &lt;element name="COMPANY_CODE" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_CODE"/>
 *           &lt;sequence>
 *             &lt;element name="COMPANY_NAME" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_NAME"/>
 *             &lt;element name="COMPANY_LINKMAN" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_LINKMAN"/>
 *             &lt;element name="COMPANY_TEL" type="{http://www.szboc.cn/projects/open/2012/UniformProxySystem}T_COMPANY_TEL"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="POST_SCRIPT">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
@XmlType(name = "T_BATCH_TRANS_DETAIL_V2", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", propOrder = {
    "transno",
    "transdate",
    "accountno",
    "accountname",
    "money",
    "idtype",
    "idno",
    "agreementno",
    "companycode",
    "companyname",
    "companylinkman",
    "companytel",
    "postscript"
})
public class TBATCHTRANSDETAILV2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "TRANS_NO", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
    protected String transno;
    @XmlElement(name = "TRANS_DATE", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Date transdate;
    @XmlElement(name = "ACCOUNT_NO", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
    protected String accountno;
    @XmlElement(name = "ACCOUNT_NAME", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
    protected String accountname;
    @XmlElement(name = "MONEY", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true)
    protected BigDecimal money;
    @XmlElement(name = "ID_TYPE", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true, nillable = true)
    protected TIDTYPE idtype;
    @XmlElement(name = "ID_NO", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true, nillable = true)
    protected String idno;
    @XmlElement(name = "AGREEMENT_NO", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true, nillable = true)
    protected String agreementno;
    @XmlElement(name = "COMPANY_CODE", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem")
    protected String companycode;
    @XmlElement(name = "COMPANY_NAME", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem")
    protected String companyname;
    @XmlElement(name = "COMPANY_LINKMAN", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem")
    protected String companylinkman;
    @XmlElement(name = "COMPANY_TEL", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem")
    protected String companytel;
    @XmlElement(name = "POST_SCRIPT", namespace = "http://www.szboc.cn/projects/open/2012/UniformProxySystem", required = true, nillable = true)
    protected String postscript;

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

    /**
     * Gets the value of the accountno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCOUNTNO() {
        return accountno;
    }

    /**
     * Sets the value of the accountno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCOUNTNO(String value) {
        this.accountno = value;
    }

    /**
     * Gets the value of the accountname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCOUNTNAME() {
        return accountname;
    }

    /**
     * Sets the value of the accountname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCOUNTNAME(String value) {
        this.accountname = value;
    }

    /**
     * Gets the value of the money property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMONEY() {
        return money;
    }

    /**
     * Sets the value of the money property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMONEY(BigDecimal value) {
        this.money = value;
    }

    /**
     * Gets the value of the idtype property.
     * 
     * @return
     *     possible object is
     *     {@link TIDTYPE }
     *     
     */
    public TIDTYPE getIDTYPE() {
        return idtype;
    }

    /**
     * Sets the value of the idtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link TIDTYPE }
     *     
     */
    public void setIDTYPE(TIDTYPE value) {
        this.idtype = value;
    }

    /**
     * Gets the value of the idno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDNO() {
        return idno;
    }

    /**
     * Sets the value of the idno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDNO(String value) {
        this.idno = value;
    }

    /**
     * Gets the value of the agreementno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAGREEMENTNO() {
        return agreementno;
    }

    /**
     * Sets the value of the agreementno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAGREEMENTNO(String value) {
        this.agreementno = value;
    }

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

    /**
     * Gets the value of the postscript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTSCRIPT() {
        return postscript;
    }

    /**
     * Sets the value of the postscript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTSCRIPT(String value) {
        this.postscript = value;
    }

}
