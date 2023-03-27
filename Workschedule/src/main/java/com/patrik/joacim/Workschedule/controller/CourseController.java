package com.patrik.joacim.Workschedule.controller;


import com.patrik.joacim.Workschedule.model.Course;
import com.patrik.joacim.Workschedule.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://127.0.0.1:5500/")
public class CourseController {

    private final CourseRepository courseRepository;

    CourseController(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    @GetMapping("/course")
    List<Course> all(){
        return courseRepository.findAll();
    }

    @PostMapping("/addcourse")
    Course newCourse(@RequestBody Course newCourse){
        return courseRepository.save(newCourse);
    }

    @GetMapping("/course/{id}")
    Course one(@PathVariable Long id) {

        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    @PutMapping("/course/{id}")
    Course replaceCompany(@RequestBody Course newCourse, @PathVariable Long id) {

        return courseRepository.findById(id)
                .map(course -> {
                    course.setCourseName(newCourse.getCourseName());
                    course.setWorkHour(newCourse.getWorkHour());
                    course.setStartDate(newCourse.getStartDate());
                    course.setStopDate(newCourse.getStopDate());

                    return courseRepository.save(course);
                })
                .orElseGet(() -> {
                    newCourse.setCourseId(id);
                    return courseRepository.save(newCourse);
                });
    }

    @DeleteMapping("/course/{id}")
    void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
}
