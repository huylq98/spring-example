//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.03 at 08:45:11 AM ICT 
//


package com.viettel.vds.springexample.soap.edm;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="amt"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;decimal"&gt;
 *                 &lt;attribute name="cur" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numTokens" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="meter" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="payType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="cash"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ref",
    "amt",
    "numTokens",
    "meter",
    "payType"
})
@XmlRootElement(name = "vendReq")
public class VendReq {

    protected long ref;
    @XmlElement(required = true)
    protected VendReq.Amt amt;
    protected int numTokens;
    @XmlElement(required = true)
    protected String meter;
    @XmlElement(required = true)
    protected String payType;

    /**
     * Gets the value of the ref property.
     * 
     */
    public long getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     */
    public void setRef(long value) {
        this.ref = value;
    }

    /**
     * Gets the value of the amt property.
     * 
     * @return
     *     possible object is
     *     {@link VendReq.Amt }
     *     
     */
    public VendReq.Amt getAmt() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     * 
     * @param value
     *     allowed object is
     *     {@link VendReq.Amt }
     *     
     */
    public void setAmt(VendReq.Amt value) {
        this.amt = value;
    }

    /**
     * Gets the value of the numTokens property.
     * 
     */
    public int getNumTokens() {
        return numTokens;
    }

    /**
     * Sets the value of the numTokens property.
     * 
     */
    public void setNumTokens(int value) {
        this.numTokens = value;
    }

    /**
     * Gets the value of the meter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeter() {
        return meter;
    }

    /**
     * Sets the value of the meter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeter(String value) {
        this.meter = value;
    }

    /**
     * Gets the value of the payType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayType() {
        return payType;
    }

    /**
     * Sets the value of the payType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayType(String value) {
        this.payType = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;decimal"&gt;
     *       &lt;attribute name="cur" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Amt {

        @XmlValue
        protected BigDecimal value;
        @XmlAttribute(name = "cur")
        protected String cur;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValue(BigDecimal value) {
            this.value = value;
        }

        /**
         * Gets the value of the cur property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCur() {
            return cur;
        }

        /**
         * Sets the value of the cur property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCur(String value) {
            this.cur = value;
        }

    }

}