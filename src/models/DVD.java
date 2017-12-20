
package models;

public class DVD extends Material {
    
    private String director;
    private String catalogNo;
    private int runningTime;
private boolean licenced;
    
    public DVD(String director,  int runningTime, String id, String title, String branch, String catalogNo) {
        super(id, title, branch);
        this.director = director;
        this.catalogNo = catalogNo;
        this.runningTime = runningTime;
        licenced = false;
    }
     public void licence (){
        
        licenced = true;
         
        
    }
    
    @Override
    public boolean lend(Customer customer) {
    if (licenced) {
        return super.lend(customer);
    }
    else{
        return false;
    }
    
    }
     public int getLoanPeriod (){
        return 7;
    }
     
    @Override
     public String toString(){
         return "DVD:  "+ getID() + " "+ getTitle() + " / " + director; // eftersom vi är i klassen kan vi kalla director direkt
     }
     
}
