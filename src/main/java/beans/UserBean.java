/**
 * 
 */
package beans;

import java.io.Serializable;

public class UserBean implements Serializable{

	private String name;
	private int age;
	private Gender gender;
	
	public UserBean() {
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "名前：" + this.name + "\t年齢：" + this.age + "\t性別：" + this.gender;
	}
	
}
