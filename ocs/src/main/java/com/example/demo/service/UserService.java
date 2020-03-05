//package com.example.demo.service;
//
//public class UserService {
//
//}

package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;

import java.util.List;
import java.util.Map;



public interface UserService {

	void save(User use);
	List<Map<String, Object>> get(User use);
	List<String> getall();
	int getusercount(User use);
}


