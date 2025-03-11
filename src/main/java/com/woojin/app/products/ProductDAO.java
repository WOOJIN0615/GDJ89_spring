package com.woojin.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woojin.app.boards.CommentDTO;
import com.woojin.app.pages.Pager;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.woojin.app.products.ProductDAO.";
	
	@Autowired
	private ProductDTO productDTO;

	public List<ProductDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getlist", pager);
	}
	
	public Long count() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"count");
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"add", productDTO);
	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		//statement => mapper의 ID값을 넣음.
		return sqlSession.selectOne(NAMESPACE+"detail", productDTO);
		
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", productDTO); 
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", productDTO);
	}
	
	public int addComments(CommentsDTO commentsDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"addComments", commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCommentList", map);
	}
	
	public Long countComment(CommentsDTO commentsDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"countComment", commentsDTO);
	}
	
	
}
