package com.example;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"studId", "studName"})
@Entity
@Table(name = "student")
public class Studententity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "stud_id")
    private Long studId;

    @Column(name = "stud_name")
    private String studName;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    @JsonBackReference
    private Departmententity department;

    public Long getStudId()
    {
    	return studId; 
    }
    public void setStudId(Long studId) 
    {
    	this.studId = studId;
    }
    public String getStudName() 
    {
    	return studName; 
    }
    public void setStudName(String studName) 
    {
    	this.studName = studName; 
    }
    public Departmententity getDepartment() 
    {
    	return department; 
    }
    public void setDepartment(Departmententity department) 
    {
        this.department = department;
    }
}