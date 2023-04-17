
package es.uvigo.esei.aed1.activity8.fireExtinguisher;

public class FireExtinguisher {
private final int referenceNumber;
private final char type;
private final double price;
private final String dateStamped;  

    public FireExtinguisher(int referenceNumber, char type, double price, String dateStamped) {
        this.referenceNumber = referenceNumber;
        this.type = type;
        this.price = price;
        this.dateStamped = dateStamped;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public char getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDateStamped() {
        return dateStamped;
    }
    
@Override
    public String toString(){
        return referenceNumber +", "+type;
    }


}
