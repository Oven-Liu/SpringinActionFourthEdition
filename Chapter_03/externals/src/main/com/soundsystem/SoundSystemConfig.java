package com.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Liu Xudong
 * @date 2020-05-14 21:49
 */
@Configuration
@ComponentScan(basePackages = "com")
public class SoundSystemConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
                new PropertySourcesPlaceholderConfigurer();
        ClassPathResource classPathResource = new ClassPathResource("com/soundsystem/app.properties");
        propertySourcesPlaceholderConfigurer.setLocations(classPathResource);
        propertySourcesPlaceholderConfigurer.setLocalOverride(true);
        return propertySourcesPlaceholderConfigurer;
    }
}
