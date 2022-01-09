package es.iespuertodelacruz.juan.matriculas.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket institutoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("es.iespuertodelacruz.juan.matriculas.controller"))
                .paths(PathSelectors.any())  //(regex("/api.*"))
                .build()
        		.apiInfo(getApiInfo());
    }
	
	@Primary
	@Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Instituto API REST",
				"API REST para un gestionar un Instituto.",
				"1.0",
				"Términos de servicio",
				new Contact("Juan Daniel Padilla - Adrián Rodríguez",
                		"https://github.com/zclut -- https://github.com/AdrianRodriguez20",
                		"juandanielpadilla0@gmail.com -- adrirodriguezfuentes@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licesen.html",
				Collections.emptyList()
				);
	}
    
}	
