package com.microsoft.azure.maps.sdk.spring;

import com.microsoft.azure.maps.sdk.api.model.SearchAddressReverseResponse;

import org.springframework.web.client.RestClientException;

public interface AzureGeocodingService {

    SearchAddressReverseResponse searchAddressReverse(String query) throws RestClientException;
}
