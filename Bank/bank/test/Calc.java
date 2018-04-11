package bank.test;

import java.util.Scanner;

public class Calc {

    public Calc(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Välj operation (+ - / *)");
        String operation = scan.nextLine();

        System.out.println("Skriv in ett heltal");
        int a = scan.nextInt();
        scan.nextLine();


        System.out.println("Skriv in ett till heltal");
        int b = scan.nextInt();
        scan.nextLine();

        if(operation.equals("+")){
            System.out.println("Result: " + add(a,b));
        }

        else if(operation.equals("-")){
            System.out.println("Result: " + subtract(a,b));
        }
        else if(operation.equals("/")){
            System.out.println("Result: " + divide(a,b));
        }
        else if(operation.equals("*")){
            System.out.println("Result: " + multiply(a,b));
        }
    }

    public int add(int a, int b){
        return a + b;
    }
    public int subtract(int a, int b){
        return a - b;
    }
    public int divide(int a, int b){
        if(b!=0){
            return a / b;
        }
        else{
            return 0;
        }
    }
    public int multiply(int a, int b){
        return a * b;
    }

    public static void main(String[] args){

        new Calc();

    }

}
