package com.surojit.firstApi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public List<Course> getAllCourse(){
        return  courseService.getAllCourses();
    }

    @GetMapping("/topic/{topicId}/course")
    public List<Course> getAllCourseByTopicId(@PathVariable String topicId){
        return  courseService.getAllCourseOnTopic(topicId);
    }


    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable("id") String id){
        return  courseService.getCourse(id);
    }

    @PostMapping("/course/{topicId}")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        courseService.addCourse(course, topicId);
    }

    @PutMapping("/course/{id}")
    public  void updateCourse(@RequestBody Course course, @PathVariable("id") String topic_id){
        courseService.updateCourse(topic_id, course);
    }

    @DeleteMapping("/course/{id}")
    public  void deleteCourse(@PathVariable("id") String topicId){
        courseService.deleteCourse(topicId);
    }
}
