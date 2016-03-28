package com.example;

import com.example.service.LessonRepositoryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan
public class LessonEditorApplication {


    public static void main(String[] args) {
        SpringApplication.run(LessonEditorApplication.class, args);
    }

    @Bean
    @ConditionalOnMissingBean({RestTemplate.class})
    public RestTemplate restTemplate(LoadBalancerInterceptor loadBalancerInterceptor) {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList list = new ArrayList();
        list.add(loadBalancerInterceptor);
        restTemplate.setInterceptors(list);
        return restTemplate;
    }
}


//http://stackoverflow.com/questions/28990517/how-can-i-get-the-discovery-client-working-when-using-spring-cloud-together-with
//https://github.com/joshlong/service-registration-and-discovery
