package com.patrik.joacim.Workschedule.controller;

public class CourseNotFoundException extends RuntimeException{
    CourseNotFoundException(Long id){
        super("Could not find course" + id);
    }
}
