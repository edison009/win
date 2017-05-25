package net.viralpatel.spring.model;




/**
 * The persistent class for the emp_personal_info database table.
 * 
 */
public class EmpPersonalInfo  {


	private int personalId;


	private String address;

	private int age;


	private int genderId;


	private String personName;


	private int stateId;

	public EmpPersonalInfo() {
	}

	public int getPersonalId() {
		return this.personalId;
	}

	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGenderId() {
		return this.genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

}