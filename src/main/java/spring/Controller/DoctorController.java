package spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.Service.DoctorServiceImpl;
import spring.entity.Doctor;
@RestController
@RequestMapping("/doctors")
public class DoctorController {
	@Autowired
    private DoctorServiceImpl doctorser;
	 @PostMapping
	    public Doctor addDoctor(@RequestBody Doctor doctor) {
	        return doctorser.saveDoctor(doctor);
	    }

	    @GetMapping
	    public List<Doctor> getAllDoctors() {
	        return doctorser.getAllDoctors();
	    }

	    @GetMapping("/search")
	    public List<Doctor> searchDoctors(
	            @RequestParam(required = false) String name,
	            @RequestParam(required = false) String region,
	            @RequestParam(required = false) String specialty) {
	        
	        if (name != null) {
	            return doctorser.findDoctorsByName(name);
	        } else if (region != null) {
	            return doctorser.findDoctorsByRegion(region);
	        } else if (specialty != null) {
	            return doctorser.findDoctorsBySpecialty(specialty);
	        } else {
	            return doctorser.getAllDoctors();
	        }
	
}
}