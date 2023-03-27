package com.patrik.joacim.Workschedule.repository;


import com.patrik.joacim.Workschedule.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
