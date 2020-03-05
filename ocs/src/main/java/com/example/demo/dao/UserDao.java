package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.User;


import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//@Mapper
//public interface UserDao {
// 
//	@Select("select * from user where id=#{id}")
//	public User findUserById(@Param("id") int id);
//}

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
 
	public void save(User use) {
		// TODO Auto-generated method stub
		
		Object[] args = { use.getName().toString(), use.getPassword().toString() };
		String sql="insert into user (name,password) values(?,?)";
		//jdbcTemplate.update(sql,new Object[]{use.getName(),use.getPassword()});
		int count= jdbcTemplate.update(sql,args);
	}
	public int getusercount(User use) {
		Object[] args = { use.getName().toString(), use.getPassword().toString() };
		String sql="select count(*) from user where name=? and password=?";
		int count=jdbcTemplate.queryForObject(sql,Integer.class,args);;
		return count;
	}
	public List<Map<String, Object>> get(User use) {
//		jdbcTemplate.queryForList("select name from user where name(?)", use.getName());
		List<Map<String, Object>> user= jdbcTemplate.queryForList("select name from user where name=?",  use.getName());
		return user;
	}
	
	public List<String> getall(){
		List<String> allusers=new ArrayList<String>();
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		List<User> users= jdbcTemplate.query("select *  from user", rowMapper);
		for (User user : users) {
			System.out.print(user.getName());
			allusers.add(user.getName());
		}
		return allusers;
	}
	
}

