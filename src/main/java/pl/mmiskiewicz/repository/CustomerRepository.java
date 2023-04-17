package pl.mmiskiewicz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mmiskiewicz.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
