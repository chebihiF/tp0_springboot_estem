package estem.gwt.tp0.customer.config;

import estem.gwt.tp0.customer.entities.Customer;
import estem.gwt.tp0.customer.entities.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

@Configuration
public class CustomerConfig {

    private final CustomerRepository customerRepository;

    public CustomerConfig(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Bean
    CommandLineRunner initCustomer(){
        return args -> {
            customerRepository.save(new Customer(null,"chebihi","chebihi@gmail.com", LocalDate.of(1888,05,15)));
            customerRepository
                    .findCustomerByEmailContains("gmail", PageRequest.of(1,10))
                    .forEach(System.out::println);
        };
    }
}
