package spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.MedicalHistory;
@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Long>{

	
}
