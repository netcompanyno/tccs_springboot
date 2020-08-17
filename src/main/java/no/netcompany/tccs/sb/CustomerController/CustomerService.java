package no.netcompany.tccs.sb.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long registerCustomer(final Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer.getId();
    }

    public Optional<Customer> findCustomerById(final long customerId) {
        return customerRepository.findById(customerId);
    }
}
