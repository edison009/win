package net.viralpatel.spring.model;




/**
 * The persistent class for the designation_master database table.
 * 
 */
public class DesignationMaster  {
	

	private int designationMasterId;

	
	private String designationMasterDesc;

	public DesignationMaster() {
	}

	public int getDesignationMasterId() {
		return this.designationMasterId;
	}

	public void setDesignationMasterId(int designationMasterId) {
		this.designationMasterId = designationMasterId;
	}

	public String getDesignationMasterDesc() {
		return this.designationMasterDesc;
	}

	public void setDesignationMasterDesc(String designationMasterDesc) {
		this.designationMasterDesc = designationMasterDesc;
	}

}