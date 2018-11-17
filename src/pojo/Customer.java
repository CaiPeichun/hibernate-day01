package pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//@Entity
//@Table(name="customer")
public class Customer {

	private int id;
	private String name;
	private int age;
	private Set<MyOrder> orders = new HashSet<MyOrder>();

	public Set<MyOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<MyOrder> orders) {
		this.orders = orders;
	}
	//	@Id
//	@SequenceGenerator(name="MYSEQ_SEQUENCE",sequenceName="MYSEQ_SEQUENCE",allocationSize=1)
//	@GeneratedValue(generator="MYSEQ_SEQUENCE",strategy=GenerationType.SEQUENCE)
//	@Column(name="ID",unique=true,nullable=false,precision=22,scale=0)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	@Column(name="age")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	

}
