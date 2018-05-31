package com.company;

import java.util.Random;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        System.out.println("Yahtzee!");

        Dobbelsteen dobbelsteen = new Dobbelsteen();
        int[] resultatenDobbelen = new int[5];
        int[] vastgelegdeResultaten = new int[5];
//        vastgelegdeResultaten[0] = 7;
        boolean doorspelen = true;

        while (doorspelen == true) {
            String input = toonDobbelMenu();
            switch (input) {

                case "d":
                    //dobbelen
                    for (int x = 0; x < 5; x++) {
                        resultatenDobbelen[x] = dobbelsteen.dobbelen();
                        if(vastgelegdeResultaten[x] != 0){ //resultaat van dobbelen kan nooit 0 zijn, dus 0 in vastgelegdeResultaten betekent niet vastgelegd door speler
                            resultatenDobbelen[x] = vastgelegdeResultaten[x];
                        }
                        System.out.print(resultatenDobbelen[x] + "  ");
                    }
                    System.out.println("");

                    //vastleggen?
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("^");
                    System.out.println("Dobbelsteen 1 vastleggen (j/n)?");
                    switch(scanner.next()) {
                        case "j":
                            vastgelegdeResultaten[0] = resultatenDobbelen[0];
                    }

                    System.out.println(resultatenDobbelen[0]);  //test of [0] op beide arrays gelijk zijn
                    System.out.println(vastgelegdeResultaten[0]); //test
                    break;

                case "s":
                    doorspelen = false;
            }

        } //while loop eindigt hier

        System.out.println("Bedankt voor het spelen!");
    }

    static String toonDobbelMenu() {
        System.out.println("Voer uw input in: d = dobbelen of s = stoppen");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}

class Dobbelsteen {

    int dobbelen() {
        Random random = new Random();
        int resultaat = random.nextInt(6);
        return (resultaat + 1);
    }
}