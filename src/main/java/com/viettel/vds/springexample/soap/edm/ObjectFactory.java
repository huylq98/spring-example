//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.03 at 08:45:11 AM ICT 
//


package com.viettel.vds.springexample.soap.edm;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.viettel.vds.springexample.soap.edm package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.viettel.vds.springexample.soap.edm
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VendReq }
     * 
     */
    public VendReq createVendReq() {
        return new VendReq();
    }

    /**
     * Create an instance of {@link VendRes }
     * 
     */
    public VendRes createVendRes() {
        return new VendRes();
    }

    /**
     * Create an instance of {@link VendReq.Amt }
     * 
     */
    public VendReq.Amt createVendReqAmt() {
        return new VendReq.Amt();
    }

    /**
     * Create an instance of {@link VendRes.Res }
     * 
     */
    public VendRes.Res createVendResRes() {
        return new VendRes.Res();
    }

    /**
     * Create an instance of {@link VendRes.Util }
     * 
     */
    public VendRes.Util createVendResUtil() {
        return new VendRes.Util();
    }

    /**
     * Create an instance of {@link VendRes.StdToken }
     * 
     */
    public VendRes.StdToken createVendResStdToken() {
        return new VendRes.StdToken();
    }

}