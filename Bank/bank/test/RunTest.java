package bank.test;

import bank.transfer.TransferManager;
import bank.util.DateBook;
import bank.util.FileGet;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class RunTest {

    public static void main(String[] args){
        new RunTest();
    }

    public RunTest(){

        Scanner scan = new Scanner(System.in);

        System.out.println("1. Create Account");
        System.out.println("2. Withdrawal / Deposit");
        System.out.println("3. Make a Wire Transfer");
        System.out.println("4. Add Calendar payment");
        System.out.println("5. Remove Calendar payment");
        System.out.println("6. List Accounts");
        System.out.println("7. Terminate account");
        System.out.println("8. Show vault");

        int choice = scan.nextInt();
        scan.nextLine();

        if(choice >= 1 && choice <= 2){
            AccountTest a = new AccountTest(Integer.toString(choice), scan);
        }
        if(choice >= 3 && choice <= 5){
            TransferTest t = new TransferTest(Integer.toString(choice), scan);
        }
        if(choice >= 6 && choice <= 8){
            VaultsTest v = new VaultsTest(Integer.toString(choice), scan);
        }
        commitDates();
    }

    public void commitDates() {
        DateBook db = new DateBook();
        TransferManager tm = new TransferManager(new GregorianCalendar());
        FileGet datedDelete = new FileGet();
        List<String> finalizeDates = db.checkDates();;

        System.out.println("\nDates\n");
        for(int i  = 0; i < finalizeDates.size(); i++) {
            System.out.println(finalizeDates.get(i));
            String[] words= finalizeDates.get(i).split(" ");
            //	System.out.println(hold[0] + " " + hold[1] + " " + Double.parseDouble(hold[2]));
            tm.accountTransfer(words[1], words[0], Double.parseDouble(words[2]));
            try{
                System.out.println(words[words.length-1] + " HJÄLP!");
                datedDelete.deleteLine("Bankdata/DatedTransfers", words[words.length-1]);
            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
    }

}
