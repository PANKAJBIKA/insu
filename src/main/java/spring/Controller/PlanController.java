package spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.Service.PlanService;
import spring.entity.plan;
@RestController
@RequestMapping("/plan")
public class PlanController {
	 @Autowired
	    private PlanService planService;

	    @PostMapping
	    public plan addPlan(@RequestBody plan plan) {
	        return planService.savePlan(plan);
	    }

	    @GetMapping
	    public List<plan> getAllPlans() {
	        return planService.getAllPlans();
	    }

	    @GetMapping("/{id}")
	    public plan getPlanById(@PathVariable Long id) {
	        return planService.getPlanById(id);
	    }
}
