package com.woojin.app.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.woojin.app.pages.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	

	//list
	public List<ProductDTO> getList(Pager pager) throws Exception {
		//Pager pager = new Pager();
		//pager.setPage(page);
		
		Long total=productDAO.count();
		
		pager.make(total);
		
		pager.makeNum();
		List<ProductDTO> ar=productDAO.getList(pager);
		System.out.println("Service List");
		
		return ar;
	}
	
	//add
	public int add(ProductDTO productDTO) throws Exception {
		int result = 1;
		
		result = productDAO.add(productDTO);
		return result;
	}
	
	//detail
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		productDTO = productDAO.detail(productDTO);
		
		return productDTO;
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		System.out.println("Service Update");
		return productDAO.update(productDTO);
	
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}
	
	public int addComments(CommentsDTO commentsDTO) throws Exception{
		return productDAO.addComments(commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(CommentsDTO commentsDTO, Pager pager) throws Exception {
		Long total = productDAO.count();
		
		pager.make(total);
		pager.makeNum();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("comments", commentsDTO);
		map.put("pager", pager);
		
		List<CommentsDTO> ar = productDAO.getCommentList(map);
		return ar;
	}

}
