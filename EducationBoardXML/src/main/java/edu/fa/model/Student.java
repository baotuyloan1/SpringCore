package edu.fa.model;

public class Student {
	private String name;
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return name + " - " + location;
	}

}
