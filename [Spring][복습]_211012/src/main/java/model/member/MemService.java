package model.member;

import java.util.List;

public interface MemService {
	
	public void insertMember(MemberVO vo);
	public void updateMember(MemberVO vo);
	public void deleteMember(MemberVO vo);
	public MemberVO getMember (MemberVO vo);
	public List<MemberVO> getListMember();
}
