package spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.entity.Doctor;
import spring.repo.DoctorRepo;
@Service
public class DoctorServiceImpl implements DoctoeService {
	  @Autowired
	  private DoctorRepo doctorRepo;
	  public Doctor saveDoctor(Doctor doctor) {
	        return doctorRepo.save(doctor);
	    }

	    public List<Doctor> getAllDoctors() {
	        return doctorRepo.findAll();
	    }

	    public List<Doctor> findDoctorsByName(String name) {
	        return doctorRepo.findByNameContainingIgnoreCase(name);
	    }

	    public List<Doctor> findDoctorsByRegion(String region) {
	        return doctorRepo.findByRegionContainingIgnoreCase(region);
	    }

	    public List<Doctor> findDoctorsBySpecialty(String specialty) {
	        return doctorRepo.findBySpecialtyContainingIgnoreCase(specialty);
	    }
	    
	    

}
