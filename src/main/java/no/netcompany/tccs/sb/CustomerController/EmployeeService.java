package no.netcompany.tccs.sb.CustomerController;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public Long registerCustomer(final Customer customer) {
        return Math.round(Math.random() * 100L);
    }
}
