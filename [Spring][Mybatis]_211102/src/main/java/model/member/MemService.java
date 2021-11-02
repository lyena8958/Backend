package model.member;

import java.util.List;

public interface MemService {
	
	public boolean insertMember(MemberVO vo);
	public boolean updateMember(MemberVO vo);
	public boolean deleteMember(MemberVO vo);
	public MemberVO getMember (MemberVO vo);
	public List<MemberVO> getListMember();
}
