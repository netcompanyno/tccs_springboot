package no.netcompany.tccs.sb.CustomerController;

import no.netcompany.tccs.sb.aop.LogExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/customer", consumes = "application/json")
    @LogExecutionTime
    Long registerCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getName());
        Long customerId = customerService.registerCustomer(customer);

        return customerId;
    }

    @RequestMapping(path = "/customer/{customerId}")
    @ResponseBody
    @LogExecutionTime
    ResponseEntity<Customer> fetchCustomer(@PathVariable("customerId") long customerId) {

        Optional<Customer> customer = customerService.findCustomerById(customerId);

        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping(path = "/customer/name/{name}")
    @ResponseBody
    @LogExecutionTime
    ResponseEntity<Customer> fetchCustomer(@PathVariable("name") String name) throws InterruptedException {

        Optional<Customer> customer = customerService.findByName(name);

        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
