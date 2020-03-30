package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView("display");
		List<Student> list = studentService.findAll();
		modelAndView.addObject("list", list);
		return modelAndView;

	}

	@RequestMapping(value = "getByName", method = RequestMethod.GET)
	public ModelAndView findAllByName() {
		ModelAndView modelAndView = new ModelAndView("getAllName");
		
		modelAndView.addObject("student", new Student());
		return modelAndView;

	}

	@RequestMapping(value = "getByName", method = RequestMethod.POST)
	public ModelAndView findAllByName(@RequestParam(value = "name") String name) {
		ModelAndView modelAndView = new ModelAndView("display");
		List<Student> list = studentService.findByName(name);
		modelAndView.addObject("list", list);
		return modelAndView;

	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView insertPage() {
		ModelAndView modelAndView = new ModelAndView("insert");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute(value = "Student") Student student) {
		ModelAndView modelAndView = new ModelAndView("home-new");
		int update=studentService.create(student);
		if(update>0)
			modelAndView.addObject("actionMessage"," Record Inserted");
		else
			modelAndView.addObject("actionMessage","Record Failed to Insert");
		return modelAndView;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updateStudent() {
		ModelAndView modelAndView = new ModelAndView("update");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute(value = "Student") Student student) {
		ModelAndView modelAndView = new ModelAndView("home-new");
		int update=studentService.update(student);
		if(update>0)
			modelAndView.addObject("actionMessage"," Record Updated");
		else
			modelAndView.addObject("actionMessage","Record Failed to Update");
		return modelAndView;

	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deleteStudent() {
		ModelAndView modelAndView = new ModelAndView("delete");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ModelAndView deleteStudent(@RequestParam(value = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("home-new");
		int update=studentService.delete(id);
		if(update>0)
			modelAndView.addObject("actionMessage"," Record Deleted");
		else
			modelAndView.addObject("actionMessage","Record Failed to Delete");
		return modelAndView;

	}
	@RequestMapping(value = "countAll", method = RequestMethod.GET)
	public ModelAndView countStudents() {
		ModelAndView modelAndView = new ModelAndView("count");
		int update=studentService.countStudent();
		modelAndView.addObject("count", update);
		return modelAndView;
	}

}
