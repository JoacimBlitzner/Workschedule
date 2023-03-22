package com.patrik.joacim.Workschedule.model;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "worktime")
    private int workTime;

    public Employee() {
    }

    public Employee(long employeeId, String firstName, String lastName, int workTime) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.workTime = workTime;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", workTime=" + workTime +
                '}';
    }
}
