package pl.mmiskiewicz.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mmiskiewicz.model.Customer;
import pl.mmiskiewicz.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping()
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);

        customerService.addNewCustomer(customer);
    }

    @DeleteMapping("{customer_id}")
    public void deleteCustomer(@PathVariable("customer_id") Integer customerId) {

        customerService.deleteCustomerById(customerId);
    }

    @PutMapping("{customer_id}")
    public void updateCustomer(@PathVariable("customer_id") Integer customerId,
                               @RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerService.updateCustomerById(customerId, customer);
    }

    public record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ) {
    }
}
