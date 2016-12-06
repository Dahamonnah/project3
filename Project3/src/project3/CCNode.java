
package project3;

public class CCNode {
    
    private long CCNumber;
    private double CLimit;
    private double Balance;
    private CCNode Next;
    private String Log;

    public CCNode(long CCNumber, double CLimit, double Balance) {
        setCCNumber(CCNumber);
        setCLimit(CLimit);
        setBalance(Balance);
        setNext(null);
        setLog("");
    }

    public long getCCNumber() {
        return CCNumber;
    }

    public void setCCNumber(long CCNumber)  {
        String s = CCNumber + "";
        if(s.length() == 16){
            
            for (char c : s.toCharArray()) {
                if(!Character.isDigit(c)){
                    System.out.println("Only numbers allowed");
                    return;
                }
            }
            
            this.CCNumber = CCNumber;
        }
        else{
            System.out.println("Invalid credit card length");
        }
    }

    public double getCLimit() {
        return CLimit;
    }

    public void setCLimit(double CLimit) {
        this.CLimit = CLimit;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public CCNode getNext() {
        return Next;
    }

    public void setNext(CCNode next) {
        this.Next = next;
    }

    public String getLog() {
        return Log;
    }

    public void setLog(String Log) {
        this.Log = Log;
    }
    
    
}
