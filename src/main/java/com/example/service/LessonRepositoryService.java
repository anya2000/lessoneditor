package com.example.service;

import com.example.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

/**
 * Created by Anya.Grinberg on 3/23/2016.
 */
@Service
public class LessonRepositoryService {
    public static final String LESSON_SERVICE_URL = "http://CONTENTREPOSITORY";

    @Autowired
    protected RestTemplate restTemplate;

    protected Logger logger = Logger.getLogger(LessonRepositoryService.class.getName());

    public Lesson getLesson(String id){
        return restTemplate.getForObject(LESSON_SERVICE_URL + "/lesson/{number}",
                Lesson.class, id);
    }


    /**
     * The RestTemplate works because it uses a custom request-factory that uses
     * Ribbon to look-up the service to use. This method simply exists to show
     * this.
     */
    @PostConstruct
    public void demoOnly() {
        // Can't do this in the constructor because the RestTemplate injection
        // happens afterwards.
        logger.warning("The RestTemplate request factory is "
                + restTemplate.getRequestFactory());
    }

}
