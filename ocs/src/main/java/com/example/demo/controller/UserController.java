package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.example.demo.domain.User;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserserviceImpl;
import com.mysql.cj.xdevapi.Result;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class UserController {
	@Autowired
	private UserserviceImpl userservice;

//	@RequestMapping(value = "/save", method = RequestMethod.POST) //测试 添加人员
//	public Map<String,String> save(String name) {
//		Map<String,String> map=new HashMap<String,String>();
//		User use = new User(name,"123456","1");
//		userservice.save(use);
//		map.put("msg", "success");
//		return map;
//	}

	@RequestMapping(value="/savemsg",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String>  SavedRequest(@RequestParam String username,@RequestParam String password,HttpServletRequest request) {
		Map<String,String> map=new HashMap<String,String>();
		User user=new User(username, password,"");
		if(username.length()>1 && password.length()>1) {
			userservice.save(user);
			map.put("success", "保存成功");
		}else {
			map.put("success", "保存失败");
		}
		return map;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST) // 获取某个用户的名字
	@ResponseBody
	public List<Map<String, Object>> get(String username, String password) {
		User use = new User(username, password, "");
		return userservice.get(use);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET) // 获取全部用户名
	@ResponseBody
	public List<String> getall() {
		Map<String, String> map = new HashMap<String, String>();
		System.out.print("shoudao");
		List<String> ends = userservice.getall();
		map.put("success", "success");
		map.put("data", ends.toString());
		return ends;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST) // 注册
	@ResponseBody
	public Map<String, String> register(@RequestParam String username, @RequestParam String password,
			@RequestParam String role, @RequestParam String quirepsd) {
		Map<String, String> map = new HashMap<String, String>();
		User use = new User(username, password, role);
		if (username.length() < 1) {
			map.put("fail", "用户名不能为空");
			return map;
		}
		if (password.length() < 1) {
			map.put("fail", "密码不能为空");
			return map;
		}
		if (!password.equals(quirepsd)) {
			map.put("fail", "密码和确认密码不一致");
			return map;
		}
		userservice.save(use);
		map.put("success", "success");
		return map;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST) // 登陆
	@ResponseBody
	public Map<String, String> login(@RequestParam String username, @RequestParam String password,
			HttpServletRequest request) {
		System.out.print("进来登录页面");
		Map<String, String> map = new HashMap<String, String>();
		User use = new User(username, password, "");
		if (username.length() < 1) {
			map.put("fail", "用户名不能为空");
			return map;
		}
		if (password.length() < 1) {
			map.put("fail", "密码不能为空");
			return map;
		}
		int count = userservice.getusercount(use);
		if (count > 0) {
			map.put("success", "success");
			map.put("msg", use.toString());
			request.getSession().setAttribute("user", use);
			// request.getSession().getAttribute("user");
		}
		return map;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> logout(@RequestParam String username, @RequestParam String password,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		User user = new User(username, password, "");
		if (username.length() > 1 && password.length() > 1) {
			request.getSession().removeAttribute("user");
			map.put("success", "注销成功");
		}
		return map;
	}

}
