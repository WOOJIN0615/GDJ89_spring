	package com.woojin.app.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.woojin.app.pages.Pager;
import com.woojin.app.users.UserDTO;

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
	public void getList(Model model, Pager pager) throws Exception {
		System.out.println("product list");
		List<ProductDTO> ar=productService.getList(pager);
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		System.out.println("product add");
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ProductDTO productDTO) throws Exception {
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
		System.out.println(productDTO.getProductDate().toString());
		
		//return "products/add";
		return "redirect:./list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(ProductDTO productDTO, ModelAndView mv) throws Exception {
		System.out.println("product detail");
		productDTO = productService.detail(productDTO);
		mv.setViewName("products/detail");
		mv.addObject("dto", productDTO);
		
		return mv;
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
		public ModelAndView update(ProductDTO productDTO, ModelAndView mv) throws Exception {
		System.out.println("controller update");
		mv.setViewName("products/update");
		mv.addObject("dto", productService.detail(productDTO));
		return mv;
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO productDTO) throws Exception {
		System.out.println("product update");
		int result = productService.update(productDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(ProductDTO productDTO, ModelAndView mv) throws Exception {
		mv.setViewName("products/delete");
		mv.addObject("dto", productService.delete(productDTO));
		
		return mv;
	}
	
	@RequestMapping(value = "addComments", method = RequestMethod.POST)
	public String addComments(CommentsDTO commentsDTO, Model model, HttpSession session) throws Exception{
		System.out.println("comments add");
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		commentsDTO.setUsername(userDTO.getUsername());
		
		int result = productService.addComments(commentsDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "listComments", method = RequestMethod.GET)
	public String listComments(Model model, Pager pager, CommentsDTO commentsDTO) throws Exception{
		System.out.println("comments List");
		List<CommentsDTO> ar=productService.getCommentsList(commentsDTO, pager);
		model.addAttribute("list", ar);
		
		return "commons/commentsList";
	}
	
	@RequestMapping(value = "deleteComments", method = RequestMethod.POST)
	public String deleteComments(CommentsDTO commentsDTO, HttpSession session, Model model) throws Exception{
		System.out.println("deleteComments");
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		commentsDTO.setUsername(userDTO.getUsername());
		int result=productService.deleteComments(commentsDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "updateComments", method = RequestMethod.POST)
	public String updateComments(CommentsDTO commentsDTO, Model model) throws Exception{
		int result = productService.updateComments(commentsDTO);
		System.out.println(commentsDTO.getBoardContents());
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "detailFiles", method = RequestMethod.POST)
	public String detailFiles(MultipartFile uploadFile, HttpSession session, Model model) throws Exception{
		String filename = productService.detailFiles(uploadFile, session);
		filename = "/resources/images/products/"+filename;
		
		model.addAttribute("result", filename);
		
		return "commons/ajaxResult";
	}
	
}
