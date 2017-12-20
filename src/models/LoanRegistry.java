package models;

import java.util.ArrayList;
import utilities.Status;

public class LoanRegistry {

    private ArrayList<Loan> registry;

    public LoanRegistry() {//constructor
        registry = new ArrayList<Loan>();// initialize the array
    }

    public void addLoan(Loan loan) throws LoanAlreadyExistsException//method
    {
        if (registry.contains(loan)) {
            throw new LoanAlreadyExistsException();//om vi är här så finns lånet och då throw och inget annat händer
        }
        registry.add(loan);
    }

    public Loan findLoan(String loanId) throws LoanNotFoundException {//method med exception
        {
            for (Loan loan : registry) {

                if (loan.getBook().getID().equals(loanId) && loan.getStatus() == Status.CURRENT)//med array registry använder vi metoder
                {
                    return loan;
                }
            }
            throw new LoanNotFoundException();
        }
    }

    public boolean isBookOnLoan(String loanId) {
        try {
            Loan findLoan = findLoan(loanId);//use method to see if loan excist for that type of book
            return true;
        } catch (LoanNotFoundException e) {
            return false;
        }
    }
}
