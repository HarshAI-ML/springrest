package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courservice;
	@GetMapping("/home")
	public String home() {
		
		return "this is home page";
	}
	@GetMapping("/courses")
	public List<Courses> getcourses()
	{
		return this.courservice.getCourses();
	}
	@PostMapping("/courses")
	public ResponseEntity<?> addCourse(@RequestBody Courses course) {
        try {
            Courses addedCourse = this.courservice.addCourse(course);
            return ResponseEntity.ok(addedCourse); // Return 200 OK if successful
        } catch (IllegalArgumentException e) {
            // Return a 400 Bad Request with the error message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
