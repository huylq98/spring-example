package com.viettel.vds.springexample.service.webservice;

import com.viettel.vds.springexample.repository.CountryRepository;
import com.viettel.vds.springexample.wsdl.GetCountryRequest;
import com.viettel.vds.springexample.wsdl.GetCountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint // register this class with Spring WS for processing incoming SOAP messages
@RequiredArgsConstructor
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://vds.viettel.com/springexample/wsdl";
    private final CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    // used by Spring WS to pick the handler method, based on namespace and localPart
    @ResponsePayload // makes Spring WS map the returned value to the response payload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) { // incoming message will be mapped to the request parameter
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }
}
