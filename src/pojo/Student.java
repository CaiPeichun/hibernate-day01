package pojo;

import java.util.HashSet;
import java.util.Set;

public class Student {
	public Student() {
		
	}
	private Integer id;
	private String name;
	public Student(String name) {
		super();
		this.name = name;
	}
	private Set course = new HashSet<Course>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getCourse() {
		return course;
	}
	public void setCourse(Set course) {
		this.course = course;
	}

}
