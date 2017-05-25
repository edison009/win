package net.viralpatel.spring.model;




/**
 * The persistent class for the degree_master database table.
 * 
 */

public class DegreeMaster {
	
	private int degreeMasterId;
	private String degreeMasterDesc;

	public DegreeMaster() {
	}

	public int getDegreeMasterId() {
		return this.degreeMasterId;
	}

	public void setDegreeMasterId(int degreeMasterId) {
		this.degreeMasterId = degreeMasterId;
	}

	public String getDegreeMasterDesc() {
		return this.degreeMasterDesc;
	}

	public void setDegreeMasterDesc(String degreeMasterDesc) {
		this.degreeMasterDesc = degreeMasterDesc;
	}

}