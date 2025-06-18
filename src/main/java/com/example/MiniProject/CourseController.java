package com.example.MiniProject;


import com.example.MiniProject.Model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    List<Course> courses = new ArrayList<>();

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        courses.add(course);
        return course;
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable("id") long id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Курс с id " + id + " не найдено!");
    }

    @PutMapping("/courses/{id}")
    public Course changeCourse(@PathVariable("id") long id, @RequestBody Course newCourse) {
        for (Course course : courses) {
            if (course.getId() == id) {
                course.setAuthor(newCourse.getAuthor());
                course.setDescription(newCourse.getDescription());
                course.setDuration(newCourse.getDuration());
                course.setTitle(newCourse.getTitle());
            }
        }

        throw new RuntimeException("Курса с ID " + id + " не найдено!");
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable("id") long id) {
        for (Course course : courses) {
            courses.remove(course);
        }
    }
}
