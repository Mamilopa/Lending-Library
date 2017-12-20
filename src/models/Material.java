package models;

public abstract class Material {

    private String id;
    private String title;
    private String branch;
    private Customer borrower;

    public Material(String id, String title, String branch) {//constructor
        this.id = id;
        this.title = title;
        this.branch = branch;
    }

    public String getTitle() {
        return title;
    }

    public String getID() {
        return id;
    }

    public void relocate(String newBranch) {
        this.branch = newBranch;

    }

    public boolean lend(Customer customer) {
        if (borrower == null) {
            borrower = customer;
            return true;

        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return id + " : " + title;
    }

//must be overidden
    public abstract int getLoanPeriod();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() == obj.getClass()) {
            Material otherClass = (Material) obj;//casting
            if (id == otherClass.id) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

}
