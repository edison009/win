package net.viralpatel.spring.DAO;

import java.util.List;

import net.viralpatel.spring.model.DegreeMaster;
import net.viralpatel.spring.model.DesignationMaster;;


public interface DesignationDAO {
	
	public List<DesignationMaster> getDesignationList();
	public DesignationMaster get(int designationId);

}
