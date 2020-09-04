package no.netcompany.tccs.sb.CustomerController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Date dateOfBirth;
    private String email;
    private String address;
    private Boolean consent;

    public Customer() {
    }

    public Customer(final String firstName,
                    final String lastName,
                    final int age,
                    final Date dateOfBirth,
                    final String email,
                    final String address,
                    final Boolean consent) {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getConsent() {
        return consent;
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
