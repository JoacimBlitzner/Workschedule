package com.patrik.joacim.Workschedule.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "coursename")
    private String courseName;
    @Column(name = "workhour")
    private int workHour;
    @Column(name = "startdate")
    private LocalDate startDate;
    @Column(name = "stopdate")
    private LocalDate stopDate;

    @ManyToOne()
    @JsonBackReference(value = "company-course")
    private Company company;

    @ManyToOne()
    @JsonBackReference(value = "employee-course")
    private Employee employee;

    public Course() {
    }

    public Course(Long courseId, String courseName, int workHour, LocalDate startDate, LocalDate stopDate, Company company, Employee employee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.workHour = workHour;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.company = company;
        this.employee = employee;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStopDate() {
        return stopDate;
    }

    public void setStopDate(LocalDate stopDate) {
        this.stopDate = stopDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", workHour=" + workHour +
                ", startDate=" + startDate +
                ", stopDate=" + stopDate +
                ", company=" + company +
                ", employee=" + employee +
                '}';
    }
}
