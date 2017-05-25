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

import net.viralpatel.spring.DAO.DegreeDAO;
import net.viralpatel.spring.model.DegreeMaster;


public class DegreeDAOImpl implements DegreeDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public DegreeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@SuppressWarnings("null")
	public List<DegreeMaster> getDegreeList()
	{
		String sql = "select * from degree_master";
		
		System.out.println("jdbcTemplate:"+jdbcTemplate.getDataSource());
		
		List<DegreeMaster> degreeList = jdbcTemplate.query(sql, new RowMapper<DegreeMaster>() {

			@Override
			public DegreeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				DegreeMaster degreeMaster = new DegreeMaster();
	
				degreeMaster.setDegreeMasterId(rs.getInt(1));
				degreeMaster.setDegreeMasterDesc(rs.getString(2));
				return degreeMaster;
			}
			
		});
		
		return degreeList;
		
	}


		
		public DegreeMaster get(int degreeId) {
			String sql = "SELECT * FROM degree_master WHERE degree_master_id=" + degreeId;
			final DegreeMaster degreeMaster = new DegreeMaster();
			return jdbcTemplate.query(sql, new ResultSetExtractor<DegreeMaster>() {

				@Override
				public DegreeMaster extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					if (rs.next()) {
					
						degreeMaster.setDegreeMasterId(rs.getInt("degree_master_id"));
						degreeMaster.setDegreeMasterDesc(rs.getString("degree_master_desc"));
						//return empOfficeInfo;
					}
					
					return degreeMaster;
				}
				
			});
		}
		
	
	
	
}
