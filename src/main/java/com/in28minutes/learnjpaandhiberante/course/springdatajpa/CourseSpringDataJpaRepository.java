package com.in28minutes.learnjpaandhiberante.course.springdatajpa;

import com.in28minutes.learnjpaandhiberante.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
}
