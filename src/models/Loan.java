package models;

import java.util.Date;
import java.util.GregorianCalendar;
import utilities.Status;

public class Loan {

    private String loanId;
    private Customer customer;
    private Book book;
    private Date startDate;//import class java.util.Date
    private Date dueDate;
    private Date returnDate;
    private Status status;//imported 
   
    public Loan(String loanId, Customer customer, Book book) {//constructor
        this.customer = customer;
        this.book = book;
        this.startDate = new Date(); //today
        //this.dueDate = dueDate; set this
        //this.returnDate = returnDate; will be today
        //this.status = status;current
        this.loanId = loanId;
        

        GregorianCalendar gCal = new GregorianCalendar(); //import
        gCal.add(GregorianCalendar.DAY_OF_MONTH, 14);//add 14 days
        this.dueDate= gCal.getTime();
        status = Status.CURRENT;

    }

    public Customer getCustomer() {//no set method as my constructor will do that for me
        return customer;
    }

    public Book getBook() {//no set method as my constructor will do that for me
        return book;
    }

    public Date getDueDate() {//no set method as my constructor will do that for me
        return dueDate;
    }

//    public int getLoanId() {
//        return loanId;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(Date returnDate) {
//        this.returnDate = returnDate;
//    }
//
    public Status getStatus() {

        return status;
    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
    public void endLoan() {//when I call this method following happens
        returnDate = new Date();// sets it to today
        status = status.HISTORIC;//sets status to historic

    }

    

    @Override
    public boolean equals(Object obj) {//automatically generated
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loan other = (Loan) obj;
        if (this.loanId != other.loanId) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Loan [ID= " + loanId + ", customer= " + customer.getMailingName() + ", book= " + book.getTitle() + "]";

    }

}
