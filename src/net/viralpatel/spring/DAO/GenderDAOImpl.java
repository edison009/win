package net.viralpatel.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import net.viralpatel.spring.model.GenderMaster;
import net.viralpatel.spring.DAO.GenderDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class GenderDAOImpl implements GenderDAO {
	
	
private JdbcTemplate jdbcTemplate;
	
	public GenderDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@SuppressWarnings("null")
	public List<GenderMaster> getGenderList()
	{
		String sql = "select * from gender_master";
		
		System.out.println("jdbcTemplate:"+jdbcTemplate.getDataSource());
		
		List<GenderMaster> genderList = jdbcTemplate.query(sql, new RowMapper<GenderMaster>() {

			@Override
			public GenderMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				GenderMaster genderMaster = new GenderMaster();
				
				genderMaster.setGenderId(rs.getInt(1));
				genderMaster.setGenderDesc(rs.getString(2));
				return genderMaster;
			}
			
		});
		
		return genderList;
		
	}
	@Override
	public GenderMaster get(int genderId) {
		
		String sql = "SELECT * FROM gender_master WHERE gender_id=" + genderId;
		final GenderMaster genderMaster = new GenderMaster();
		return jdbcTemplate.query(sql, new ResultSetExtractor<GenderMaster>() {

			@Override
			public GenderMaster extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
				
					genderMaster.setGenderId(rs.getInt("gender_id"));
					genderMaster.setGenderDesc(rs.getString("gender_desc"));
					//return empOfficeInfo;
				}
				
				return genderMaster;
			}
			
		});
		
	}

}
