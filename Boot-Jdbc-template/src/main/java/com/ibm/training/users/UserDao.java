package com.ibm.training.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Course> getCourses() 
	{
		String sql = "select * from traincourseinfo";
		return jdbcTemplate.query(sql, new GetCourses());
	}
	
	class GetCourses implements RowMapper<Course> 
	{
		
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException 
		{	
			Course c = new Course();
			c.setCourseId(rs.getInt(1));
			c.setCourseName(rs.getString(2));
			c.setCourseSeats(rs.getInt(3));
			return c;
		}
	}

	public List<Course> getCourseById(Integer id) 
	{
		String sql = "select * from traincourseinfo where trainingid = ?";
		return jdbcTemplate.query(sql,new Object[] {id}, new GetCourses());
	}

	public void addCourse(Course c) {
		String sql = "insert into traincourseinfo values(?,?,?)";
		jdbcTemplate.update(sql, new Object[] { c.getCourseId(), c.getCourseName(), c.getCourseSeats() });

	}

	public void updateCourse(Course c, Integer id) {
		String sql = "update traincourseinfo set trainingid = ?, trainingname= ?, availableseats=? where trainingid = ?";
		jdbcTemplate.update(sql, new Object[] {c.getCourseId(), c.getCourseName(), c.getCourseSeats(), id });
	}

	public void deleteCourse(Integer id) {
		String sql = "delete from traincourseinfo where trainingid = ?";
		jdbcTemplate.update(sql,new Object[] {id});
	}
}
