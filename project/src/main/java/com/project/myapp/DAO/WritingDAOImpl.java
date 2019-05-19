package com.project.myapp.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myapp.VO.PageParamsVO;
import com.project.myapp.VO.WritingVO;
import com.project.myapp.mapper.WritingMapper;

@Repository
public class WritingDAOImpl implements WritingDAO {

	@Autowired
	// @Resource(name = "sqlSession")
	// private SqlSessionTemplate sqlsession;
	private SqlSession sqlSession;

	@Override
	public void insertWriting(WritingVO writingVO) {

		System.out.println("   WritingDAOImpl insertWriting()    ");
		// sqlSession.getMapper(WritingDAO.class).insertWriting(writingVO);
		sqlSession.insert("insertWriting", writingVO); // 맵퍼 불러서 실행함
	}
	/*
	 * public List selectBoardDetail(WritingVO writingVo) {
	 * sqlsession.getMapper(WritingMapper.class).getAllwriting(); return result;
	 * }
	 */

	@Override
	public List<WritingVO> getAllWriting() {
		System.out.println("      WritingDAOImpl    getAllWriting()    ");
		return sqlSession.selectList("getAllWriting");
	}

	@Override
	public void updateWriting(WritingVO writingVO) {
		//sqlSession.getMapper(WritingMapper.class).updateWriting(writingVO);
		sqlSession.update("updateWriting",writingVO);
	}

	@Override
	public void inscreaseWritingCount(int w_count) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<WritingVO> searchWritingList(PageParamsVO pageParamsVO) {
		System.out.println("      WritingDAOImpl    searchWritingList()    pageParamsVO  : " + pageParamsVO);
		return sqlSession.getMapper(WritingMapper.class).searchWritingList(pageParamsVO);

	}

	@Override
	public int searchCountWritingList(PageParamsVO pageParamsVO) {

		System.out.println("   WritingDAOImpl      searchCountWRitingList()    :  pageParamsVO" + pageParamsVO);
		return sqlSession.getMapper(WritingMapper.class).searchCountWritingList(pageParamsVO);
	}

	@Override
	public WritingVO referWriting(int w_no) {
		System.out.println("     WritingDAOServiceImpl   referWriting()   ");

		return sqlSession.getMapper(WritingMapper.class).referWriting(w_no);
		// mybatis 에서 쓰는 getMapper
		// return sqlSession.selectOne(namespace+".referWriting",w_no);
	}

	@Override
	public void truncateAll() {
		// TODO Auto-generated method stub
		sqlSession.getMapper(WritingMapper.class).truncateAll();
	}

	@Override
	public void deleteWriting(int w_no) {
		sqlSession.getMapper(WritingMapper.class).deleteWriting(w_no);
	}

	@Override
	public WritingVO getWriting(int w_no) {
		return sqlSession.getMapper(WritingMapper.class).getWriting(w_no);
	}

	@Override
	public List<WritingVO> pagedWritingList(PageParamsVO pageParamsVO) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(WritingMapper.class).searchWritingList(pageParamsVO);
	}

	@Override
	public int countAllWriting() {
		// 전체글 수 가져오기
		return sqlSession.selectOne("countAllWriting");
	}

	@Override
	public void viewCount(int w_no) {
		sqlSession.getMapper(WritingMapper.class).viewCount(w_no);
	}

	@Override
	public String getDesign_score(int w_no) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(WritingMapper.class).getDesign_score(w_no);
	}

	@Override
	public String getPrr_score(int w_no) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(WritingMapper.class).getPrr_score(w_no);
	}

	@Override
	public String getDurablity_score(int w_no) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(WritingMapper.class).getDurablity_score(w_no);
	}

}
