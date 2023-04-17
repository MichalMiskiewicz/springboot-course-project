package pl.mmiskiewicz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mmiskiewicz.model.Customer;
import pl.mmiskiewicz.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    public void updateCustomerById(Integer customerId,
                                   Customer newCustomer) {
        Customer foundCustomer = customerRepository.findById(customerId).orElseThrow();
        foundCustomer.setName(newCustomer.getName());
        foundCustomer.setEmail(newCustomer.getEmail());
        foundCustomer.setAge(newCustomer.getAge());
        customerRepository.save(foundCustomer);
    }
}
