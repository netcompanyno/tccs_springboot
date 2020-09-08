package no.netcompany.tccs.sb.CustomerController;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO {
    private final String name;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Date dateOfBirth;
    private final String email;
    private final String address;
    private final Boolean consent;

    public CustomerDTO(final String name,
                       final String firstName,
                       final String lastName,
                       final int age,
                       final Date dateOfBirth,
                       final String email,
                       final String address,
                       final Boolean consent) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.consent = consent;
    }

    public String getName() {
        return name;
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
        return "CustomerDTO{" +
               "name='" + name + '\'' +
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
