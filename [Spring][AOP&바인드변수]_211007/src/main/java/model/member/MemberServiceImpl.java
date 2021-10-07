package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

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
	public List<MemberVO> getAll() {
		return memberDAO.getAll();
	}

	@Override
	public MemberVO getOne(MemberVO vo) {
		return memberDAO.getOne(vo);
	}

}
