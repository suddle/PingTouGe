package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Sign;
import com.example.demo.service.SignServer;


//@Mapper
//public interface UserDao {
//
//	@Select("select * from user where id=#{id}")
//	public User findUserById(@Param("id") int id);
//}

@Repository
public class SignDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
    public List<Sign> getAll(){

		String sql ="select *  from sign";
		List<Sign> singList=jdbcTemplate.query(sql, new RowMapper<Sign>() {
			Sign sign=null;
			@Override
			public Sign mapRow(ResultSet rs, int rowNum) throws SQLException {
	
				sign=new Sign();
				sign.setId(rs.getInt("id"));
				sign.setSign(rs.getString("sign"));
				sign.setUsername(rs.getString("username"));
				return sign;
			}
		});
		return singList;
	}
    
	public boolean receive(String username) {
		String sql = "INSERT INTO `sign` (`username`, `sign`) VALUES (?, ?);";
	    return jdbcTemplate.update(sql, username, "已到达")>0;
	};
}
