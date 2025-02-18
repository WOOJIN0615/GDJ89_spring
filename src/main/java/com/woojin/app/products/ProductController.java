package com.woojin.app.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList() throws Exception {
		System.out.println("product list");
		
		return "products/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail() throws Exception {
		System.out.println("product detail");
		
		return "products/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		System.out.println("product add");
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2() throws Exception {
		
		return "products/add";
	}
	
	
	

}
