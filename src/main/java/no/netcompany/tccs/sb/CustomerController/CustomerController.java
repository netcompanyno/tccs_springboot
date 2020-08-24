package no.netcompany.tccs.sb.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/customer", consumes = "application/json")
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

}
