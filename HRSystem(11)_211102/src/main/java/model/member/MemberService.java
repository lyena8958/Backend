package model.member;

import java.util.List;

public interface MemberService {
	MemberSet getSetList(MemberVO vo);
	MemberVO getData(MemberVO vo);
	List<MemberVO> getList(MemberVO vo);
	boolean insertMember(MemberVO vo);
	boolean updateMember(MemberVO vo);
	boolean deleteMember(MemberVO vo);
	
}
