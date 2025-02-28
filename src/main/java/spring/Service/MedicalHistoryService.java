package spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;

import spring.entity.MedicalHistory;
import spring.repo.MedicalHistoryRepository;
@Service
public class MedicalHistoryService {
	  @Autowired
	    private MedicalHistoryRepository medicalHistoryRepository;

	    public MedicalHistory save(MedicalHistory medicalHistory) {
	        return medicalHistoryRepository.save(medicalHistory);
	    }

	    public List<MedicalHistory> findAll() {
	        return medicalHistoryRepository.findAll();
	    }

	    public Optional<MedicalHistory> findById(Long id) {
	        return medicalHistoryRepository.findById(id);
	    }

	    public void deleteById(Long id) {
	        medicalHistoryRepository.deleteById(id);
	    }
	/*    public String updateMedicalHistory( Long id,  MedicalHistory medicalHistoryDetails) {
	       Object medicalHistory = medicalHistoryRepository.findById(id);
	        if(medicalHistory==null) {
		    	 return "No MedicalHistory  found";
		    	 
		     } 
	        
	        ((MedicalHistory) medicalHistory).setCondition(medicalHistoryDetails.getCondition());
	        ((MedicalHistory) medicalHistory).setTreatment(medicalHistoryDetails.getTreatment());
	        ((MedicalHistory) medicalHistory).setStartDate(medicalHistoryDetails.getStartDate());
	        ((MedicalHistory) medicalHistory).setEndDate(medicalHistoryDetails.getEndDate());
	        ((MedicalHistory) medicalHistory).setNotes(medicalHistoryDetails.getNotes());
	         medicalHistoryRepository.saveAll(medicalHistory);
	        
			return "medicalHistory updated";

	       
	    }*/
}
