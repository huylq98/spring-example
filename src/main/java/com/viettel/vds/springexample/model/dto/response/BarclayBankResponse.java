package com.viettel.vds.springexample.model.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BarclayBankResponse {
    private int statusCode;
    private String statusDescription;
    private String payerTransactionID;
    private long beepTransactionID;
    private String invoiceNumber;
}
