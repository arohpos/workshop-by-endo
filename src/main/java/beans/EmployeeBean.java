/**
 * 
 */
package beans;

import java.io.Serializable;

public class EmployeeBean implements Serializable{

	private int id;
	private String name;
	private int age;
	private String department;

	public EmployeeBean(int id, String name, int age, String department) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
	}
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "名前：" + this.name + "\t年齢：" + this.age + "\t部署：" + this.department;
	}
	
}
