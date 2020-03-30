package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> findAll() {
		String query = "select * from student";
		return jdbcTemplate.query(query, (rs, rowNum) -> new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));		
	}

	@Override
	public List<Student> findByName(String name) {
		String query = "select * from student where name = ?";
		return jdbcTemplate.query(query, (rs, rowNum) -> new Student(rs.getInt(1), rs.getString(2), rs.getString(3)),name);
				
	}

	@Override
	public int create(Student student) {
		
		String query="Insert into Student values(?,?,?)";
		int update = jdbcTemplate.update(query, student.getId(),student.getName(),student.getCourse());
				
		return update;
	}

	@Override
	public int update(Student student) {
		String query ="Update Student set name=?, course=? where id=?";
		int update = jdbcTemplate.update(query, student.getName(),student.getCourse(),student.getId());
		return update;
	}

	@Override
	public int delete(int id) {
		String query="Delete from Student where id=?";
		int update = jdbcTemplate.update(query, id);
		return update;
	}

	@Override
	public int countStudent() {
		String query="Select count(*) from Student";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}

}
