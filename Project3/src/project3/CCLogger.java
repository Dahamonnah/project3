
package project3;

public class CCLogger {
    
    private CCNode[] Hashtable;
    private int size;

    public CCLogger() {
        Hashtable = new CCNode[10];
        setSize(0);
    }

    public CCNode[] getHashtable() {
        return Hashtable;
    }

    public void setHashtable(CCNode[] Hashtable) {
        this.Hashtable = Hashtable;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public int getHash(long Key){
        String k = Key + "";
        return (Integer.parseInt(k.charAt(3) + "") + Integer.parseInt(k.charAt(7) + "")
                + Integer.parseInt(k.charAt(11) + "") + Integer.parseInt(k.charAt(15) + "")) % 10;
    }
    
    public void Add(CCNode node){
        int hash = getHash(node.getCCNumber());
        
        if(search(node.getCCNumber()) != null){
            System.out.println("Cannot add duplicates");
        }
        else{
            if(Hashtable[hash] == null){
                Hashtable[hash] = node;
            }
            else{
                node.setNext(Hashtable[hash]);
                Hashtable[hash] = node;
            }

            size++;
            log(node);
        }
    }
    
    public void Credit(long Key, double Amt){
        CCNode temp = search(Key);
        
        if(temp.getBalance() < Amt){
            System.out.println("Unable to complete operation");
        }
        else{
            temp.setBalance(temp.getBalance() - Amt);
        }
        
        log(temp);
    }
    
    public void Debit(long Key, double Amt){
        CCNode temp = search(Key);
        
        //temp.setBalance(temp.getBalance() + Amt);
        //if(temp.getBalance() > temp.getCLimit()){
        //    System.out.println("Warning. Credit limit exceeded");
        //}
        
        if(temp.getBalance() + Amt > temp.getCLimit()){
            System.out.println("Credit limit exceeded");
        }
        else{
            temp.setBalance(temp.getBalance() + Amt);
        }
        
        
        log(temp);
    }
    
    private void log(CCNode node){
        /*String log = String.format("%s %s %f %f\n", 
                (System.currentTimeMillis() / 1000) + "", node.getCCNumber() + "", 
                node.getCLimit(), node.getBalance());*/
        String log = (System.currentTimeMillis() / 1000) + " " + 
                node.getCCNumber() + " " + node.getCLimit() + " " + 
                node.getBalance() + "\n";
        node.setLog(node.getLog() + log);
    }
    
    public String getLog(long Key){
        return search(Key).getLog();
    }
    
    private CCNode search(long Key){
        int hash = getHash(Key);
        CCNode temp = Hashtable[hash];
        
        while(temp != null){
            if(Key == temp.getCCNumber()){
                break;
            }
            temp = temp.getNext();
        }
        
        return temp;
    }
    
}
