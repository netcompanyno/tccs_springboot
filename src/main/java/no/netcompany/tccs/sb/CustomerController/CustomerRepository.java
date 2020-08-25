package no.netcompany.tccs.sb.CustomerController;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByName(final String name);

}
