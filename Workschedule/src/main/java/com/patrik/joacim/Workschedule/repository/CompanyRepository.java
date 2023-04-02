package com.patrik.joacim.Workschedule.repository;


import com.patrik.joacim.Workschedule.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
