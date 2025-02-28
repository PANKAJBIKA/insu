package spring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.entity.insorder;

@Repository
public interface insorderrepo extends CrudRepository<insorder, Integer>{
	insorder findByRazorPayOrderId(String razorPayOrderId);
}
