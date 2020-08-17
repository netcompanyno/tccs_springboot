package no.netcompany.tccs.sb.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private EmployeeService employeeService;

    @Autowired
    public CustomerController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/customer", consumes = "application/json")
    Long registerCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getName());
        Long customerId = employeeService.registerCustomer(customer);

        return customerId;
    }

}
