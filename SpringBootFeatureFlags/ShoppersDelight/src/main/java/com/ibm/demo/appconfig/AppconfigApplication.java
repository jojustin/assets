package com.ibm.demo.appconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.http.CacheControl;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.ibm.demo.appconfig.properties.PropertiesBackedFeatureFlagService;

@SpringBootApplication
@EnableConfigurationProperties(PropertiesBackedFeatureFlagService.class)
public class AppconfigApplication implements WebMvcConfigurer {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Register resource handler for images
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }

	public static void main(String[] args) {
		SpringApplication.run(AppconfigApplication.class, args);
	}

}
