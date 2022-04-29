package estem.gwt.tp0.customer.service;

import estem.gwt.tp0.customer.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> getCustomers(Pageable pageable) throws Exception;
    Customer addCustomer(Customer customer) throws Exception;
    Customer updateCustomer(Customer customer) throws Exception;
    Customer deleteCustomer(Customer customer) throws Exception;
    Customer getCustomerById(Long id) throws Exception;
    Page<Customer> getCustomerByEmail(String email, Pageable pageable) throws Exception;
}
