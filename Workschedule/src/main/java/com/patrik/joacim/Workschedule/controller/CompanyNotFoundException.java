package com.patrik.joacim.Workschedule.controller;

public class CompanyNotFoundException extends RuntimeException{
    CompanyNotFoundException(Long id){
        super("Could not find company" + id);
    }
}
