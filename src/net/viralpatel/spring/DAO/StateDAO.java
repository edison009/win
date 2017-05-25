package net.viralpatel.spring.DAO;

import java.util.List;

import net.viralpatel.spring.model.StateMaster;

public interface StateDAO {
	
	public List<StateMaster> getStateList();
	public StateMaster get(int stateId);
	

}
