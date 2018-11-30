package pojo;

import java.util.HashSet;
import java.util.Set;

public class Course {
	public Course() {
		
	}
	private Integer id;
	private String name;
	public Course(String name) {
		super();
		this.name = name;
	}
	private Set<Student> stus = new HashSet<Student>();
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
	public Set<Student> getStus() {
		return stus;
	}
	public void setStus(Set<Student> stus) {
		this.stus = stus;
	}
}
