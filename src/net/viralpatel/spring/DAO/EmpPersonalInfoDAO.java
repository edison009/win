package net.viralpatel.spring.DAO;

import java.util.Map;

import net.viralpatel.spring.model.EmpPersonalInfo;

public interface EmpPersonalInfoDAO {
	
	public int saveOrUpdate(EmpPersonalInfo empPersonalInfo);
	
	public Map<Integer,EmpPersonalInfo> getEmpPersonalInfoList();
	
	public EmpPersonalInfo get(int personalId);
	
	public void delete(int personalId);

}
