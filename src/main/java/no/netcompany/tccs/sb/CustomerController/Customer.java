package no.netcompany.tccs.sb.CustomerController;

public class Customer {
    private Long id;
    private String name;

    protected Customer() {
    }

    public Customer(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
