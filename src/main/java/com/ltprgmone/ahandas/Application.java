package com.ltprgmone.ahandas;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// welcome

public class Application {

    public static void main(String[] args) throws FileNotFoundException{
        File openFile = new File("src/main/java/com/ltprgmone/ahandas/opening.txt");
        Scanner opening=new Scanner(openFile);
        while (opening.hasNextLine())
        {
            System.out.println(opening.nextLine());
        }
        opening.close();

        Building firstBuilding=new Building("Abandoned warehouse", 0, "1409 W Dockside", 0, 150000, 9, 1);
        Contract firstContract = new Contract(firstBuilding, 15000, "Industry Inc.");

        firstContract.offer();


    }
}
