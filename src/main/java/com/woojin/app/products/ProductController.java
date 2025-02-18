package com.woojin.app.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService; 
	
	/**
	 * Model -> requestScope와 Lifecycle이 비슷
	 * 응답이 발생하면 소멸
	 * request와 비슷한 작업을 수행
	 * java > jsp로 데이터를 전달할 때 사용
	 */
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {
		System.out.println("product list");
		List<ProductDTO> ar=productService.getList();
		model.addAttribute("list", ar);
		
		return "products/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(String productName) throws Exception {
		System.out.println("product detail");
		return "products/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		System.out.println("product add");
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2(ProductDTO productDTO) throws Exception {
		/**
		 * 모든 요청 정보는 Request에 있다.(URL, METHOD, PARAMETER, COOKIE...)
		 * 1. 메서드의 매개변수로 HttpServletRequest 선언 후 getParameter로 입력한 데이터 가져옴
		 * 
		 * 2. 메서드의 매개변수로 가져올 파라미터의 데이터 타입과 파라미터의 이름을 변수명으로 지정하여 선언한다.
		 * 
		 * 3. 매개변수로 Bean(DTO)를 선언
		 *    파라미터의 이름과 타입이 DTO의 Setter의 이름과 동일
		 */
		int result=productService.add(productDTO);
		
		
		//return "products/add";
		return "redirect:./list";
	}
	
}
