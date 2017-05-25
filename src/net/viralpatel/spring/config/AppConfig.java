package net.viralpatel.spring.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import net.viralpatel.spring.DAO.DepartmentDAO;
import net.viralpatel.spring.DAO.DepartmentDAOImpl;

import net.viralpatel.spring.DAO.DesignationDAO;
import net.viralpatel.spring.DAO.DesignationDAOImpl;

import net.viralpatel.spring.DAO.DegreeDAO;
import net.viralpatel.spring.DAO.DegreeDAOImpl;

import net.viralpatel.spring.DAO.GenderDAO;
import net.viralpatel.spring.DAO.GenderDAOImpl;

import net.viralpatel.spring.DAO.StateDAO;
import net.viralpatel.spring.DAO.StateDAOImpl;

import net.viralpatel.spring.DAO.EmpPersonalInfoDAO;
import net.viralpatel.spring.DAO.EmpPersonalInfoDAOImpl;

import net.viralpatel.spring.DAO.EmpOfficeInfoDAO;
import net.viralpatel.spring.DAO.EmpOfficeInfoDAOImpl;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.viralpatel.spring")
public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/employee_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		try {
			System.out.println("dataSource:"+dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean
	public DepartmentDAO getDepartmentDAO() {
		return new DepartmentDAOImpl(getDataSource());
	}
	
	@Bean
	public DesignationDAO getDesignationDAO() {
		return new DesignationDAOImpl(getDataSource());
	}
	
	@Bean
	public DegreeDAO getDegreeDAO() {
		return new DegreeDAOImpl(getDataSource());
	}
	
	@Bean
	public GenderDAO getGenderDAO() {
		return new GenderDAOImpl(getDataSource());
	}
	
	@Bean
	public StateDAO getStateDAO() {
		return new StateDAOImpl(getDataSource());
	}
	
	@Bean
	public EmpPersonalInfoDAO getEmpPersonalInfoDAO() {
		return new EmpPersonalInfoDAOImpl(getDataSource());
	}
	
	@Bean
	public EmpOfficeInfoDAO getEmpOfficeInfoDAO() {
		return new EmpOfficeInfoDAOImpl(getDataSource());
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}