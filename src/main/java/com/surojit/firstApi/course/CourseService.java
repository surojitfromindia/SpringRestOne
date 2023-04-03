package com.surojit.firstApi.course;

import com.surojit.firstApi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourse(String courseId){
        return  courseRepository.findById(courseId).get();
    }
    public void addCourse(Course course, String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseRepository.save(course);
    }

    public void updateCourse(String courseId, Course new_course) {
        new_course.setId(courseId);
        courseRepository.save(new_course);
    }

    public void deleteCourse(String courseId){
        courseRepository.deleteById(courseId);
    }

    public List<Course> getAllCourseOnTopic(String topicId){
        return  courseRepository.findCourseByTopicId(topicId);
    }
}
