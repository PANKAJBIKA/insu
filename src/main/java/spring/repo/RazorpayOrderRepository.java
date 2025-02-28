package spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.RazorpayOrder;
@Repository
public interface RazorpayOrderRepository extends JpaRepository<RazorpayOrder, Long>{
    RazorpayOrder findByOrderId(String orderId);

}
