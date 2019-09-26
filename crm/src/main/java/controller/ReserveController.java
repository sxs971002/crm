package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Client;
import entity.Reserve;
import entity.User;
import service.ReserveService;
import service.ClientService;
import service.UserService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Reserve")
public class ReserveController {

	@Autowired
	ReserveService reserveService;
	@Autowired
	ClientService clientService;
	@Autowired
	UserService userService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_reserve.id like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(reserveService.selectCount(where));
		info.setList(reserveService.getAll(where,lim));
		return info;
	}
	
	@RequestMapping("getTypes")
	public @ResponseBody String[] getTypes() {
		return Reserve.types;
	}
	
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Reserve.status;
	}
	
	@RequestMapping("getExecstatus")
	public @ResponseBody String[] getExecstatus() {
		return Reserve.execstatus;
	}
	
	@RequestMapping("getUsers")
	public @ResponseBody List<User> getCreateusers() {
		return userService.getAll(null,null);
	}
	
	@RequestMapping("getClients")
	public @ResponseBody List<Client> getClients() {
		return clientService.getAll(null,null);
	}
	
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		reserveService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Reserve u) {
		reserveService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Reserve edit(int id) {
		return reserveService.getById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Reserve r) {
		reserveService.update(r);
		return "{\"status\":1}";
	}
	@RequestMapping("updatepool")
	public @ResponseBody String updatepool(Reserve r) {
		reserveService.updatepool(r);
		return "{\"status\":1}";
	}
}
