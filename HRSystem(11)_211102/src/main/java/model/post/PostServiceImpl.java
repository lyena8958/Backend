package model.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("postService")
public class PostServiceImpl implements PostService{

	@Autowired
	private PostDAO dao;
	
	@Override
	public PostVO getData(PostVO vo) {
		return dao.getData(vo);
	}

	@Override
	public List<PostVO> getList(PostVO vo) {
		return dao.getList(vo);
	}

	@Override
	public boolean insertPost(PostVO vo) {
		return dao.insertPost(vo);
	}

	@Override
	public boolean updatePost(PostVO vo) {
		return dao.updatePost(vo);
	}

	@Override
	public boolean deletePost(PostVO vo) {
		return dao.deletePost(vo);
	}

}
