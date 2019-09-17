package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Client_type;
import service.Client_type_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Client_type")
public class Client_type_Controller {

	@Autowired
	Client_type_Service ctService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_client_type.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(ctService.selectCount(where));
		info.setList(ctService.getAll(where,lim));
		return info;
	}
	
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		ctService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Client_type u) {
		ctService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Client_type edit(int id) {
		return ctService.selectById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Client_type u) {
		ctService.update(u);
		return "{\"status\":1}";
	}
}
