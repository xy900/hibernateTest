package com.test.hibernateTest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity   // 
@Table(name="company")
public class Company {
	@Id
	@Column(name="id")
	private int id;
	
	
	@Column(name="name")
	private String name;
	
	// Contection
	@Transient   // 不需要映射的字段
	private List<Person> persons;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}
