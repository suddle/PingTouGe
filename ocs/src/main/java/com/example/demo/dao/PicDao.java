package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.domain.PicImg;
import com.example.demo.domain.User;

public class PicDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> getallpic(){
		List<String> allpics=new ArrayList<String>();
		RowMapper<PicImg> rowMapper=new BeanPropertyRowMapper<PicImg>(PicImg.class);
		List<PicImg> pics= jdbcTemplate.query("select *  from picimg", rowMapper);
		for (PicImg pic : pics) {
			System.out.print(pic.getPicimg());
			allpics.add(pic.getPicimg());
		}
		return allpics;
	}
}
