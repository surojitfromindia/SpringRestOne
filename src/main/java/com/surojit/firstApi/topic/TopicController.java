package com.surojit.firstApi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return  topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable("id") String id){
        return  topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public  void updateTopic(@RequestBody Topic topic, @PathVariable("id") String topic_id){
        topicService.updateTopic(topic_id,topic);
    }

    @DeleteMapping("/topics/{id}")
    public  void deleteTopic(@PathVariable("id") String topicId){
        topicService.deleteTopic(topicId);
    }
}
