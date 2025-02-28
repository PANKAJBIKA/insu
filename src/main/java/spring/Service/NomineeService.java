package spring.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.entity.Nominee;
import spring.repo.NomineeRepository;
@Service
public class NomineeService {
	  @Autowired
	    private NomineeRepository nomineeRepository;
	  public List<Nominee> findNomineesByInsuranceBookingId(Long insuranceBookingId) {
	        return StreamSupport.stream(nomineeRepository.findAll().spliterator(), false)
	                .filter(nominee -> nominee.getInsuranceBooking().getIB_id().equals(insuranceBookingId))
	                .collect(Collectors.toList());
	    }

}
