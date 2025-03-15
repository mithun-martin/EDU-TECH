package com.EdTech.Edtech.repository;

import com.EdTech.Edtech.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo  extends JpaRepository<Course,Long> {
}
