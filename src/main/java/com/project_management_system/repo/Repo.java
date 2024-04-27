package com.project_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project_management_system.entity.Project;
@Repository
public interface Repo extends JpaRepository<Project, Integer>{

}
