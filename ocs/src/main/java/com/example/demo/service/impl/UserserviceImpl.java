package com.example.demo.service.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;

 
@Service
public class UserserviceImpl implements UserService{
 
	@Autowired
	private UserDao dao;
	
	

	@Override
	public void save(User use) {
		// TODO Auto-generated method stub
		dao.save(use);
		
	}


	public List<Map<String, Object>> get(User use) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> uses =dao.get(use);
		return uses;
	}
	
	


	public List<String> getall() {
		// TODO Auto-generated method stub
		List<String> alluser=dao.getall();
		return alluser;

	}


	public int getusercount(User use) {
		// TODO Auto-generated method stub
		int count=dao.getusercount(use);
		return count;
	}


	


	

}

