package spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.Service.InsuranceService;
import spring.entity.Insurance;
import spring.entity.InsuranceType;
@RestController
@RequestMapping("/insurances")
public class InsuranceController {
	
	 @Autowired
	    private InsuranceService insuranceService;

	    @PostMapping
	    public Insurance addInsurance(@RequestBody Insurance insurance) {
	        return insuranceService.saveInsurance(insurance);
	    }

	    @GetMapping
	    public List<Insurance> getAllInsurances() {
	        return insuranceService.getAllInsurances();
	    }

	    @GetMapping("/{id}")
	    public Insurance getInsuranceById(@PathVariable Long id) {
	        return insuranceService.getInsuranceById(id);
	    }

	    @GetMapping("/type")
	    public List<Insurance> getInsurancesByType(@RequestParam InsuranceType type) {
	        return insuranceService.getInsurancesByType(type);
	    }

}
