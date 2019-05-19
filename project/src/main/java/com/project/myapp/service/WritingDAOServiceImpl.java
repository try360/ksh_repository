package com.project.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myapp.DAO.WritingDAO;
import com.project.myapp.VO.PageParamsVO;
import com.project.myapp.VO.WritingVO;

@Service
public class WritingDAOServiceImpl implements WritingDAOService {

	@Autowired
	private WritingDAO writingDAO;

	public void inserWriting(WritingVO writingVO) {
		System.out.println("     WritingDAOServiceImpl  insertwriting()    ");
		writingDAO.insertWriting(writingVO);
	}

	public List<WritingVO> getAllWriting() {

		System.out.println("      WritingDAOServiceImpl   getAllWriting()    ");
		return writingDAO.getAllWriting();
	}

	@Override
	public List<WritingVO> listPage(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WritingVO> searchWritingList(PageParamsVO pageParamsVO) {
		// TODO Auto-generated method stub
		return writingDAO.searchWritingList(pageParamsVO);
	}

	@Override
	public WritingVO referWriting(int w_no) {
		System.out.println("         WritingDAOService referWriting()   ");
		// TODO Auto-generated method stub
		return writingDAO.referWriting(w_no);
	}

	@Override
	public void truncateAll() {
		System.out.println("         WritingDAOService truncateAll()");
		writingDAO.truncateAll();
	}

	@Override
	public void deleteWriting(int w_no) {
		writingDAO.deleteWriting(w_no);
		// 저장된 파일 삭제
	}

	@Override
	public WritingVO getWriting(int w_no) {
		return writingDAO.getWriting(w_no);
	}

	@Override
	public int searchCountWritingList(PageParamsVO pageParamsVO) {

		return writingDAO.searchCountWritingList(pageParamsVO);
	}

	@Override
	public int countAllWriting() {
		// TODO Auto-generated method stub
		return writingDAO.countAllWriting() ;
	}

	@Override
	public List<WritingVO> pagedWritingList(PageParamsVO pageParamsVO) {
		// TODO Auto-generated method stub
		return writingDAO.pagedWritingList(pageParamsVO);
	}

	@Override
	public void viewCount(int w_no) {
		writingDAO.viewCount(w_no);
	}

	@Override
	public void updateWriting(WritingVO writingVO) {
		// TODO Auto-generated method stub
		writingDAO.updateWriting(writingVO);
	}

	@Override
	public String getDesign_score(int w_no) {
		// TODO Auto-generated method stub
		return writingDAO.getDesign_score(w_no);
	}

	@Override
	public String getPrr_score(int w_no) {
		// TODO Auto-generated method stub
		return writingDAO.getPrr_score(w_no);
	}

	@Override
	public String getDurablity_score(int w_no) {
		// TODO Auto-generated method stub
		return writingDAO.getDurablity_score(w_no);
	}



}
