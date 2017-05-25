package net.viralpatel.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import net.viralpatel.spring.model.EmpOfficeInfo;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmpOfficeInfoDAOImpl implements EmpOfficeInfoDAO{
	
private JdbcTemplate jdbcTemplate;
	
	public EmpOfficeInfoDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(EmpOfficeInfo empOfficeInfo) {
		// TODO Auto-generated method stub
		String sql="";
		if(empOfficeInfo.getOfficeId()!=0)
		{
			sql="update emp_office_info set personal_id=?,dept_id=?,design_id=?,degree_id=?,salary=?,doj=? where office_id=?";
			jdbcTemplate.update(sql,empOfficeInfo.getPersonalId(),empOfficeInfo.getDeptId(),empOfficeInfo.getDesignId(),empOfficeInfo.getDegreeId(),empOfficeInfo.getSalary(),empOfficeInfo.getDoj(),empOfficeInfo.getOfficeId());
		}
		else
		{
			sql = "insert into emp_office_info(personal_id,dept_id,design_id,degree_id,salary,doj) values(?,?,?,?,?,?)";
			jdbcTemplate.update(sql,empOfficeInfo.getPersonalId(),empOfficeInfo.getDeptId(),empOfficeInfo.getDesignId(),empOfficeInfo.getDegreeId(),empOfficeInfo.getSalary(),empOfficeInfo.getDoj());
		}
		
	}

	@Override
	public Map<Integer, EmpOfficeInfo> getEmpOfficeInfoList() {
		// TODO Auto-generated method stub
		final Map<Integer,EmpOfficeInfo> mapRet= new LinkedHashMap<Integer,EmpOfficeInfo>();;
		jdbcTemplate.query("select office_id,personal_id,dept_id,design_id,degree_id,salary,doj from emp_office_info", new ResultSetExtractor<Map>(){
		    @Override
		    public Map<Integer, EmpOfficeInfo> extractData(ResultSet rs) throws SQLException,DataAccessException {
		      // mapRet= new LinkedHashMap<Integer,EmpOfficeInfo>();
		        while(rs.next()){
		        	EmpOfficeInfo empOfficeInfo = new EmpOfficeInfo();
		        	empOfficeInfo.setOfficeId(rs.getInt("office_id"));
		        	empOfficeInfo.setPersonalId(rs.getInt("personal_id"));
		        	empOfficeInfo.setDeptId(rs.getInt("dept_id"));
		        	empOfficeInfo.setDesignId(rs.getInt("design_id"));
		        	empOfficeInfo.setDegreeId(rs.getInt("degree_id"));
		        	empOfficeInfo.setSalary(rs.getDouble("salary"));
		        	empOfficeInfo.setDoj(rs.getString("doj"));
		        	
		            mapRet.put(empOfficeInfo.getPersonalId(),empOfficeInfo);
		        }
		        return mapRet;
		    }
		});
		
		return mapRet;
	}
	
	public EmpOfficeInfo get(int officeId) {
		String sql = "SELECT * FROM emp_office_info WHERE office_id=" + officeId;
		final EmpOfficeInfo empOfficeInfo = new EmpOfficeInfo();
		return jdbcTemplate.query(sql, new ResultSetExtractor<EmpOfficeInfo>() {

			@Override
			public EmpOfficeInfo extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					empOfficeInfo.setOfficeId(rs.getInt("office_id"));
		        	empOfficeInfo.setPersonalId(rs.getInt("personal_id"));
		        	empOfficeInfo.setDeptId(rs.getInt("dept_id"));
		        	empOfficeInfo.setDesignId(rs.getInt("design_id"));
		        	empOfficeInfo.setDegreeId(rs.getInt("degree_id"));
		        	empOfficeInfo.setSalary(rs.getDouble("salary"));
		        	empOfficeInfo.setDoj(rs.getString("doj"));
					//return empOfficeInfo;
				}
				
				return empOfficeInfo;
			}
			
		});
	}

	@Override
	public void delete(int officeId) {
		String sql="";
		if(officeId!=0)
		{
			sql="delete from emp_office_info where office_id=?";
			jdbcTemplate.update(sql,officeId);
		}
		
	}
	
	

}
