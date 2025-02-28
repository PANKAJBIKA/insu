package spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.Applicant;
import java.util.List;
import java.util.Optional;

@Repository
public interface appRepo extends JpaRepository<Applicant,Integer>{
	 List<Applicant> findByPhone(String phone);
	 
	Object findByemail(String email);

	Optional<Applicant> findApplicantByAppid(int appid);

}
