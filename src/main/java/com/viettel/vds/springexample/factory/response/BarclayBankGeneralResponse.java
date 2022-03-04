package com.viettel.vds.springexample.factory.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BarclayBankGeneralResponse<T> implements Serializable {

    @JsonProperty("authStatus")
    private BarclayBankResponseCode responseCode;

    @JsonProperty("results")
    private T results;

    public BarclayBankGeneralResponse(T results) {
        this.results = results;
    }
}
