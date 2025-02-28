package spring.Service;

import java.util.List;

import spring.entity.Doctor;

public interface DoctoeService {
	 public Doctor saveDoctor(Doctor doctor);
	    public List<Doctor> getAllDoctors() ;

	    public List<Doctor> findDoctorsByName(String name);

	    public List<Doctor> findDoctorsByRegion(String region) ;

	    public List<Doctor> findDoctorsBySpecialty(String specialty);
}
