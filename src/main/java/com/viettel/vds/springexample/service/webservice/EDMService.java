package com.viettel.vds.springexample.service.webservice;

import com.viettel.vds.springexample.soap.edm.VendReq;
import com.viettel.vds.springexample.soap.edm.VendRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;

@Endpoint
@Slf4j
public class EDMService {

    private static final String NAMESPACE_URI = "http://vds.viettel.com/springexample/soap/edm";
    private static final String LOCAL_PART = "vendReq";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART)
    @ResponsePayload
    public VendRes payment(@RequestPayload VendReq vendReq) {
        log.info("Request Payload: {ref={}, amt={}, numTokens={}, meter={}, payType={}}", vendReq.getRef(), vendReq.getAmt()
                                                                                                                   .getValue(), vendReq.getNumTokens(), vendReq.getMeter(), vendReq.getPayType());
        VendRes.Res res = new VendRes.Res();
        res.setCode("elec000");
        res.setValue("OK");

        VendRes.Util util = new VendRes.Util();
        util.setAddr("");
        util.setTaxRef(600000063L);
        util.setDistId("2080000000001");
        util.setValue("EDM EP : Maputo Cidade");

        VendRes.StdToken stdToken = new VendRes.StdToken();
        stdToken.setUnits(6D);
        stdToken.setAmt(new BigDecimal(4524));
        stdToken.setTax(new BigDecimal(476));
        stdToken.setDesc("Res Step 0Res Step 0");
        stdToken.setRctNum("EMOLAMPDB75322948");
        stdToken.setValue("13051848180630442465");

        VendRes vendRes = new VendRes();
        vendRes.setRef(19290241434L);
        vendRes.setRes(res);
        vendRes.setUtil(util);
        vendRes.setTariff("EDM-ASCCHKDomestico-TI1");
        vendRes.setStdToken(stdToken);
        vendRes.setCustomerMsg("Credit Vend");

        log.info("Response Payload: {ref={}, resCode={}, resDesc={}}", vendRes.getRef(), vendRes.getRes()
                                                                                                .getCode(), vendRes.getRes()
                                                                                                                   .getValue());
        return vendRes;
    }
}
