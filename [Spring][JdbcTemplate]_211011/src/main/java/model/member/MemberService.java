package model.member;

import java.util.List;

public interface MemberService {
	
		void insertMember(MemberVO vo);
		void updateMember(MemberVO vo);
		void deleteMember(MemberVO vo);
		List<MemberVO> getAll();
		MemberVO getOne(MemberVO vo);

}
