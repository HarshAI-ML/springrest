package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entity.Courses;

public interface CourseService {

	public List<Courses> getCourses();
	
	public Courses addCourse(Courses course);
}
