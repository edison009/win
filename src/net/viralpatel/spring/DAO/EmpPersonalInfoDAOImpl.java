package net.viralpatel.spring.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;









import net.viralpatel.spring.model.EmpPersonalInfo;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class EmpPersonalInfoDAOImpl implements  EmpPersonalInfoDAO{
private JdbcTemplate jdbcTemplate;
	
	public EmpPersonalInfoDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int saveOrUpdate(final EmpPersonalInfo empPersonalInfo) {
		// TODO Auto-generated method stub
		
		String sql="";
		int personalId = 0;
		if(empPersonalInfo.getPersonalId()!=0)
		{
			sql="update emp_personal_info set person_name=?,age=?,gender_id=?,address=?,state_id=? where personal_id=?";
			jdbcTemplate.update(sql,empPersonalInfo.getPersonName(),empPersonalInfo.getAge(),empPersonalInfo.getGenderId(),empPersonalInfo.getAddress(),empPersonalInfo.getStateId(),empPersonalInfo.getPersonalId());
			personalId = empPersonalInfo.getPersonalId();
		}
		else
		{
			/*sql = "insert into emp_personal_info(person_name,age,gender_id,address,state_id) values(?,?,?,?,?)";
			//jdbcTemplate.update(sql,empPersonalInfo.getPersonName(),empPersonalInfo.getAge(),empPersonalInfo.getGenderId(),empPersonalInfo.getAddress(),empPersonalInfo.getStateId());
			//GeneratedKeyHolder holder = new GeneratedKeyHolder();
		*/	final PreparedStatementCreator psc = new PreparedStatementCreator() {
			   @Override
				public java.sql.PreparedStatement createPreparedStatement(
						java.sql.Connection arg0) throws SQLException {
					final java.sql.PreparedStatement ps = arg0.prepareStatement("insert into emp_personal_info(person_name,age,gender_id,address,state_id) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			        ps.setString(1, empPersonalInfo.getPersonName());
			        ps.setInt(2, empPersonalInfo.getAge());
			        ps.setInt(3, empPersonalInfo.getGenderId());
			        ps.setString(4, empPersonalInfo.getAddress());
			        ps.setInt(5, empPersonalInfo.getStateId());
			        return (PreparedStatement) ps;
				}
			    };

			    // The newly generated key will be saved in this object
			    final KeyHolder holder = new GeneratedKeyHolder();
			    jdbcTemplate.update(psc, holder);
			    final int personaIdtmp = holder.getKey().intValue();
			    personalId = personaIdtmp;
			    System.out.println("personaIdtmp:"+personaIdtmp);
			   // return personaId;
			

		}
		return personalId;
		
		
	}

	@Override
	public Map<Integer, EmpPersonalInfo> getEmpPersonalInfoList() {
		
		// TODO Auto-generated method stub
		final Map<Integer,EmpPersonalInfo> mapRet= new LinkedHashMap<Integer,EmpPersonalInfo>();;
		jdbcTemplate.query("select personal_id,person_name,age,gender_id,address,state_id from emp_personal_info", new ResultSetExtractor<Map>(){
		    @Override
		    public Map<Integer, EmpPersonalInfo> extractData(ResultSet rs) throws SQLException,DataAccessException {
		    
		        while(rs.next()){
		        	EmpPersonalInfo empPersonalInfo = new EmpPersonalInfo();
		        	empPersonalInfo.setPersonalId(rs.getInt("personal_id"));
		        	empPersonalInfo.setPersonName(rs.getString("person_name"));
		        	empPersonalInfo.setAge(rs.getInt("age"));
		        	empPersonalInfo.setGenderId(rs.getInt("gender_id"));
		        	empPersonalInfo.setAddress(rs.getString("address"));
		        	empPersonalInfo.setStateId(rs.getInt("state_id"));
		        	
		        	
		            mapRet.put(empPersonalInfo.getPersonalId(),empPersonalInfo);
		        }
		        return mapRet;
		    }
		});
		
		return mapRet;
		
		
	}

	@Override
	public EmpPersonalInfo get(int personalId) {
		String sql = "SELECT * FROM emp_personal_info WHERE personal_id=" + personalId;
		final EmpPersonalInfo empPersonalInfo = new EmpPersonalInfo();
		return jdbcTemplate.query(sql, new ResultSetExtractor<EmpPersonalInfo>() {

			@Override
			public EmpPersonalInfo extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					empPersonalInfo.setPersonalId(rs.getInt("personal_id"));
		        	empPersonalInfo.setPersonName(rs.getString("person_name"));
		        	empPersonalInfo.setAge(rs.getInt("age"));
		        	empPersonalInfo.setGenderId(rs.getInt("gender_id"));
		        	empPersonalInfo.setAddress(rs.getString("address"));
		        	empPersonalInfo.setStateId(rs.getInt("state_id"));
					
				}
				
				return empPersonalInfo;
			}
			
		});
	}

	@Override
	public void delete(int personalId) {
		if(personalId!=0)
		{
		String	sql="delete from emp_personal_info where personal_id=?";
			jdbcTemplate.update(sql,personalId);
		}
		
	}
	
	
}
