package com.zbarta70.school.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbarta70.school.models.Student;
import com.zbarta70.school.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired private StudentService studentService;
	
	//Get All Students
	@GetMapping("students")
	public String findAll(Model model){		
		model.addAttribute("students", studentService.findAll());
		return "student";
	}	
	
	@RequestMapping("/students/findById/{id}") 
	@ResponseBody
	public Optional<Student> findById(@PathVariable(value ="id") Integer id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		return studentService.findById(id);
	}
	
	//Add Student
	@PostMapping(value="students/addNew")
	public String addNew(Student student) {
		studentService.save(student);
		return "redirect:/students";
	}	
	
	@RequestMapping(value="students/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Student student) {
		studentService.save(student);
		return "redirect:/students";
	}
	
	@RequestMapping(value="students/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(@PathVariable(value ="id") Integer id) {
		studentService.delete(id);
		return "redirect:/students";
	}

}
