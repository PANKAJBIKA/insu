package spring.repo;

import org.springframework.data.repository.CrudRepository;

import spring.entity.Nominee;

public interface NomineeRepository extends CrudRepository<Nominee, Long> {

}
