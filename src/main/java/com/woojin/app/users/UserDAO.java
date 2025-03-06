package com.woojin.app.users;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woojin.app.products.ProductDTO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.woojin.app.users.UserDAO.";
	
	@Autowired
	private UserDTO userDTO;

	
	public int join(UserDTO userDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"join", userDTO);
	}
	
	public UserDTO detail(UserDTO userDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail", userDTO);
	}
	
	public int update(UserDTO userDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", userDTO);
	}
	public int updateFile(UserFileDTO userFileDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"updateFile", userFileDTO);
	}
	
	public int upload(UserFileDTO userFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"upload", userFileDTO);
	}
	
	public int addCart(Map<String, Object> map) throws Exception{
		return sqlSession.insert(NAMESPACE+"addCart", map);
	}
	
	public List<ProductDTO> getCartList(Map<String, Object> map)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCartList", map);
	}
	
	public Long getCartTotalCount(Object userDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCartTotalCount", userDTO);
	}
}
