
package project3;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args){
        //CCNode node = new CCNode(4507112832632843l, 0.0, 0.0);
        CCLogger logger = new CCLogger();
        Scanner input = new Scanner(System.in);
        
        while(true){
            String[] line = input.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            
            switch(n){
                case 1:
                    //Add credit card
                    logger.Add(new CCNode(Long.parseLong(line[1]), 
                            Double.parseDouble(line[2]), 
                            Double.parseDouble(line[3])));
                    break;
                case 2:
                    //Deduct amount
                    logger.Credit(Long.parseLong(line[1]), Double.parseDouble(line[2]));
                    break;
                case 3:
                    //Add amount
                    logger.Debit(Long.parseLong(line[1]), Double.parseDouble(line[2]));
                    break;
                case 4:
                    //Show log
                    System.out.println(logger.getLog(Long.parseLong(line[1])));
                    break;
                default:
                    //Exit loop
                    return;
            }
        }
    }
}
