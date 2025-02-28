package spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.entity.InsuranceBooking;
import spring.entity.Nominee;
import spring.repo.InsuranceBookingRepository;
@Service
public class InsuranceBookingService {
	  @Autowired
	    private InsuranceBookingRepository insuranceBookingRepository;

	    public InsuranceBooking saveBooking(InsuranceBooking booking) {
	    	for(Nominee nm : booking.getNominees()) {
	    		nm.setInsuranceBooking(booking);
	    	}
	    	
	        return insuranceBookingRepository.save(booking);
	    }

	    public Optional<InsuranceBooking> findBookingById(Long id) {
	        return insuranceBookingRepository.findById(id);
	    }

	    public List<InsuranceBooking> findAllBookings() {
	        return (List<InsuranceBooking>) insuranceBookingRepository.findAll();
	    }

	    public void deleteBooking(Long id) {
	        insuranceBookingRepository.deleteById(id);
	    }
}
