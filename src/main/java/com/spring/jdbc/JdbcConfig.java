package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {

	@Bean("ds")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dSource = new DriverManagerDataSource();
		dSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dSource.setUsername("root");
		dSource.setPassword("username1@");
		
		return dSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean("studentDao")
	public StudentDao getStudentDao() {
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.setJdbcTemplate(jdbcTemplate());
		return studentDao;
	}
}
