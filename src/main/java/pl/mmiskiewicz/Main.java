package pl.mmiskiewicz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/*@ComponentScan(basePackages = "pl.mmiskiewicz")
@EnableAutoConfiguration*/
@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping()
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);

        customerRepository.save(customer);
    }

    @DeleteMapping("{customer_id}")
    public void deleteCustomer(@PathVariable("customer_id") Integer customerId) {

        customerRepository.deleteById(customerId);
    }

    @PutMapping("{customer_id}")
    public void updateCustomer(@PathVariable("customer_id") Integer customerId,
                               @RequestBody NewCustomerRequest request) {
        Customer foundCustomer = customerRepository.findById(customerId).orElseThrow();
        foundCustomer.setName(request.name);
        foundCustomer.setEmail(request.email);
        foundCustomer.setAge(request.age);
        customerRepository.save(foundCustomer);
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ){}

    /*@GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse(
                "Hello",
                List.of("Java", "Golang", "JavaScript"),
                new Person("Alex", 24, 30_000)
        );

        return response;
    }

    record Person (String name, int age, double savings){}
    record GreetResponse(
            String greet,
            List<String> favPogrammingLanguages,
            Person person
    ) {}*/
}
