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

import net.viralpatel.spring.DAO.DesignationDAO;

import net.viralpatel.spring.model.DesignationMaster;




public class DesignationDAOImpl implements DesignationDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public DesignationDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@SuppressWarnings("null")
	public List<DesignationMaster> getDesignationList()
	{
		String sql = "select * from designation_master";
		
		System.out.println("jdbcTemplate:"+jdbcTemplate.getDataSource());
		
		List<DesignationMaster> desingationList = jdbcTemplate.query(sql, new RowMapper<DesignationMaster>() {

			@Override
			public DesignationMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				DesignationMaster designationMaster = new DesignationMaster();
	
				designationMaster.setDesignationMasterId(rs.getInt(1));
				designationMaster.setDesignationMasterDesc(rs.getString(2));
			
				
				return designationMaster;
			}
			
		});
		
		return desingationList;
		
	}
	
	@Override
	public DesignationMaster get(int designationId) {
		
		String sql = "SELECT * FROM designation_master WHERE designation_master_id=" + designationId;
		final DesignationMaster designationMaster = new DesignationMaster();
		return jdbcTemplate.query(sql, new ResultSetExtractor<DesignationMaster>() {

			@Override
			public DesignationMaster extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
				
					designationMaster.setDesignationMasterId(rs.getInt("designation_master_id"));
					designationMaster.setDesignationMasterDesc(rs.getString("designation_master_desc"));
					//return empOfficeInfo;
				}
				
				return designationMaster;
			}
			
		});
		
	}
	
	
}
