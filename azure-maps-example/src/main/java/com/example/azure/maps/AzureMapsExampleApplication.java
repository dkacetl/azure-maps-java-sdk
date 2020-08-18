package com.example.azure.maps;

import com.microsoft.azure.maps.sdk.spring.EnableAzureMapsClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
@EnableAzureMapsClient
public class AzureMapsExampleApplication {
    public static void main(String[] args) {
        // It is a global-world service, set UTC as local time.
        // all date/times will be stored in UTC.
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        SpringApplication springApplication = new SpringApplication(AzureMapsExampleApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }
}
