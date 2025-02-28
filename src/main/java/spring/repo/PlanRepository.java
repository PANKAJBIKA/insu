package spring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.plan;
@Repository
public interface PlanRepository extends JpaRepository<plan, Long> {

	Optional<plan> findPlanById(Long id);
    
}
