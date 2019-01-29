package com.fd.springsoap.endpoint;

import com.fdanismaz.Country;
import com.fdanismaz.Currency;
import com.fdanismaz.GetCountryRequest;
import com.fdanismaz.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author fdanismaz
 * date: 1/27/19 4:52 PM
 */
@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://fdanismaz.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        Country netherlands = new Country();
        netherlands.setName("Netherlands");
        netherlands.setCapital("Amsterdam");
        netherlands.setPopulation(17);
        netherlands.setCurrency(Currency.EUR);
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(netherlands);
        return response;
    }
}
