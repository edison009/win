package net.viralpatel.spring.DAO;

import java.util.List;

import net.viralpatel.spring.model.DegreeMaster;;


public interface DegreeDAO {
	
	public List<DegreeMaster> getDegreeList();
	public DegreeMaster get(int degreeId);
	
}