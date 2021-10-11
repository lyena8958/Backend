package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SpringMemberDAO memberDAO; //  MemberDAO memberDAO;
	
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
	public List<MemberVO> getAll() {
		return memberDAO.getAll();
	}

	@Override
	public MemberVO getOne(MemberVO vo) {
		return memberDAO.getOne(vo);
	}

}
