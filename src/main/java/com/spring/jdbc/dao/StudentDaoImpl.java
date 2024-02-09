package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	


	public int insert(Student student) {
		//insert
        String queryString="insert into student(id,name,city) values(?,?,?)";
        int result = this.jdbcTemplate.update(queryString,student.getId(),student.getName(),student.getCity());
		
		return result;
		
	}



	@Override
	public int change(Student student) {
		// update
		String queryString="update student set name=? , city=? where id=?";
		int result = this.jdbcTemplate.update(queryString,student.getName(),student.getCity(),student.getId());
		return 0;
	}



	@Override
	public int delete(int studentId) {
		// Delete
		String queryString="delete from student where id=?";
		int result = this.jdbcTemplate.update(queryString, studentId);
		return 0;
	}



	@Override
	public Student getStudent(int studentId) {
		//get student from db
		
		String queryString="select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(queryString, rowMapper, studentId);
		return student;
	}



	@Override
	public List<Student> getAllStudent() {
		String queryString = "select * from student";
		List<Student> student = this.jdbcTemplate.query(queryString, new RowMapperImpl());
		return student;
	}
	
	
	

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	

}
