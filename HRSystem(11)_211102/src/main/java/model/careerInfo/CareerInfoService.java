package model.careerInfo;

import java.util.List;

public interface CareerInfoService {
	CareerInfoVO getData(CareerInfoVO vo);
	List<CareerInfoVO> getList(CareerInfoVO vo);
	boolean insertCareer(CareerInfoVO vo);
	boolean updateCareer(CareerInfoVO vo);
	boolean deleteCareer(CareerInfoVO vo);
}
