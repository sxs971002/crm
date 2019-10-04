package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import service.ClientService;
import service.Client_type_Service;
import service.ReserveService;
import service.RevisitService;
import service.SrcService;
import service.UserService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Client_Pool")
public class Client_Pool_Controller {

	@Autowired
	ClientService clientService;
	@Autowired
	Client_type_Service ctService;
	@Autowired
	SrcService srcService;
	@Autowired
	UserService userService;
	@Autowired
	ReserveService reserveService;
	@Autowired
	RevisitService revisitService;

	// 查看未分配客户
	@RequestMapping("noappoint")
	public @ResponseBody ReturnInfo index1(String txt, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "where c_client.count=0 and (c_client.userids = '' or c_client.userids is null) ";
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		String lim = info.getLimit(page, limit);
		info.setCount(clientService.selectCount(where));
		info.setList(clientService.getNoappoint(where, lim));
		return info;
	}

	//查看我的全部客户
	@RequestMapping("My_allclients")
	public @ResponseBody ReturnInfo index4(HttpSession s,String txt, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		User u = (User) s.getAttribute("currentUser");
		where = "where c_client.usernames = ''";
		if (u != null)
			where = "where c_client.usernames like '%" + u.getName() + "%' ";
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		System.out.println(where);
		String lim = info.getLimit(page, limit);
		info.setCount(clientService.selectCount(where));
		info.setList(clientService.getAll(where, lim));
		return info;
	}
	
	// 查看我的未处理客户
	@RequestMapping("Myunexecuted")
	public @ResponseBody ReturnInfo index2(String tel, String txt, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		User u = userService.selectByTel(tel);
		where = "where c_client.usernames = ''";
		if (u != null)
			where = "where c_client.usernames like '%" + u.getName() + "%' and c_client.count = 0";
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		System.out.println(where);
		String lim = info.getLimit(page, limit);
		info.setCount(clientService.selectCount(where));
		info.setList(clientService.getMyunexecuted(where, lim));
		return info;
	}

	// 查看我的预约客户
	@RequestMapping("Myreserved")
	public @ResponseBody ReturnInfo index3(int execuserid,String txt,String startdate,String enddate, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		System.out.println(startdate);
		System.out.println(enddate);
		String where = "where c_reserve.execuserid =" + execuserid;
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		if((startdate!=null && enddate!=null)&&(startdate.length()>0 && enddate.length()>0))
			where = where + "and c_reserve.date >= '"+startdate+"' and c_reserve.date <= '"+enddate+"'";
		System.out.println(where);
		String lim = info.getLimit(page, limit);
		info.setCount(reserveService.selectCount(where));
		info.setList(reserveService.getMyreserved(where, lim));
		return info;
	}

	//查看顾客的所有历史回访记录
	@RequestMapping("Client_Histories")
	public @ResponseBody ReturnInfo index5(int clientid, String txt, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		where = "where c_revisit.clientid = " + clientid;
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		String lim = info.getLimit(page, limit);
		info.setCount(revisitService.selectCount(where));
		info.setList(revisitService.getAll(where, lim));
		return info;
	}

	
	// 查看我的回访记录
	@RequestMapping("Myrevisit")
	public @ResponseBody ReturnInfo index6(int clientid, int execuserid, String txt, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "where c_revisit.execuserid =" + execuserid + " and c_client.id="+clientid;
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		String lim = info.getLimit(page, limit);
		info.setCount(revisitService.selectCount(where));
		info.setList(revisitService.getMyrevisit(where, lim));
		return info;
	}

	// 查看我的已处理客户
	@RequestMapping("Myexecuted")
	public @ResponseBody ReturnInfo index7(String tel, String txt, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		User u = userService.selectByTel(tel);
		where = "where c_client.usernames = ''";
		if (u != null)
			where = "where c_client.usernames like '%" + u.getName() + "%' and c_client.count > 0 and c_client.execstatu = 2";
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		String lim = info.getLimit(page, limit);
		info.setCount(clientService.selectCount(where));
		info.setList(clientService.getMyexecuted(where, lim));
		return info;
	}
	
	//批量分配
	@RequestMapping("updates")
	public @ResponseBody String updates(String clientids,String userids,String usernames) {
		System.out.println(userids);
		String clientid[] = clientids.split(",");
		for(int i = 0;i<clientid.length;i++) {
			clientService.updates(clientid[i],userids,usernames);
		}
		return "{\"status\":1}";
	}
	
	//
	@RequestMapping("updateCount")
	public @ResponseBody String updateCount(String clientids,String userids,String usernames) {
		System.out.println(userids);
		String clientid[] = clientids.split(",");
		for(int i = 0;i<clientid.length;i++) {
			clientService.updates(clientid[i],userids,usernames);
		}
		return "{\"status\":1}";
	}
	
}
