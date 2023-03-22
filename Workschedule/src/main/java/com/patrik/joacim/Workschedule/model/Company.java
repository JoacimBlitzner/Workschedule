package com.patrik.joacim.Workschedule.model;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyId;
    @Column(name = "companyname")
    private String companyName;
    @Column(name = "course")
    private String course;
    @Column(name = "workhour")
    private int workHour;
    @Column(name = "startdate")
    private LocalDate startDate;
    @Column(name = "stopdate")
    private LocalDate stopDate;

    public Company() {
    }

    public Company(long companyId, String companyName, String course, int workHour, LocalDate startDate, LocalDate stopDate) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.course = course;
        this.workHour = workHour;
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", course='" + course + '\'' +
                ", workHour=" + workHour +
                ", startDate=" + startDate +
                ", stopDate=" + stopDate +
                '}';
    }
}
