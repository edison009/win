package net.viralpatel.spring.DAO;

import java.util.List;

import net.viralpatel.spring.model.GenderMaster;

public interface GenderDAO {

	public List<GenderMaster> getGenderList();
	public GenderMaster get(int genderId);
	
	
}
