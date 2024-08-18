package com.project.eduvance.Config;

import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class ProjectConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Value("${spring.cloudinary.api_key}")
    String key;

    @Value("${spring.cloudinary.api_secret}")
    String apiSecret;

    @Value("${spring.cloudinary.cloud_name}")
    String cloudName;


    @Bean
    public Cloudinary getCloudinary(){
        Map config=new HashMap();
        config.put("cloud_name",cloudName);
        config.put("api_key",key);
        config.put("api_secret",apiSecret);
        config.put("secure",true);

        return new Cloudinary(config);
    }
}
