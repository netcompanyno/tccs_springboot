package no.netcompany.tccs.sb.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/customer", consumes = "application/json")
    Long registerCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getName());
        Long customerId = customerService.registerCustomer(customer);

        return customerId;
    }

    @RequestMapping(path = "/customer/{customerId}")
    @ResponseBody
    ResponseEntity<Customer> fetchCustomer(@PathVariable("customerId") long customerId) {

        Optional<Customer> customer = customerService.findCustomerById(customerId);

        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
