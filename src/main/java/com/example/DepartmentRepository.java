package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departmententity, Long> 
{
	  List<Departmententity> findByDeptName(String name);
}