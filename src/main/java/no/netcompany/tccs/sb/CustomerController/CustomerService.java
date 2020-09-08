package no.netcompany.tccs.sb.CustomerController;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    Logger LOG = LoggerFactory.getLogger(CustomerService.class);
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

    @Cacheable("customerFindByName")
    public List<Customer> findByFirstName(final String name) throws InterruptedException {
        Thread.sleep(3000);
        return customerRepository.findByFirstName(name);
    }

    @Scheduled(fixedDelayString = "${scheduling.printNumberOfCustomers}")
    public void printNumberOfCustomers() {
        LOG.info("DB contains {} rows", customerRepository.count());
    }
}
