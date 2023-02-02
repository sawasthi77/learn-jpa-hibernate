package com.in28minutes.learnjpaandhiberante.course;

import com.in28minutes.learnjpaandhiberante.course.Course;
import com.in28minutes.learnjpaandhiberante.course.jpa.CourseJpaRepository;
import com.in28minutes.learnjpaandhiberante.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "It ends with us", "Collen Hoover"));
        repository.save(new Course(2, "Unpredictable", "Collen Hoover"));
        repository.save(new Course(3, "Dance of Dragons", "R.R. Martin"));

        repository.deleteById(2L);

        System.out.println(repository.findById(3L));
        repository.findById(3L);
    }
}
