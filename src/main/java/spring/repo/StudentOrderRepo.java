package spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.entity.StudentOrder;
@Repository
public interface StudentOrderRepo extends CrudRepository<StudentOrder, Long> {
	public StudentOrder findByRazorPayOrderId(String razorPayOrderId);
}
