package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Client;
import entity.Client_type;
import entity.Src;
import service.ClientService;
import service.Client_type_Service;
import service.SrcService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Client")
public class ClientController {

	@Autowired
	ClientService clientService;
	@Autowired
	Client_type_Service ctService;
	@Autowired
	SrcService srcService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_client.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(clientService.selectCount(where));
		info.setList(clientService.getAll(where,lim));
		return info;
	}
	
	
	@RequestMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return Client.sexs;
	}
	@RequestMapping("getLinkstatus")
	public @ResponseBody String[] getLinkstatus() {
		return Client.linkstatus;
	}
	@RequestMapping("getClientstatus")
	public @ResponseBody String[] getClientstatus() {
		return Client.clientstatus;
	}
	@RequestMapping("getPurposestatus")
	public @ResponseBody String[] getPurposestatus() {
		return Client.purposestatus;
	}
	@RequestMapping("getAssessstatus")
	public @ResponseBody String[] getAssessstatus() {
		return Client.assessstatus;
	}
	@RequestMapping("getExecstatus")
	public @ResponseBody String[] getExecstatus() {
		return Client.execstatus;
	}
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Client.status;
	}
	
	@RequestMapping("getSrcs")
	public @ResponseBody List<Src> getSrcs() {
		return srcService.getAll(null,null);
	}
	
	@RequestMapping("getClienttypes")
	public @ResponseBody List<Client_type> getClienttypes() {
		return ctService.getAll(null,null);
	}
	
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		clientService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Client u) {
		clientService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Client edit(int id) {
		return clientService.getById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Client u) {
		clientService.update(u);
		return "{\"status\":1}";
	}
	@RequestMapping("remove")
	public @ResponseBody String remove(Client u) {
		clientService.remove(u);
		return "{\"status\":1}";
	}
}
