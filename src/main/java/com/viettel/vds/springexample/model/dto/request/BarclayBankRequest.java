package com.viettel.vds.springexample.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BarclayBankRequest {
    private String countryCode;
    private String function;
    private Payload payload;

    @Data
    private static class Payload {
        private Credentials credentials;
        private Packet packet;
    }


    @Data
    private static class Credentials {
        private String username;
        private String password;
    }

    @Data
    private static class Packet {
        private int serviceID;

        @JsonProperty("MSISDN")
        private String msisdn;

        private String invoiceNumber;
        private String accountNumber;
        private String payerTransactionID;
        private BigDecimal amount;
        private String hubID;
        private String narration;
        private LocalDateTime datePaymentReceived;
        private String extraData;
        private String currencyCode;
        private String customerName;
        private String paymentMode;
        private String notifyCustomer;
        private String requestOriginCode;
    }
}
