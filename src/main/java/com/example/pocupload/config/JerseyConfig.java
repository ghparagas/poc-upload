package com.example.pocupload.config;

import com.example.pocupload.resource.HelloResource;
import com.example.pocupload.resource.PdfResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloResource.class);
        register(PdfResource.class);
    }
}