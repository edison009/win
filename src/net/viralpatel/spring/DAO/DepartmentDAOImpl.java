package net.viralpatel.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.viralpatel.spring.DAO.DepartmentDAO;
import net.viralpatel.spring.model.DepartmentMaster;

public class DepartmentDAOImpl implements DepartmentDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public DepartmentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@SuppressWarnings("null")
	public List<DepartmentMaster> getDeptartmentList()
	{
		String sql = "select * from department_master";
		
		System.out.println("jdbcTemplate:"+jdbcTemplate.getDataSource());
		
		List<DepartmentMaster> deptList = jdbcTemplate.query(sql, new RowMapper<DepartmentMaster>() {

			@Override
			public DepartmentMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				DepartmentMaster departmentMaster = new DepartmentMaster();
	
				departmentMaster.setDepartmentMasterId(rs.getInt(1));
				departmentMaster.setDepartmentDesc(rs.getString(2));
				
				
				return departmentMaster;
			}
			
		});
		
		return deptList;
		
	}

	public DepartmentMaster get(int departmentId){
		String sql = "SELECT * FROM department_master WHERE department_master_id=" + departmentId;
		final DepartmentMaster departmentMaster = new DepartmentMaster();
		return jdbcTemplate.query(sql, new ResultSetExtractor<DepartmentMaster>() {

			@Override
			public DepartmentMaster extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
				
					departmentMaster.setDepartmentMasterId(rs.getInt("department_master_id"));
					departmentMaster.setDepartmentDesc(rs.getString("department_desc"));
					//return empOfficeInfo;
				}
				
				return departmentMaster;
			}
			
		});
	}
	
	
}
