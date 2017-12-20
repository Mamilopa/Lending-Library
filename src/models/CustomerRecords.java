package models;

import java.util.HashSet;

public class CustomerRecords {

    public HashSet<Customer> records;

    public CustomerRecords() {

        records= new HashSet<Customer>();

    }

    public void addCustomer(Customer customer) {
        records.add(customer);
    }

    public Customer findByName(String name) throws CustomerNotFoundException {

        for (Customer customer : records) {

            if (customer.getMailingName().equalsIgnoreCase(name)) {
                return customer;
            }

        }
        throw new CustomerNotFoundException ();

    }
    public int getNumberOfCustomers (){
        return records.size();
    }
}

