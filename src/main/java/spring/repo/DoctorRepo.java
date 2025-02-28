package spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
	List<Doctor> findByNameContainingIgnoreCase(String name);
    List<Doctor> findByRegionContainingIgnoreCase(String region);
    List<Doctor> findBySpecialtyContainingIgnoreCase(String specialty);
}
