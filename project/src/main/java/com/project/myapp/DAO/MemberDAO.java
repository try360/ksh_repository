package com.project.myapp.DAO;



import java.util.List;

import com.project.myapp.VO.MemberVO;
import com.project.myapp.VO.WritingVO;

public interface MemberDAO {
	public void insertMember(MemberVO memberVO); // 회원가입 작성
	public List<MemberVO> listAll(); // 멤버 전체 목록
	public List<MemberVO> getAllMembers(); // 게시글 전체 목록
	
}
