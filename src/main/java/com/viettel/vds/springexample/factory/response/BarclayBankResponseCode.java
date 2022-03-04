package com.viettel.vds.springexample.factory.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BarclayBankResponseCode {
    @JsonProperty("authStatusCode")
    private int authStatusCode;

    @JsonProperty("authStatusDescription")
    private String authStatusDescription;
}
