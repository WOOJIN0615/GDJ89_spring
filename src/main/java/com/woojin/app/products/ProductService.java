package com.woojin.app.products;

import java.util.List;

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
		
		//1. Totalpage
		Long totalpage = total/10;
		if (total%10!=0) {
			totalpage++;
		}
		
		//2. TotalBlock
		Long totalBlock = totalpage/5;
		if (totalpage % 5 !=0) {
			totalBlock++;
		}
		
		//3. page번호로 block번호 구하기
		Long curBlock = pager.getPage()/5;
		if (pager.getPage()%5!=0) {
			curBlock++;
		}
		
		//4. Block번호로 시작번호, 끝번호 계산
		Long start = (curBlock-1)*5+1;
		Long end = curBlock*5;
		
		pager.setStart(start);
		pager.setEnd(end);
		
		//5. curBlock이 마지막 Block이라면
		if (totalBlock==curBlock) {
			pager.setEnd(totalpage);
			pager.setEndCheck(true);
		}
		
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

}
