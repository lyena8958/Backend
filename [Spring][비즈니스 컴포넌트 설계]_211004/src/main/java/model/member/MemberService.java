package model.member;

import java.util.List;

public interface MemberService {
	
		boolean insertMember(MemberVO vo);
		boolean updateMember(MemberVO vo);
		boolean deleteMember(MemberVO vo);
		List<MemberVO> getAll();
		MemberVO getOne(MemberVO vo);

}
