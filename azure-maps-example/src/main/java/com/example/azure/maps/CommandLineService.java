package com.example.azure.maps;

import com.microsoft.azure.maps.sdk.api.model.SearchAddressReverseResponse;
import com.microsoft.azure.maps.sdk.spring.AzureGeocodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineService implements CommandLineRunner {

    @Autowired
    private AzureGeocodingService azureGeocodingService;

    @Override
    public void run(String... args) {
        SearchAddressReverseResponse test = azureGeocodingService.searchAddressReverse(
                "47.641268,-122.125679");
        System.out.println(test);

        SearchAddressReverseResponse test2 = azureGeocodingService.searchAddressReverse(
                "47.641268,-122.125679");
        System.out.println(test2);
    }
}
