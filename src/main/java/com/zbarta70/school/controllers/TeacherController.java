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

import com.zbarta70.school.models.Teacher;
import com.zbarta70.school.services.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired private TeacherService teacherService;
	
	//Get All Teachers
	@GetMapping("teachers")
	public String findAll(Model model){		
		model.addAttribute("teachers", teacherService.findAll());
		return "teacher";
	}	
	
	@RequestMapping("/teachers/findById/{id}") 
	@ResponseBody
	public Optional<Teacher> findById(@PathVariable(value ="id") Integer id, Model model) {
		model.addAttribute("teacher", teacherService.findById(id));
		return teacherService.findById(id);
	}
	
	//Add Teacher
	@PostMapping(value="teachers/addNew")
	public String addNew(Teacher teacher) {
		teacherService.save(teacher);
		return "redirect:/teachers";
	}	
	
	@RequestMapping(value="teachers/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Teacher teacher) {
		teacherService.save(teacher);
		return "redirect:/teachers";
	}
	
	@RequestMapping(value="teachers/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(@PathVariable(value ="id") Integer id) {
		teacherService.delete(id);
		return "redirect:/teachers";
	}

}
