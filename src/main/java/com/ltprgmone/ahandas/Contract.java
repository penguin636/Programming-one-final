package com.ltprgmone.ahandas;
import java.util.Scanner;
public class Contract {
    private Building building;
    private int payment;
    private String issuer;
    private boolean accepted;

    public Contract(Building buildingOne, int paymentInt, String issuerString)
    {
        building=buildingOne;
        payment=paymentInt;
        issuer=issuerString;
        accepted=false;
    }

    
    public String toString()
    {
        return "building: " + building + " payment: " + payment+ " issuer: " + issuer;
    }

    public void offer()
    {
        System.out.println("|  (1) NEW CONTRACT  |");
        System.out.println("//: read new");
        System.out.println("CONTRACT: \n You, the party known as *****, will, in exchange for the sum of " + payment + " USD, burn down the "+ building.contractInfoString()+" Do you choose to accept? y/n");
        
        Scanner keyboard=new Scanner(System.in);
        char acceptance=keyboard.next().charAt(0);
        if (acceptance=='y')
        {
            System.out.println("Contract accepted.");
            accepted=true;

        }
        else;
        {
            System.out.println("Contract denied");
        }
        
    }

    public int returnPayment()
    {
        return payment;
    }
    public boolean returnAccept()
    {
        return accepted;
    }
}



