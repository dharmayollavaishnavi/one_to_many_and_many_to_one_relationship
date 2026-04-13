package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository deptRepo;

    public Departmententity addDepartment(Departmententity department)
    {
        return deptRepo.save(department);
    }

    public List<Departmententity> getAll()
    {
    	return deptRepo.findAll();
    }
    
    public Departmententity findDepartment(Long id) 
    {
        return deptRepo.findById(id).orElse(null);
    }
    
    public void deleteStudent(Long id) 
    {
        deptRepo.deleteById(id);
    }

    public List<Departmententity> findByName(String name) 
    {
        return deptRepo.findByDeptName(name);
    }
}