package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class RowMapperImpl implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s1=new Student();
		s1.setId(rs.getInt(1));
		s1.setName(rs.getString(2));
		s1.setCity(rs.getString(3));
		return s1;
	}

	
}
