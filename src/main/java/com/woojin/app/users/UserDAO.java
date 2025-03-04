package com.woojin.app.users;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
