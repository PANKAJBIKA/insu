package spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.entity.plan;
import spring.repo.PlanRepository;
@Service
public class PlanService {
	 @Autowired
	    private PlanRepository planRepository;

	    public plan savePlan(plan plan) {
	        return planRepository.save(plan);
	    }

	    public List<plan> getAllPlans() {
	        return planRepository.findAll();
	    }

	    public plan getPlanById(Long id) {
	        return planRepository.findById(id).orElse(null);
	    }
}
