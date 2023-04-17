package pl.mmiskiewicz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@ComponentScan(basePackages = "pl.mmiskiewicz")
@EnableAutoConfiguration*/
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

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
