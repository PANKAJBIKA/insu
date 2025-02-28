package spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.Service.MedicalHistoryService;
import spring.entity.MedicalHistory;
@RestController
public class MedicalHistoryController {
    
	  @Autowired
	    private MedicalHistoryService medicalHistoryService;

	    @PostMapping("/add")
	    public MedicalHistory addMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
	        return medicalHistoryService.save(medicalHistory);
	    }

	    @GetMapping("/all")
	    public List<MedicalHistory> getAllMedicalHistories() {
	        return medicalHistoryService.findAll();
	    }

	    @GetMapping("/{id}")
	    public Optional<MedicalHistory> getMedicalHistoryById(@PathVariable Long id) {
	        return medicalHistoryService.findById(id);
	    }

	/*    @PutMapping("/update/{id}")
	    public String updateMedicalHistory(@PathVariable Long id, @RequestBody MedicalHistory medicalHistoryDetails) {
	       
	        medicalHistoryService.updateMedicalHistory(id,medicalHistoryDetails);
	        return "medical History updated";
	    }*/

	    @DeleteMapping("/delete/{id}")
	    public void deleteMedicalHistory(@PathVariable Long id) {
	        medicalHistoryService.deleteById(id);
	    }
	
	
	
}
