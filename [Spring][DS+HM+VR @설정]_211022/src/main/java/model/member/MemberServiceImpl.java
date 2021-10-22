package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public boolean insertMember(MemberVO vo) {
		return memberDAO.insertMember(vo);
		
	}

	@Override
	public boolean updateMember(MemberVO vo) {
		return memberDAO.updateMember(vo);
		
	}

	@Override
	public boolean deleteMember(MemberVO vo) {
		return memberDAO.deleteMember(vo);
		
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		return memberDAO.getMember(vo);
		/*try {
			return memberDAO.getMember(vo);
		}catch(Exception e) {
			return null;
		}*/
	}

	@Override
	public List<MemberVO> getListMember() {
		return memberDAO.getListMember();
	}
	
}
