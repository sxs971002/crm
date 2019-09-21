package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Workgroup;
import service.WorkgroupService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Workgroup")
public class WorkgroupController {

	@Autowired
	WorkgroupService groupService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_workgroup.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(groupService.selectCount(where));
		info.setList(groupService.getAll(where,lim));
		return info;
	}
	
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		groupService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Workgroup u) {
		groupService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Workgroup edit(int id) {
		return groupService.selectById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Workgroup u) {
		groupService.update(u);
		return "{\"status\":1}";
	}
}
