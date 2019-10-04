package controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("shiro")
public class Shiro_controller {

	@RequestMapping("viewRole")
	@ResponseBody
	public String viewRole() {
		Subject subject  = SecurityUtils.getSubject();
		if(subject.hasRole("admin")) return "admin";
		else if(subject.hasRole("groupleader")) return "groupleader";
		return "user";
	}
}
