package estem.gwt.tp0.customer.service;

import estem.gwt.tp0.customer.dao.CustomerRepository;
import estem.gwt.tp0.customer.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> getCustomers(Pageable pageable) throws Exception {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer addCustomer(Customer customer) throws Exception {
        if(customer.getName().length()<2) throw new RuntimeException("this name is invalid");
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws Exception {
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(Customer customer) throws Exception {
        customerRepository.delete(customer);
        return customer;
    }

    @Override
    public Customer getCustomerById(Long id) throws Exception {
        if(customerRepository.findById(id).isPresent()) throw new RuntimeException("customer not found");
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> getCustomerByEmail(String email, Pageable pageable) throws Exception {
        return customerRepository.findCustomerByEmailContains(email,pageable);
    }
}
