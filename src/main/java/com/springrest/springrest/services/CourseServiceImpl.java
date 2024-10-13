package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.Courses;
@Service
public class CourseServiceImpl implements CourseService{
	
	List<Courses> list;
	public CourseServiceImpl(){
         list=new ArrayList<>();
         list.add(new Courses(145,"java course","this course contains basics of java"));
         list.add(new Courses(148,"python course","this course contains basics of python"));
         }

	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
    
	@Override
	public Courses addCourse(Courses course) {
        // Check if a course with the same ID already exists
        for (Courses existingCourse : list) {
            if (existingCourse.getId() == course.getId()) {
                throw new IllegalArgumentException("Course with ID " + course.getId() + " already exists");
            }
        }
        // Add the course if the ID is not found
        list.add(course);
        return course;
    }
}
