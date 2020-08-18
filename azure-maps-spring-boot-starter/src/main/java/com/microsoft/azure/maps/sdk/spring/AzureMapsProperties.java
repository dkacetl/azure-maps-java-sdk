package com.microsoft.azure.maps.sdk.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "azure-maps")
public class AzureMapsProperties {
    private static final Logger LOGGER = LoggerFactory.getLogger(AzureMapsProperties.class);

    // access key
    private String subscriptionKey;

    // default url to azure maps
    private String url = "https://atlas.microsoft.com/";

    public String getSubscriptionKey() {
        return subscriptionKey;
    }

    public void setSubscriptionKey(String subscriptionKey) {
        this.subscriptionKey = subscriptionKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
