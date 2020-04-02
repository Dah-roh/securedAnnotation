package com.sample.securedtesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Configuration
@EnableSwagger2
public class SwaggerConfig {



    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sample.securedtesting"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public UiConfiguration uiConfig(){
        return new UiConfiguration(Boolean.TRUE, Boolean.FALSE,
                1, 1, ModelRendering.MODEL,
                Boolean.FALSE, DocExpansion.LIST, Boolean.FALSE, null,
                OperationsSorter.ALPHA, Boolean.FALSE,
                TagsSorter.ALPHA, UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, null);
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("Global Method Security Api Documentation", "Global Method Security Api Documentation",
                "1.0", "urn:tos", new Contact("", "", ""),
                "Apache 2.0", "http://www.apache.org/license/LICENSE-2.0", new ArrayList<VendorExtension>());
    }



}
