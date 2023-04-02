package com.patrik.joacim.Workschedule.controller;


import com.patrik.joacim.Workschedule.model.Company;
import com.patrik.joacim.Workschedule.model.Course;
import com.patrik.joacim.Workschedule.model.Employee;
import com.patrik.joacim.Workschedule.repository.CompanyRepository;
import com.patrik.joacim.Workschedule.repository.CourseRepository;
import com.patrik.joacim.Workschedule.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://127.0.0.1:5500/")
public class CourseController {

    private final CourseRepository courseRepository;
    private final EmployeeRepository employeeRepository;

    private final CompanyRepository companyRepository;

    CourseController(CourseRepository courseRepository, EmployeeRepository employeeRepository, CompanyRepository companyRepository){
        this.courseRepository=courseRepository;
        this.employeeRepository=employeeRepository;
        this.companyRepository=companyRepository;
    }

    @GetMapping("/course")
    List<Course> all(){
        List<Course>courses = courseRepository.findAll();
        System.out.println(courses);
        return courseRepository.findAll();

    }


    @PostMapping("/addcourse")
    Course newCourse(@RequestBody Course newCourse){
        Employee employee = employeeRepository.findById(newCourse.getEmployee().getEmployeeId()).orElseThrow(() -> new RuntimeException("EMP i course"));
        Company company = companyRepository.findById(newCourse.getCompany().getCompanyId()).orElseThrow(() -> new RuntimeException("COMPANY i course"));
        newCourse.setEmployee(employee);
        newCourse.setCompany(company);
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
                    course.setCourseClass(newCourse.getCourseClass());
                    course.setWorkHour(newCourse.getWorkHour());
                    course.setStartDate(newCourse.getStartDate());
                    course.setStopDate(newCourse.getStopDate());
                    course.setCompany(newCourse.getCompany());
                    course.setEmployee(newCourse.getEmployee());
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


    @PutMapping("/courseaddemp/{id}")
    Course addEmp(@RequestBody Course newCourse, @PathVariable Long id) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setEmployee(newCourse.getEmployee());
                    return courseRepository.save(course);
                })
                .orElseGet(() -> {
                    newCourse.setCourseId(id);
                    return courseRepository.save(newCourse);
                });
    }
}