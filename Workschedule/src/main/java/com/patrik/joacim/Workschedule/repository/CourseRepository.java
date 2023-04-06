package com.patrik.joacim.Workschedule.repository;


import com.patrik.joacim.Workschedule.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCourseByCompany_CompanyId(Long id);
//    List<Course> findCourseByCompany_CompanyIdAndEmployee(Long id);

}
