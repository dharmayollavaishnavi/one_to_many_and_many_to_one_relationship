package com.example;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"deptId", "deptName"})
@Entity
@Table(name = "department")
public class Departmententity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_name")
    private String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Studententity> students;

    public Long getDeptId() 
    {
    	return deptId; 
    }
    public void setDeptId(Long deptId)
    {
    	this.deptId = deptId;
    }
    public String getDeptName() 
    {
    	return deptName; 
    }
    public void setDeptName(String deptName) 
    {
    	this.deptName = deptName;
    }

    public List<Studententity> getStudents() 
    {
    	return students;
    }

    public void setStudents(List<Studententity> students)
    {
        this.students = students; //keeping many students inside department
        if (students != null)
        {
            for (Studententity s : students) //go one student by one in list
            {
                s.setDepartment(this);   //set department inside each std. so both sides are connected.
            }
        }
    }
}