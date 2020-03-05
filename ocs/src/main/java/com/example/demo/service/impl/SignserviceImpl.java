package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SignDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.Sign;
import com.example.demo.domain.User;
import com.example.demo.service.SignServer;

@Service
public class SignserviceImpl  implements SignServer{
	@Autowired
	private SignDao dao;
	public List<Sign> getAll() {
		// TODO Auto-generated method stub
		 return dao.getAll();
	}
	public boolean receive(String username) {
		return dao.receive(username);
	}

}
