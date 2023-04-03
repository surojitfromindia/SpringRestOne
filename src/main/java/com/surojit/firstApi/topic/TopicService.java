package com.surojit.firstApi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;
    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public  Topic getTopic(String topic_id){
        return  topicRepository.findById(topic_id).get();
    }
    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(String topicId, Topic new_topic) {
        new_topic.setId(topicId);
        topicRepository.save(new_topic);
    }

    public void deleteTopic(String topicId){
        topicRepository.deleteById(topicId);
    }
}
