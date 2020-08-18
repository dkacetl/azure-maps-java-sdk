package com.microsoft.azure.maps.sdk.spring;

import com.microsoft.azure.maps.sdk.api.model.SearchAddressReverseResponse;
import com.microsoft.azure.maps.sdk.api.spring.SearchApi;
import com.microsoft.azure.maps.sdk.api.spring.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class RotatingAzureGeocodingService implements AzureGeocodingService {

    private int index;
    private SearchApi[] searchApiArray;

    private RestTemplate restTemplate;

    private AzureMapsProperties azureMapsProperties;

    @Autowired
    public RotatingAzureGeocodingService(RestTemplate restTemplate, AzureMapsProperties azureMapsProperties) {
        this.restTemplate = restTemplate;
        this.azureMapsProperties = azureMapsProperties;

        if ((azureMapsProperties.getSubscriptionKey()==null) ||
            (azureMapsProperties.getSubscriptionKey().size()==0)) {
            throw new IllegalStateException("No subscriptionKey defined.");
        }

        searchApiArray = new SearchApi[azureMapsProperties.getSubscriptionKey().size()];

        int i=0;
        for (String key: azureMapsProperties.getSubscriptionKey()) {
            ApiClient apiClient = new ApiClient(restTemplate);
            apiClient.setApiKey(key);
            searchApiArray[i]=new SearchApi(apiClient);
            i++;
        }
    }

    public SearchAddressReverseResponse searchAddressReverse(String query) throws RestClientException {
        SearchAddressReverseResponse searchAddressReverseResponse = searchApiArray[index].searchAddressReverse("json", query, "1.0");
        index = (++index)% searchApiArray.length;
        return searchAddressReverseResponse;
    }

}
