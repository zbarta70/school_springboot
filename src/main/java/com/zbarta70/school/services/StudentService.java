package com.zbarta70.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbarta70.school.models.Student;
import com.zbarta70.school.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	//Get All Students
	public List<Student> findAll(){
		return studentRepository.findAll();
	}	
	
	//Get Student By Id
	public Optional<Student> findById(int id) {
		return studentRepository.findById(id);
	}	
	
	//Delete Student
	public void delete(int id) {
		studentRepository.deleteById(id);
	}
	
	//Update Student
	public void save( Student student) {
		studentRepository.save(student);
	}

}
