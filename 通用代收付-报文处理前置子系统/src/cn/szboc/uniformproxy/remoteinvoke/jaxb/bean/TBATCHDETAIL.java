//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.27 at 10:12:35 ���� CST 
//


package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_BATCH_DETAIL", propOrder = {
    "detail"
})
public class TBATCHDETAIL implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "DETAIL", required = true)
    protected List<TTRANSDETAIL> detail;

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
     * {@link TTRANSDETAIL }
     * 
     * 
     */
    public List<TTRANSDETAIL> getDETAIL() {
        if (detail == null) {
            detail = new ArrayList<TTRANSDETAIL>();
        }
        return this.detail;
    }

}
