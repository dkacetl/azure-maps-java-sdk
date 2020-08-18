package com.example.azure.maps;

import com.microsoft.azure.maps.sdk.api.model.SearchAddressReverseResponse;
import com.microsoft.azure.maps.sdk.api.spring.SearchApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineService implements CommandLineRunner {

    @Autowired
    private SearchApi searchApi;

    @Override
    public void run(String... args) {
        SearchAddressReverseResponse test = searchApi.searchAddressReverse(
                "json",
                args[0],
                "1.0",
                args[1]);
        System.out.println(test);
    }
}
