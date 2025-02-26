package com.woojin.app.qna;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woojin.app.pages.Pager;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.woojin.app.qna.QnaDAO.";
	
	@Autowired
	private QnaDTO qnaDTO;
	
	public List<QnaDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", qnaDTO);
	}
	
	public Long count() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"count");
	}
	
	public int add(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", qnaDTO);
	}
	
	public int update(QnaDTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update", qnaDTO);
	}
	
	public int delete(QnaDTO qnaDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", qnaDTO);
	}
	
	public int updateHit(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"updateHit", qnaDTO);
	}
}
