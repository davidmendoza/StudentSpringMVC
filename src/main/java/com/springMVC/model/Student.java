package com.springMVC.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.springMVC.model.Grades;

@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
    private int id;
	
	@Column(name="FIRST_NAME")
    private String firstName;
	
	@Column(name="LAST_NAME")
    private String lastName;
	
	@Column(name="YEAR_LEVEL")
    private int level;
    
	@OneToOne(cascade={CascadeType.ALL}) @JoinColumn(name="GRADES_ID")
	private Grades grade;
	
	public Student() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Grades getGrade() {
		return grade;
	}

	public void setGrade(Grades grade) {
		this.grade = grade;
	}
	
	
	
}
