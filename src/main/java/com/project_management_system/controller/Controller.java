package com.project_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project_management_system.entity.Project;
import com.project_management_system.servise.Servise;
import com.project_management_system.utils.ResponceStecure;
@ControllerAdvice
@RestController
public class Controller {
	@Autowired
	private Servise servise;
	
	@PostMapping("/projects")
	public ResponceStecure<Project> insertProject(@RequestBody Project project)
	{
		ResponceStecure<Project> responceStecure=new ResponceStecure<Project>();
		responceStecure.setStatusCode(HttpStatus.CREATED.value());
		responceStecure.setMessage("data inserted");
		responceStecure.setData(servise.insertProject(project));
		return responceStecure;
	}
	@GetMapping("/projects/{id}")
	public ResponceStecure<Project> fetchById( @PathVariable("id") int id)
	{
		
		ResponceStecure<Project> responceStecure=new ResponceStecure<Project>();
		responceStecure.setStatusCode(HttpStatus.FOUND.value());
		responceStecure.setMessage("data fetched");
		responceStecure.setData(servise.fetchById(id));
		return responceStecure ;
	} 
	
	@GetMapping("/projects")
	public  List<Project> getAllProjects( )
	{
		return servise.getAllProjects();
	}
	
	
	@DeleteMapping("/projects/{id}")
	public Project deleteById(@PathVariable("id") int id)
	{
	   return servise.deleteById(id);
	}
	
	@PutMapping("/projects/{id}")
	public Project updateProject(@PathVariable("id") int id, @RequestBody Project updateProject) throws Exception
	{
		return servise.updateProject(id, updateProject);
	}

}
