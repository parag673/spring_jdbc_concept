package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	
	
	public int insert(Student student) {
		  String query="insert into student values(?,?,?)";
		  int result=  this.jdbctemplate.update(query,student.getId(),student.getName(),student.getCity());
		return 1;
	}



	public int update(Student student) {
		String query="update student set  name=?,city=? where id=?";
		int result=this.jdbctemplate.update(query,student.getName(),student.getCity(),student.getId());
		return 1;
	}

	public int delete(int id) {
	String query="delete from student where id=?";
	int result=this.jdbctemplate.update(query,id);
		return 1;
	}

	public Student getStudent(int id) {
		String query="select * from student where id=?";
		RowMapper<Student> s1=new RowMapperImpl();
		Student s2=this.jdbctemplate.queryForObject(query, s1,id);
		return s2;
	}

	public List<Student> getAllstudent() {
		
		String query="select * from student";
		List<Student> s1=this.jdbctemplate.query(query, new RowMapperImpl());
		return s1;
		
	}

	
	
}
