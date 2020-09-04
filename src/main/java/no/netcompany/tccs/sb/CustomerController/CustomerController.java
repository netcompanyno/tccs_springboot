package no.netcompany.tccs.sb.CustomerController;

import no.netcompany.tccs.sb.aop.LogExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/customer", consumes = "application/json")
    @LogExecutionTime
    Long registerCustomer(@RequestBody CustomerDTO customerDTO) {
        final Customer customer = new Customer(
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getAge(),
                customerDTO.getDateOfBirth(),
                customerDTO.getEmail(),
                customerDTO.getAddress(),
                customerDTO.getConsent());

        final Long customerId = customerService.registerCustomer(customer);

        return customerId;
    }

    @GetMapping(path = "/customer/{customerId}")
    @LogExecutionTime
    ResponseEntity<Customer> fetchCustomer(@PathVariable("customerId") long customerId) {

        Optional<Customer> customer = customerService.findCustomerById(customerId);

        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/customer")
    @LogExecutionTime
    ResponseEntity<List<Customer>> fetchCustomerByFirstName(@RequestParam("firstName") String firstName)
            throws InterruptedException {

        if (firstName == null) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        return ResponseEntity.ok(customerService.findByFirstName(firstName));
    }
}
