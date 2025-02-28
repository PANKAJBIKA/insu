package spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.Insurance;
import spring.entity.InsuranceType;
@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
	
	 List<Insurance> findByType(InsuranceType type);
}
