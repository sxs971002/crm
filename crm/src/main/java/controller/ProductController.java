package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Product;
import service.ProductService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_product.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(productService.selectCount(where));
		info.setList(productService.getAll(where,lim));
		return info;
	}
	
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		productService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Product u) {
		productService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Product edit(int id) {
		return productService.selectById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Product u) {
		productService.update(u);
		return "{\"status\":1}";
	}
}
