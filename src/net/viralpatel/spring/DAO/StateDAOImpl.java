package net.viralpatel.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;




import net.viralpatel.spring.model.StateMaster;
import net.viralpatel.spring.DAO.StateDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class StateDAOImpl implements StateDAO{
	
private JdbcTemplate jdbcTemplate;
	
	public StateDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@SuppressWarnings("null")
	public List<StateMaster> getStateList()
	{
		String sql = "select * from state_master";
		
		System.out.println("jdbcTemplate:"+jdbcTemplate.getDataSource());
		
		List<StateMaster> stateList = jdbcTemplate.query(sql, new RowMapper<StateMaster>() {

			@Override
			public StateMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				StateMaster stateMaster = new StateMaster();
	
				stateMaster.setStateMasterId(rs.getInt(1));
				stateMaster.setStateMasterName(rs.getString(2));
				return stateMaster;
			}
			
		});
		
		return stateList;
		
	}
	@Override
	public StateMaster get(int stateId) {
		
		String sql = "SELECT * FROM state_master WHERE state_master_id=" + stateId;
		final StateMaster stateMaster = new StateMaster();
		return jdbcTemplate.query(sql, new ResultSetExtractor<StateMaster>() {

			@Override
			public StateMaster extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
				
					stateMaster.setStateMasterId(rs.getInt("state_master_id"));
					stateMaster.setStateMasterName(rs.getString("state_master_name"));
					
				}
				
				return stateMaster;
			}
			
		});
	}
	
	
	

}
