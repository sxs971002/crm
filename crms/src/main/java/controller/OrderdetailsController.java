package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Orderdetails;
import entity.Product;
import service.OrderdetailsService;
import service.ProductService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Orderdetails")
public class OrderdetailsController {

	@Autowired
	OrderdetailsService orderdetailsService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_orderdetails.id like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(orderdetailsService.selectCount(where));
		info.setList(orderdetailsService.getAll(where,lim));
		return info;
	}
	
	@RequestMapping("getProducts")
	public @ResponseBody List<Product> getProducts() {
		return productService.getAll(null, null);
	}
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		orderdetailsService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Orderdetails u) {
		orderdetailsService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Orderdetails edit(int id) {
		return orderdetailsService.getById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Orderdetails o) {
		orderdetailsService.update(o);
		return "{\"status\":1}";
	}
}
