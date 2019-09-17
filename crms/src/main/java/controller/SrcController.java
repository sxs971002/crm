package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Src;
import service.SrcService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Src")
public class SrcController {

	@Autowired
	SrcService srcService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_worksrc.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(srcService.selectCount(where));
		info.setList(srcService.getAll(where,lim));
		return info;
	}
	
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		srcService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Src u) {
		srcService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Src edit(int id) {
		return srcService.selectById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Src u) {
		srcService.update(u);
		return "{\"status\":1}";
	}
}
