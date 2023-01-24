package com.xadmin.SpringBootCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SpringBootCrud.bean.Subject;
import com.xadmin.SpringBootCrud.service.SubjectService;

import java.util.List;

@RestController
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("hasRole('ADMIN'")
	@RequestMapping("/subjects")
	public List<Subject> getAllSubjects()
	{
		return subjectService.getAllSubjects();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/subjects")
	public void addSubject(@RequestBody Subject subject)
	{
		subjectService.addSubject(subject);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/subjects/{id}")
	public void updateSubject(@PathVariable String id ,@RequestBody Subject subject)
	{
		subjectService.updateSubject(id , subject);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/subjects/{id}")
	public void DeleteSubject(@PathVariable String id)
	{
		subjectService.deleteSubject(id);
	}
}
