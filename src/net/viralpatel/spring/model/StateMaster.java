package net.viralpatel.spring.model;





/**
 * The persistent class for the state_master database table.
 * 
 */

public class StateMaster {



	private int stateMasterId;


	private String stateMasterName;

	public StateMaster() {
	}

	public int getStateMasterId() {
		return this.stateMasterId;
	}

	public void setStateMasterId(int stateMasterId) {
		this.stateMasterId = stateMasterId;
	}

	public String getStateMasterName() {
		return this.stateMasterName;
	}

	public void setStateMasterName(String stateMasterName) {
		this.stateMasterName = stateMasterName;
	}

}