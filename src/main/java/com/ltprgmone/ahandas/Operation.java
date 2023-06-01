package com.ltprgmone.ahandas;

import java.util.Scanner;
import java.util.Random;

public class Operation {
    private Contract contract;
    private Building building;
    private int progress;
    private int progressClockSize;
    private int oppositionClockSize;
    private int opposition;

    public Operation(Contract inProgressC, Building inProgressB) {
        contract = inProgressC;
        building = inProgressB;
        progress = 0;
        opposition = 0;
        progressClockSize = 0;
        oppositionClockSize = 0;
    }

    public void theOperation() {
        int phase = 0;
        int effectO = 0;
        int effectP = 0;
        int status = 0;
        Scanner keyboard = new Scanner(System.in);
        Random randomizer = new Random(11037);
        // setting clock sizes
        int opDifficulty = building.difficultyFinder();
        if (opDifficulty < 0) {
            progressClockSize = 10;
            oppositionClockSize = 4;
        } else if (opDifficulty <= 5) {
            progressClockSize = 8;
            oppositionClockSize = 6;
        } else if (opDifficulty > 5 && opDifficulty < 7) {
            progressClockSize = 6;
            oppositionClockSize = 8;
        } else if (opDifficulty >= 7) {
            progressClockSize = 4;
            oppositionClockSize = 10;
        }

        System.out.println("//: begin operation");
        while (status == 0 || status == 3) {
            while (phase == 0) {
                System.out.println(
                        "//: beginning setup. choose a firing plan: \n -Cautious (1) (less progress gain, less chance of being caught) \n -Standard (2) (average progress  gain, average chance of being caught) \n -RISKY (3) (high progress gain, high chance of being caught)");
                int phase0Plan = keyboard.nextInt();
                if (phase0Plan == 1) {
                    effectP = randomizer.nextInt(2);
                    effectO = randomizer.nextInt(2);
                } else if (phase0Plan == 2) {
                    effectP = randomizer.nextInt(2) + 1;
                    effectO = randomizer.nextInt(2) + 1;
                } else {
                    effectP = randomizer.nextInt(3) + 1;
                    effectO = randomizer.nextInt(3) + 1;
                }

                System.out.println("//: fireDrone initializing... ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("//: fireDrone initialized. Firing payload...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (effectP > 0) {
                    System.out.println("//: firing complete. Begin second operation stage.");
                } else {
                    System.out.println("//: ERROR: FIRING MALFUNCTION. resetting...");
                    effectP--;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("//: firing complete. Begin second operation stage.");
                }
                progress = progress + effectP;
                opposition = opposition + effectO;

                phase++;

            }
            status = postPhase(progress, opposition, progressClockSize, oppositionClockSize);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            while (phase == 1) {

                effectO = 0;
                effectP = 0;

                System.out.println("//: ignition code " + effectP
                        + ". trace protocol intercepted, select evasive manuever: \n -eva.doABarrelRoll (1) (less progress gain, highest evasion) \n -eva.deflectorShields (2) (medium progress, medium evasion) \n -eva.allYourBase (3) (high progress, low evasion)");
                int evadeChoice = keyboard.nextInt();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (evadeChoice == 1) {
                    effectP = randomizer.nextInt(2);
                    effectO = randomizer.nextInt(3) + 1;
                }
                if (evadeChoice == 2) {
                    effectP = randomizer.nextInt(2) + 1;
                    effectO = randomizer.nextInt(2) + 1;
                }
                if (evadeChoice == 3) {
                    effectP = randomizer.nextInt(3) + 1;
                    effectO = randomizer.nextInt(2);
                }
                System.out.println("//: activating countermeasures.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (effectO == 0) {
                    System.out.println("//: ERROR: Evasive actions failed. reattempting.");
                    effectO--;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("//: evasion complete. beginning tertiary stage.");
                progress = progress + effectP;
                opposition = opposition - effectO;
                postPhase(progress, opposition, progressClockSize, oppositionClockSize);
                phase++;

            }
            while (phase==2)
            {
                //the EVALUATION
                int minPay=contract.returnPayment();
                double pay= minPay;
                int rating=(progress-(opposition-2));
                if (rating>0)
                {
                    System.out.println("//: Outstanding job. Bonus pay of "+(.1*minPay));
                    pay=minPay+(.1*minPay);
                }
                else
                {
                    System.out.println("//: no bonus. waiting for next contract...");
                }
                System.out.println("//: gained "+pay+" USD.");
                status=5;
                phase=6;
            }

        }

        if (status!=5)
        {
            System.out.flush();
            System.out.println("//: firewall overwhelmed. police are on their way. deleting... (lose state. try again!)");
        }
        else
        {
            System.out.println("congrats on beating the first contract! will be adding to this over the summer, now that I have the barebones done for class.");
        }
        keyboard.close();


    }

    public int postPhase(int newP, int newO, int lengthP, int lengthO) {
        int returnVal = 4;
        if (newP < lengthP) {
            if (newO < lengthO) {
                returnVal = 0;
            } else {
                returnVal = 1;
            }
        } else if (newP >= lengthP) {
            if (newO >= lengthO) {
                returnVal = 2;
            } else {
                returnVal = 3;
            }
        }
        return returnVal;

    }
}