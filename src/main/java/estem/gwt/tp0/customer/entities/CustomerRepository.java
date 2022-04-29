package estem.gwt.tp0.customer.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findCustomerByEmailContains(String email);
    List<Customer> findCustomerByNameStartingWith(String keyword);

    @Query("from Customer c where c.name like '%:mc%' or c.email like '%:mc%'")
    List<Customer> recherche(String mc);
}
