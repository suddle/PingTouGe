package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.PicDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.PicServer;
import com.example.demo.service.UserService;



public class PicServerImpl implements PicServer{
	@Autowired
	private PicDao dao;

	public List<String> getallpic() {
		// TODO Auto-generated method stub
		List<String> allpic=dao.getallpic();
		return allpic;

	}

}
