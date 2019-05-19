/**
 * 
 */
package com.project.myapp.mapper;



import java.util.List;

import com.project.myapp.VO.MemberVO;

/**
 * @author oracle
 *
 */
public interface MemberMapper {
	
	void insertMember(MemberVO member);
	void updateMember(MemberVO member);
	List<MemberVO> getAllMembers();
	MemberVO getMember(String id);
	void deleteMember(String id);

}