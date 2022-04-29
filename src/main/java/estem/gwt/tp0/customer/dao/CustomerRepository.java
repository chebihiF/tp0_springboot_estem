package estem.gwt.tp0.customer.dao;

import estem.gwt.tp0.customer.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findCustomerByEmailContains(String email, Pageable pageable);
    List<Customer> findCustomerByNameStartingWith(String keyword);

    @Query("from Customer c where c.name like '%:mc%' or c.email like '%:mc%'")
    List<Customer> recherche(String mc);
}
