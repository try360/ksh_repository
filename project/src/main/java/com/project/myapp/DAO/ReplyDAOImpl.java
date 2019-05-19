package com.project.myapp.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myapp.VO.ReplyVO;

@Service
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ReplyVO> replyList(int writing_no) {
		return sqlSession.selectList("listReply", writing_no);
	}

	@Override
	public void replyInsert(ReplyVO replyVO) {
		sqlSession.insert("insertReply", replyVO);
	}

	@Override
	public void replyUpdate(ReplyVO replyVO) {

	}

	@Override
	public int countReply(int writing_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("countReply", writing_no);
	}

	@Override
	public void deleteReply(int reply_no) {
		sqlSession.delete("deleteReply", reply_no);
	}

}
