package com.in28minutes.learnjpaandhiberante.course.jdbc;

import com.in28minutes.learnjpaandhiberante.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;


    private static String insertQuery(Course course){
        String newLine = System.getProperty("line.separator");
        String nextLine = String.format("values(%d,'%s','%s');",course.getId(),course.getName(),course.getAuthor());
        return new StringBuilder()
                .append("insert into course (id,name,author)")
                .append(newLine)
                .append(nextLine)
                .toString();
    }

    private static String deleteQuery(Course course){
        return new StringBuilder()
                .append(String.format("delete from course where id = %d;",course.getId()))
                .toString();
    }

    private static String selectQueryById(long id){
        return new StringBuilder()
                .append(String.format("select * from course where id = %d;",id))
                .toString();
    }

    public void insert(Course course){
        springJdbcTemplate.update(insertQuery(course));
    }

    public void delete(Course course){
        springJdbcTemplate.update(deleteQuery(course));
    }

    public Course findById(long id){
        return springJdbcTemplate.queryForObject(selectQueryById(id),new BeanPropertyRowMapper<>(Course.class));
    }
}
