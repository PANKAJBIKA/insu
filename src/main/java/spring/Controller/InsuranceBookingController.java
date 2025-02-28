package spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import spring.Service.ApplicantService;
import spring.Service.InsuranceBookingService;
import spring.Service.NomineeService;
import spring.Service.PlanService;
import spring.entity.Applicant;
import spring.entity.InsuranceBooking;
import spring.entity.plan;
import spring.repo.PlanRepository;
import spring.repo.appRepo;

@RestController
@RequestMapping("/booking")
public class InsuranceBookingController {
	 @Autowired
	    private InsuranceBookingService insuranceBookingService;

	    @Autowired
	    private ApplicantService applicantService;

	    @Autowired
	    private PlanService planService;

	    @Autowired
	    private NomineeService nomineeService;
	    @Autowired
		 private  appRepo apre;
	    @Autowired
	    private PlanRepository planRepository;
	   
	   
	    @PostMapping
	    public ResponseEntity<InsuranceBooking> createBooking(@RequestBody InsuranceBooking booking) {
	        Optional<Applicant> applicant = apre.findApplicantByAppid(booking.getApplicant().getAppid());
	        Optional<plan> plan = planRepository.findPlanById(booking.getPlan().getId());

	        if (applicant.isEmpty() || plan.isEmpty()) {
	            return ResponseEntity.badRequest().build();
	        }

	        booking.setApplicant(applicant.get());
	        booking.setPlan(plan.get());
                
	        InsuranceBooking savedBooking = insuranceBookingService.saveBooking(booking);
	        return ResponseEntity.ok(savedBooking);
	    }
       
	   /*@PostMapping("/pay")
	    public ResponseEntity<String> createPayment(@RequestParam double amount) {
	        try {
	            Order order = razorpayService.createOrder(amount);
	            return ResponseEntity.ok(order.toString());
	        } catch (RazorpayException e) {
	            return ResponseEntity.status(500).body(e.getMessage());
	        }
	    }*/
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<InsuranceBooking> getBooking(@PathVariable Long id) {
	        Optional<InsuranceBooking> booking = insuranceBookingService.findBookingById(id);
	        if (booking.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        InsuranceBooking existingBooking = booking.get();
	        existingBooking.setNominees(nomineeService.findNomineesByInsuranceBookingId(existingBooking.getIB_id()));
	        return ResponseEntity.ok(existingBooking);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<InsuranceBooking> updateBooking(@PathVariable Long id, @RequestBody InsuranceBooking updatedBooking) {
	        Optional<InsuranceBooking> existingBooking = insuranceBookingService.findBookingById(id);
	        if (existingBooking.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        InsuranceBooking booking = existingBooking.get();
	        Optional<Applicant> applicant = apre.findApplicantByAppid(updatedBooking.getApplicant().getAppid());
	        Optional<plan> plan = planRepository.findPlanById(updatedBooking.getPlan().getId());

	        if (applicant.isEmpty() || plan.isEmpty()) {
	            return ResponseEntity.badRequest().build();
	        }

	        booking.setApplicant(applicant.get());
	        booking.setPlan(plan.get());
	        booking.setBookingDate(updatedBooking.getBookingDate());
	        booking.setBookingEndDate(updatedBooking.getBookingEndDate());
	        booking.setNominees(updatedBooking.getNominees());

	        InsuranceBooking savedBooking = insuranceBookingService.saveBooking(booking);
	        return ResponseEntity.ok(savedBooking);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
	        Optional<InsuranceBooking> booking = insuranceBookingService.findBookingById(id);
	        if (booking.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        insuranceBookingService.deleteBooking(id);
	        return ResponseEntity.noContent().build();
	    }

	    @PutMapping("/{id}/renew")
	    public ResponseEntity<InsuranceBooking> renewBooking(@PathVariable Long id, @RequestBody InsuranceBooking newBookingDate) {
	        Optional<InsuranceBooking> existingBooking = insuranceBookingService.findBookingById(id);
	        if (existingBooking.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        InsuranceBooking booking = existingBooking.get();
	        booking.setBookingDate(newBookingDate.getBookingDate());
	        booking.setBookingEndDate(newBookingDate.getBookingEndDate());
            InsuranceBooking renewedBooking = insuranceBookingService.saveBooking(booking);
	        return ResponseEntity.ok(renewedBooking);
	    }
	 

	    @GetMapping
	    public ResponseEntity<List<InsuranceBooking>> getAllBookings() {
	        List<InsuranceBooking> bookings = insuranceBookingService.findAllBookings();
	        return ResponseEntity.ok(bookings);
	    }

}
