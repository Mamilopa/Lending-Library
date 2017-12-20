package ui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import ui.UI;
import java.util.Scanner;
import java.util.TreeMap;
import models.Book;
import models.Customer;
import models.CustomerRecords;
import models.DVD;
import models.Loan;
import models.LoanAlreadyExistsException;
import models.LoanRegistry;
import models.Material;
import models.MaterialCatalogInterface;
import models.MaterialCatalogMemoryVersion;
import models.MaterialNotFoundException;
import utilities.GenderType;

public class Main {
//MaterialCatalogInterface mci = new MaterialCatalogMemoryVersion();// we can assign the variable to any object that implements the interface
//however we can't instatiate the variable of the interface directly (MaterialCatalogInterface mci= new MaterialCatalogInterface) går inte  

    MaterialCatalogInterface materialCatalog = new MaterialCatalogMemoryVersion();// för att kunna ändra lätt
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double d = 1;
        // Locale swiss= new Locale ("fr","ch");
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMinimumFractionDigits(5);
        nf.setMaximumFractionDigits(5);

        BigDecimal price = new BigDecimal("0.1");
        BigDecimal addValue = new BigDecimal("0.1");// som String annars rounding error

        for (int i = 0; i < 10; i++) {
            price = price.add(addValue);
            System.out.println(price);
        }

        MaterialCatalogMemoryVersion materialCatalog = new MaterialCatalogMemoryVersion();

        Book book1 = new Book("1001", "An Introduction to Java", " Matt Greencroft", "12345", "Anytown Branch", 400);
        Book book2 = new Book("233x", "Better Java", " Joe Le Blanc", "23456", "Anytown Branch", 150);
        Book book3 = new Book("9120", "Learning French", " Anton LeNoir", "23566", "Anytown Branch", 100);
        Book book4 = new Book("576x", "Learning More French", " Anton LeNoir", "23566", "Anytown Branch", 100);
        Book book5 = new Book("976g", "Enough French Already", " Anton LeNoir", "23566", "Anytown Branch", 100);
        DVD dvd1 = new DVD("Stephen Spielberg", 120, "3", "An Epic Film About Java", "Anytown Branch", "99887");
        DVD dvd2 = new DVD("Stephen Spielberg", 120, "4", "An Epic Film About Java", "Anytown Branch", "99887");

//        System.out.println(dvd1.getTitle());
//
//        book1.relocate("MyCity branch");
        materialCatalog.addMaterial(book1);
        materialCatalog.addMaterial(book2);
        materialCatalog.addMaterial(book3);
        materialCatalog.addMaterial(book4);
        materialCatalog.addMaterial(book5);
        materialCatalog.addMaterial(dvd1);
        materialCatalog.addMaterial(dvd2);

        UI ui = new UI();
        ui.printHeader();
        ui.printMaterialCatalog(materialCatalog.getMaterialMap());

        TreeMap<String, Material> myMap = materialCatalog.getMaterialMap();
        for (Material nextItem : myMap.values()) {
            System.out.println(nextItem.getTitle());
        }
        try {
            Material foundMaterial = materialCatalog.findMaterial("Better Java");
            System.out.println("Item found: " + foundMaterial.getID());

        } catch (MaterialNotFoundException e) {
            System.out.println("No matching items found");
        }

//        try {
//
//            Book foundBook = bookCatalog.findBook("Better");
//            System.out.println("We found " + foundBook.getTitle());
//
//        } catch (BookNotFoundException e) {
//
//            System.out.println("The book wasn't found");
//
//        }
////        int myTest = 1;
////        if (myTest != 2) {
////            throw new RuntimeException("Something went wrong");
////        }
//
        CustomerRecords records = new CustomerRecords();//instance of CustomerRecords

        Customer customer = new Customer("Mr", "Michael", "Smith", "1 The High Street", "12344", "a@b.com", "1", GenderType.MALE);
        Customer customer1 = new Customer("Ms", "Michele", "Smithe", "2 The High Street", "34344", "y@b.se", "2", GenderType.FEMALE);
        Customer customer2 = new Customer("Ms", "Katarina", "Thre", "2 The Low Street", "89344", "tre@htt.se", "3", GenderType.FEMALE);
        Customer customer3 = new Customer("Mr", "Lance", "Bla", "2 The Pla Street", "89344", "pidm@ilfkdj.com", "4", GenderType.UNKNOWN);
        Customer customer4 = new Customer("Mr", "Lance", "Bla", "2 The Pla Street", "89344", "pidm@ilfkdj.com", "5", GenderType.UNKNOWN);
        Customer customer5 = new Customer("Mr", "Lance", "Bla", "2 The Pla Street", "89344", "pidm@ilfkdj.com", "6", GenderType.UNKNOWN);

        int intitialSize = records.getNumberOfCustomers();

        records.addCustomer(customer);
        records.addCustomer(customer1);
        records.addCustomer(customer2);
        records.addCustomer(customer3);
        records.addCustomer(customer4);
        records.addCustomer(customer5);

        System.out.println("NUMBER " + records.getNumberOfCustomers());

        System.out.println(customer.getExpiryDate());
        System.out.println(customer.getMailingName());

        System.out.println(customer);
        //System.out.println(dvd1);
        System.out.println(book1);

        //System.out.println(dvd1.equals(dvd2));
        System.out.println(customer.equals(customer1));

        Loan firstLoan = new Loan("1", customer, book1);
        System.out.println(firstLoan.getDueDate());
        System.out.println(firstLoan);

        LoanRegistry registry = new LoanRegistry();
        try {
            registry.addLoan(firstLoan);
            System.out.println("addLoan works");
        } catch (LoanAlreadyExistsException e) {
            System.out.println("addLoan fails");
        }

        try {//för att testa att den gjorde det den skulle
            registry.addLoan(firstLoan);
            System.out.println("addLoan works");
        } catch (LoanAlreadyExistsException e) {
            System.out.println("addLoan fails");
        }
        System.out.println(registry.isBookOnLoan(book1.getID()));
        firstLoan.endLoan();
        System.out.println(registry.isBookOnLoan(book1.getID()));
    }

}

//       Date today = new Date ();
//        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MMM-dd");
//        SimpleDateFormat sdf1 = new SimpleDateFormat ("MMM");
//        SimpleDateFormat sdf2 = new SimpleDateFormat ("MMMM");
//        SimpleDateFormat sdf3 = new SimpleDateFormat ("MMM dd / yyyy");
//        SimpleDateFormat sdf4 = new SimpleDateFormat ("D");
//        
//         GregorianCalendar gCal = new GregorianCalendar(2007,0,1);
//      gCal.add(GregorianCalendar.WEEK_OF_YEAR,13);
//         //System.out.println(gCal);
//         today = gCal.getTime();
//        System.out.println("Today is " + sdf.format(today));
//        System.out.println(dvd1.lend(customer));
//        dvd1.licence();
//        System.out.println(dvd1.lend(customer));
//        System.out.println(dvd1.lend(customer));
//        System.out.println(book1.lend(customer));
//        System.out.println(book1.lend(customer));
//        System.out.println(book1.getLoanPeriod());
//        System.out.println(dvd1.getLoanPeriod());
