package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Sign;
import com.example.demo.service.impl.SignserviceImpl;


@RestController
public class SignController {
	@Autowired
	private SignserviceImpl signservice;
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Map<String,String> searchsign() {
		Map<String,String> map = new HashMap<String, String>();
		List<Sign> endsign=signservice.getAll();
		map.put("结果",endsign.toString());
		return map;
	}
	
	@RequestMapping(value="/arrave",method=RequestMethod.POST)
	public Map<String, String> arrave(@RequestParam String username,HttpServletRequest request){
		Map<String,String> map=new HashMap<String,String>();
		if(username.length()<1) {
			map.put("msg", "请选择人");
			map.put("code", "300");
		}else {
			if (signservice.receive(username)) {
				map.put("msg", "success");
				map.put("code", "200");
			}else {
				map.put("msg", "fail");
				map.put("code", "300");
			};
		}
		return map;
	}
}
