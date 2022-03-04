package com.viettel.vds.springexample.factory.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {

    public <T> BarclayBankGeneralResponse<T> success(T results) {
        return BarclayBankGeneralResponse.<T>builder()
                                         .responseCode(BarclayBankResponseCode.builder()
                                                                              .authStatusCode(131)
                                                                              .authStatusDescription("Authentication was a success")
                                                                              .build())
                                         .results(results)
                                         .build();
    }
}
