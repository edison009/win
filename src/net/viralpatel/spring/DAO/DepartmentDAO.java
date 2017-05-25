package net.viralpatel.spring.DAO;

import java.util.List;

import net.viralpatel.spring.model.DepartmentMaster;

public interface DepartmentDAO {
	
	public List<DepartmentMaster> getDeptartmentList();
	
	public DepartmentMaster get(int departmentId);

}
