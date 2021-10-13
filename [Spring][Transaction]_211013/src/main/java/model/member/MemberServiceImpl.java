package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
		
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
		
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
		
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
