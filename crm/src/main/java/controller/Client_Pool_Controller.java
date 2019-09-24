package controller;

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
		String where = "where c_client.userids = '' or c_client.userids is null ";
		if (txt != null)
			where = "where (c_client.userids = '' or c_client.userids is null) and c_client.name like '%" + txt + "%'";
		String lim = info.getLimit(page, limit);
		info.setCount(clientService.selectCount(where));
		info.setList(clientService.getNoappoint(where, lim));
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
	public @ResponseBody ReturnInfo index3(String tel, String txt, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		User u = userService.selectByTel(tel);
		where = "where c_reserve.execuserid = ''";
		if (u != null)
			where = "where c_reserve.execuserid =" + u.getId();
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		System.out.println(where);
		String lim = info.getLimit(page, limit);
		info.setCount(reserveService.selectCount(where));
		info.setList(reserveService.getMyreserved(where, lim));
		return info;
	}

	// 查看我的回访记录
	@RequestMapping("Myrevisit")
	public @ResponseBody ReturnInfo index4(int execuserid, String txt, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		User u = userService.selectById(execuserid);
		where = "where c_revisit.execuserid = ''";
		if (u != null)
			where = "where c_revisit.execuserid =" + u.getId();
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		String lim = info.getLimit(page, limit);
		info.setCount(revisitService.selectCount(where));
		info.setList(revisitService.getMyrevisit(where, lim));
		return info;
	}

	// 查看我的已处理客户
	@RequestMapping("Myexecuted")
	public @ResponseBody ReturnInfo index5(String tel, String txt, Integer page, Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where = "";
		User u = userService.selectByTel(tel);
		where = "where c_client.usernames = ''";
		if (u != null)
			where = "where c_client.usernames like '%" + u.getName() + "%' and c_client.count != 0";
		if (txt != null)
			where = where + " and c_client.name like '%" + txt + "%'";
		String lim = info.getLimit(page, limit);
		info.setCount(clientService.selectCount(where));
		info.setList(clientService.getMyexecuted(where, lim));
		return info;
	}
}
