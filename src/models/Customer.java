package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import utilities.GenderType;

public class Customer {
//variables

    private String title;
    private String firstName;
    private String surName;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerNumber;
    private Date expiryDate;
    private GenderType gender;
    private boolean isValid;

    public Customer(String title, String firstName, String surName, String address,
            String phoneNumber, String email, String customerNumber, GenderType gender) {

// calls private, private kan bara set en gång
        setName(title, firstName, surName);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerNumber = customerNumber;
        this.gender = gender;
        this.isValid = true;

        GregorianCalendar gCal = new GregorianCalendar();
        gCal.add(GregorianCalendar.YEAR, 1);
        this.expiryDate = gCal.getTime();

    }

//sätter String som private så att den ej kan ändras utan bara anv som nedan
    //detta är superviktigt då man håller reda på sina variables, den kan bara ändras inom klassen 
    public String getTitle() {
        return title;
    }

    public String getFirstName() {//method; public gör method available outside the class

        return firstName;
    }

    public String getSurName() {//method; private då är method bara available within class

        return surName;
    }

    public void setSurname(String surName) {
        this.surName = surName;
    }

    private void setName(String title, String firstName, String surName) {//method
        this.title = title; // vi sätter denna som private för att namnet inte ska kunna ändras
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getMailingName() {
        StringBuilder sb = new StringBuilder(title);
        sb.append(" ");
        sb.append(firstName.substring(0, 1));
        sb.append(" ");
        sb.append(surName);

        String mailingName;
        return sb.toString();
    }

    public GenderType getGender() {
        return gender;

    }

    public String getAddress() {

        String getAddress;
        getAddress = address + ", " + phoneNumber + ", " + email;
        return getAddress;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
    
    
    public String getCustomerNumber (){
        return customerNumber;
    }

    @Override
    public String toString() {
        return getMailingName();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {//kolla om man har satt in samma object typ dvd1 och dv1
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.customerNumber != other.customerNumber) {
            return false;
        }
        if (this.isValid != other.isValid) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.surName, other.surName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.expiryDate, other.expiryDate)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        return true;
    }

}
