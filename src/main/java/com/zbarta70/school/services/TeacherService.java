package com.zbarta70.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbarta70.school.models.Teacher;
import com.zbarta70.school.repositories.TeacherRepository;

@Service
public class TeacherService {
		
	@Autowired
	private TeacherRepository teacherRepository;
	
	//Get All Teachers
	public List<Teacher> findAll(){
		return teacherRepository.findAll();
	}	
	
	//Get Teacher By Id
	public Optional<Teacher> findById(int id) {
		return teacherRepository.findById(id);
	}	
	
	//Delete Teacher
	public void delete(int id) {
		teacherRepository.deleteById(id);
	}
	
	//Update Teacher
	public void save( Teacher teacher) {
		teacherRepository.save(teacher);
	}
	
}