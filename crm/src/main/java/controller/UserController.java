package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import entity.Workgroup;
import service.UserService;
import service.WorkgroupService;
import utils.ReturnInfo;

@Controller
@RequestMapping("User")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	WorkgroupService groupService;
	
	@RequestMapping("passedit")
	public @ResponseBody String passedit(HttpSession s,String newpass) {
		User u = (User) s.getAttribute("currentUser");
		userService.passedit(newpass,u.getId());
		return "{\"status\":1}";
	}
	
	@RequestMapping("login")
	public @ResponseBody String login(User u,HttpSession s) {
		try {
		SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getTel(), u.getPass()));
		}catch (Exception e) {
			return "false";
		}
		User currentUser = userService.selectByTel(u.getTel());
		s.setAttribute("currentUser", currentUser);
		System.out.println(s.getAttribute("currentUser"));
		return "true";
		
	}
	
	@RequestMapping("findName")
	@ResponseBody
	public String findName(HttpSession s) {
		User u = (User) s.getAttribute("currentUser");
		return u.getName();
	}
	
	
	@RequestMapping("outlogin")
	public String outlogin(HttpSession s) {
		SecurityUtils.getSubject().logout();
		return "redirect:../X-admin/login.html";
	}
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		System.out.println(123);
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_user.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(userService.selectCount(where));
		info.setList(userService.getAll(where,lim));
		return info;
	}
	
	
	@RequestMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return User.sexs;
	}
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return User.status;
	}
	@RequestMapping("getPowers")
	public @ResponseBody String[] getPowers() {
		return User.powers;
	}
	
	@RequestMapping("getGroups")
	public @ResponseBody List<Workgroup> getGroups() {
		return groupService.getAll(null,null);
	}

	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		userService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(User u) {
		userService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody User edit(int id) {
		return userService.selectById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(User u) {
		userService.update(u);
		return "{\"status\":1}";
	}
}
