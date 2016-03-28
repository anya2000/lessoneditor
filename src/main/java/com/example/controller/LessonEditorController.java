package com.example.controller;

import com.example.model.Lesson;
import com.example.service.LessonRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Anya.Grinberg on 3/23/2016.
 */
@RestController
public class LessonEditorController {

    @Autowired
    protected LessonRepositoryService lessonRepositoryService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/lesson/{id}")
    public Lesson getLesson(@PathVariable("id") String id){
        //return new Lesson(id, id);
        return lessonRepositoryService.getLesson(id);
    }


}
