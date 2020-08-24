package no.netcompany.tccs.sb.CustomerController;

import java.util.Date;

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Date dateOfBirth;
    private String email;
    private String address;
    private Boolean consent;

    public Customer(final String firstName,
                    final String lastName,
                    final int age,
                    final Date dateOfBirth,
                    final String email,
                    final String address, final Boolean consent) {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.consent = consent;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public Boolean getConsent() {
        return consent;
    }

    public void setConsent(final Boolean consent) {
        this.consent = consent;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", age=" + age +
               ", dateOfBirth=" + dateOfBirth +
               ", email='" + email + '\'' +
               ", address='" + address + '\'' +
               ", consent=" + consent +
               '}';
    }
}
