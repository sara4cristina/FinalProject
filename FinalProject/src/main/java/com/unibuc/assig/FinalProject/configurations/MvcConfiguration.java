package com.unibuc.assig.FinalProject.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Bean(name="simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver()
    {
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();

        r.setDefaultErrorView("error");
        r.setExceptionAttribute("error_msg");     // default "exception"

        //map AnObjectNotFound to error
        Properties mappings = new Properties();
        mappings.setProperty("AnObjectNotFound", "error");
        r.setExceptionMappings(mappings);

        Properties statusCodes = new Properties();
        statusCodes.setProperty("AnObjectNotFound", "404");
        r.setStatusCodes(statusCodes);

        return r;
    }

}

