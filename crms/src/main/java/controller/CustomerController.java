package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Customer;
import entity.Customer_level;
import service.CustomerService;
import service.Customer_level_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	Customer_level_Service clService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		System.out.println(123);
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where crm_customer.cusname like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(customerService.selectCount(where));
		info.setList(customerService.getAll(where,lim));
		return info;
	}
	
	@RequestMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return Customer.sexs;
	}
	
	@RequestMapping("getStatus")
	public @ResponseBody List<Customer_level> getDeps() {
		return clService.selectAll();
	}
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		customerService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Customer u) {
		customerService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Customer edit(int id) {
		return customerService.getById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Customer u) {
		customerService.update(u);
		return "{\"status\":1}";
	}
}
