package com.patrik.joacim.Workschedule.controller;


import com.patrik.joacim.Workschedule.model.Course;
import com.patrik.joacim.Workschedule.model.Employee;
import com.patrik.joacim.Workschedule.repository.CourseRepository;
import com.patrik.joacim.Workschedule.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://127.0.0.1:5500/")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    EmployeeController(EmployeeRepository employeeRepository, CourseRepository courseRepository){
        this.employeeRepository=employeeRepository;
        this.courseRepository=courseRepository;
    }

    @GetMapping("/employees")
    List<Employee> all(){
        return employeeRepository.findAll();
    }

    @PostMapping("/addemployees")
    Employee newEmployee(@RequestBody Employee newEmployee){
       newEmployee.setActive(true);
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setWorkTime(newEmployee.getWorkTime());
                    employee.setActive(newEmployee.isActive());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new EmployeeNotFoundException(id));
//                .orElseGet(() -> {
//                    newEmployee.setEmployeeId(id);
//                    return employeeRepository.save(newEmployee);
//                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @GetMapping("/employee/employeecourse/{id}")
    public List<Course> history(@PathVariable("id") Long id){
        return courseRepository.findCourseByEmployee_EmployeeId(id);
    }


}
