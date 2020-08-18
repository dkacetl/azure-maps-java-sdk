package com.microsoft.azure.maps.sdk.spring;

import com.microsoft.azure.maps.sdk.api.spring.SearchApi;
import com.microsoft.azure.maps.sdk.api.spring.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(
        {AzureMapsProperties.class})
@Import({SearchApi.class})
public class AzureMapsConfiguration {

    private AzureMapsProperties azureMapsProperties;

    public AzureMapsConfiguration(@Autowired AzureMapsProperties azureMapsProperties) {
        this.azureMapsProperties = azureMapsProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public RotatingAzureGeocodingService rotatingAzureMapsService(@Autowired RestTemplateBuilder restTemplateBuilder)
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return new RotatingAzureGeocodingService(restTemplate, azureMapsProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public ApiClient springApiClient(@Autowired RestTemplateBuilder restTemplateBuilder)
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ApiClient springApiClient = new ApiClient(restTemplate);

        springApiClient.setBasePath(azureMapsProperties.getUrl());
        springApiClient.setApiKey(azureMapsProperties.getSubscriptionKey().get(0));
        return springApiClient;
    }
}
