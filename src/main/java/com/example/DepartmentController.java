package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/add")
    public Departmententity adddata(@RequestBody Departmententity department) 
    {
        return service.addDepartment(department);
    }

    @GetMapping("/findall")
    public List<Departmententity> findall()
    {
    	return service.getAll();
    }
    @GetMapping("/finddepartmentbyid/{id}")
    public Departmententity getDepartment(@PathVariable Long id) 
    {
        return service.findDepartment(id);
    }

    @DeleteMapping("/deletebyid/{id}")         //delete by dept id
    public String deleteStudent(@PathVariable Long id) 
    {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
    
    @GetMapping("/findbyDeptname/{name}")
    public List<Departmententity> findByName(@PathVariable String name)
    {
        return service.findByName(name);
    }
}