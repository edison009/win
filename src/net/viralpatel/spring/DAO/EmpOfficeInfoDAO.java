package net.viralpatel.spring.DAO;

import net.viralpatel.spring.model.EmpOfficeInfo;

import java.util.Map;

public interface EmpOfficeInfoDAO {
	
	public void saveOrUpdate(EmpOfficeInfo empOfficeInfo);
	
	public Map<Integer,EmpOfficeInfo> getEmpOfficeInfoList();
	
	public EmpOfficeInfo get(int officeId);
	
	public void delete(int officeId);

}
