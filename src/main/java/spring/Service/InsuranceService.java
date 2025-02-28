package spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.entity.Insurance;
import spring.entity.InsuranceType;
import spring.entity.plan;
import spring.repo.InsuranceRepository;
@Service
public class InsuranceService {
	  @Autowired
	    private InsuranceRepository insuranceRepository;

	    public Insurance saveInsurance(Insurance insurance) {
	    	 for (plan plan : insurance.getPlans()) {
	             plan.setInsurance(insurance);
	         }
	        return insuranceRepository.save(insurance);
	    }

	    public List<Insurance> getAllInsurances() {
	        return insuranceRepository.findAll();
	    }

	    public Insurance getInsuranceById(Long id) {
	        return insuranceRepository.findById(id).orElse(null);
	    }

	    public List<Insurance> getInsurancesByType(InsuranceType type) {
	        return insuranceRepository.findByType(type);
	    }
}
