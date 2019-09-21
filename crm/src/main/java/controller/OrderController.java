package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Client;
import entity.Order;
import entity.User;
import service.OrderService;
import service.ClientService;
import service.UserService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Order")
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	ClientService clientService;
	@Autowired
	UserService userService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_order.id like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(orderService.selectCount(where));
		info.setList(orderService.getAll(where,lim));
		return info;
	}
	
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Order.status;
	}
	
	@RequestMapping("getCreateusers")
	public @ResponseBody List<User> getCreateusers() {
		return userService.getAll(null,null);
	}
	
	@RequestMapping("getClients")
	public @ResponseBody List<Client> getClients() {
		return clientService.getAll(null,null);
	}
	
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		orderService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Order u) {
		orderService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Order edit(int id) {
		return orderService.getById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Order u) {
		orderService.update(u);
		return "{\"status\":1}";
	}
}
