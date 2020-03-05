package com.example.demo.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.example.demo.domain.User;

import javax.print.attribute.standard.PrinterInfo;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;
import com.example.demo.service.impl.PicServerImpl;
import com.example.demo.service.impl.UserserviceImpl;
import com.mysql.cj.xdevapi.Result;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class PicController {
	@Autowired
	private PicServerImpl picserver;
	
	@RequestMapping(value = "/getpic", method = RequestMethod.GET) // 获取全部用户名
	@ResponseBody
	public List<String> getall() {

		Map<String, String> map = new HashMap<String, String>();
		System.out.print("shoudao");
		List<String> ends = picserver.getallpic();
		map.put("success", "success");
		map.put("data", ends.toString());
		return ends;

	}
}
