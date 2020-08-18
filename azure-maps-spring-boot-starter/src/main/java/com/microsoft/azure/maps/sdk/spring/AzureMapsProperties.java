package com.microsoft.azure.maps.sdk.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.List;

@ConfigurationProperties(prefix = "azure-maps")
public class AzureMapsProperties {
    private static final Logger LOGGER = LoggerFactory.getLogger(AzureMapsProperties.class);

    // access keys
    private List<String> subscriptionKey = Collections.emptyList();

    // default url to azure maps
    private String url = "https://atlas.microsoft.com/";

    public List<String> getSubscriptionKey() {
        return subscriptionKey;
    }

    public void setSubscriptionKey(List<String> subscriptionKey) {
        this.subscriptionKey = subscriptionKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
