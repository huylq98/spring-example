package com.viettel.vds.springexample.controller;

import com.viettel.vds.springexample.factory.response.BarclayBankGeneralResponse;
import com.viettel.vds.springexample.factory.response.ResponseFactory;
import com.viettel.vds.springexample.model.dto.request.BarclayBankRequest;
import com.viettel.vds.springexample.model.dto.response.BarclayBankResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EMOLAIPNWrapper")
@RequiredArgsConstructor
public class BarclayBankController {
    private final ResponseFactory responseFactory;

    @PostMapping
    public BarclayBankGeneralResponse<BarclayBankResponse> payment(BarclayBankRequest request) {
        return responseFactory.success(BarclayBankResponse.builder()
                                                          .statusCode(139)
                                                          .statusDescription("Payment pending acknowledgment")
                                                          .payerTransactionID("192800158285")
                                                          .beepTransactionID(2742394)
                                                          .invoiceNumber("-1")
                                                          .build());
    }
}
