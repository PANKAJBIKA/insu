package spring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.entity.InsuranceBooking;
@Repository
public interface InsuranceBookingRepository extends CrudRepository<InsuranceBooking, Long> {

}
