package com.project_management_system.servise;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project_management_system.entity.Project;
import com.project_management_system.repo.Repo;

@Service
public class Servise {
	@Autowired
	private Repo repo;
	
	public Project insertProject(Project project)
	{
		return repo.save(project);
	}
	public Project fetchById(int id)
	{
		return repo.findById(id).get();
	}
	
	public List<Project> getAllProjects() {

		return repo.findAll();
	}
	
	public Project deleteById(int id)
	{
	   Project project=(Project)repo.findById(id).get();
	   repo.delete(project);
	   return project;
	}
	
	
	public Project updateProject(int id, Project updateProject) throws Exception {
	  
	    if (updateProject == null) {
	        throw new IllegalArgumentException("updateProject cannot be null");
	    }
	    
	    Optional<Project> optionalProject = repo.findById(id);
	    
	  
	    if (optionalProject.isPresent()) {
	        Project project = optionalProject.get();
	        
	        project.setName(updateProject.getName());
	        project.setDescription(updateProject.getDescription());
	        project.setStartDate(updateProject.getStartDate());
	        project.setEndDate(updateProject.getEndDate());
	        project.setTeamLeadName(updateProject.getTeamLeadName());
	        project.setTeamCount(updateProject.getTeamCount());
	        
	        
	        repo.save(project);
	        
	        return project;
	    } else {
	        throw new Exception("Project with id " + id + " not found");
	    }
	}

	
	

}
