package model.careerInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("careerInfoService")
public class CareerInfoServiceImpl implements CareerInfoService{

	@Autowired
	private CareerInfoDAO dao;
	
	@Override
	public CareerInfoVO getData(CareerInfoVO vo) {
		return dao.getData(vo);
	}

	@Override
	public List<CareerInfoVO> getList(CareerInfoVO vo) {
		return dao.getList(vo);
	}

	@Override
	public boolean insertCareer(CareerInfoVO vo) {
		return dao.insertCareer(vo);
	}

	@Override
	public boolean updateCareer(CareerInfoVO vo) {
		return dao.updateCareer(vo);
	}

	@Override
	public boolean deleteCareer(CareerInfoVO vo) {
		return dao.deleteCareer(vo);
	}

}
