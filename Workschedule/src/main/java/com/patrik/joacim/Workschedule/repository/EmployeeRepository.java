package com.patrik.joacim.Workschedule.repository;


import com.patrik.joacim.Workschedule.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
