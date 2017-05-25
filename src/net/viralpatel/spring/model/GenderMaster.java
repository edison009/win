package net.viralpatel.spring.model;




/**
 * The persistent class for the gender_master database table.
 * 
 */

public class GenderMaster {


	private int genderId;

	private String genderDesc;

	public GenderMaster() {
	}

	public int getGenderId() {
		return this.genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGenderDesc() {
		return this.genderDesc;
	}

	public void setGenderDesc(String genderDesc) {
		this.genderDesc = genderDesc;
	}

}