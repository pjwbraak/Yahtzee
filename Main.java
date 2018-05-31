package com.company;

import java.util.Random;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        System.out.println("Yahtzee!");

        Dobbelsteen dobbelsteen = new Dobbelsteen();
        int[] resultatenDobbelen = new int[5];
        int[] vastgelegdeResultaten = new int[5];
        boolean doorspelen = true;

        while (doorspelen == true) {
            String input = toonDobbelMenu();
            switch (input) {

                case "d":
                    //dobbelen
                    for (int x = 0; x < 5; x++) {
                        resultatenDobbelen[x] = dobbelsteen.dobbelen();
                        if(vastgelegdeResultaten[x] != 0){
                            resultatenDobbelen[x] = vastgelegdeResultaten[x];
                        }
                        System.out.print(resultatenDobbelen[x] + "  ");
                    }
                    System.out.println("");

                    //vastleggen?
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("^");
                    System.out.println("Dobbelsteen 1 vastleggen (j)?");
                    switch(scanner.next()) {
                        case "j":
                            vastgelegdeResultaten[0] = resultatenDobbelen[0];
                            System.out.println("Dobbelsteen 1 met cijfer: " + vastgelegdeResultaten[0] + " vastgelegd");
                            break;
                        default:
                            System.out.println("Dobbelsteen 1 niet vastgelegd");
                    }
                    //hier de huidige nummers laten zien
                    System.out.println("   ^");
                    System.out.println("Dobbelsteen 2 vastleggen (j)?");
                    switch(scanner.next()) {
                        case "j":
                            vastgelegdeResultaten[1] = resultatenDobbelen[1];
                            System.out.println("Dobbelsteen 2 met cijfer: " + vastgelegdeResultaten[1] + " vastgelegd");
                            break;
                        default:
                            System.out.println("Dobbelsteen 2 niet vastgelegd");
                    }

                    //hier de huidige nummers laten zien
                    System.out.println("     ^");
                    System.out.println("Dobbelsteen 3 vastleggen (j)?");
                    switch(scanner.next()) {
                        case "j":
                            vastgelegdeResultaten[2] = resultatenDobbelen[2];
                            System.out.println("Dobbelsteen 3 met cijfer: " + vastgelegdeResultaten[2] + " vastgelegd");
                            break;
                        default:
                            System.out.println("Dobbelsteen 3 niet vastgelegd");
                    }

                    //hier de huidige nummers laten zien
                    System.out.println("       ^");
                    System.out.println("Dobbelsteen 4 vastleggen (j)?");
                    switch(scanner.next()) {
                        case "j":
                            vastgelegdeResultaten[3] = resultatenDobbelen[3];
                            System.out.println("Dobbelsteen 4 met cijfer: " + vastgelegdeResultaten[3] + " vastgelegd");
                            break;
                        default:
                            System.out.println("Dobbelsteen 4 niet vastgelegd");
                    }

                    //hier de huidige nummers laten zien
                    System.out.println("         ^");
                    System.out.println("Dobbelsteen 5 vastleggen (j)?");
                    switch(scanner.next()) {
                        case "j":
                            vastgelegdeResultaten[4] = resultatenDobbelen[4];
                            System.out.println("Dobbelsteen 5 met cijfer: " + vastgelegdeResultaten[4] + " vastgelegd");
                            break;
                        default:
                            System.out.println("Dobbelsteen 5 niet vastgelegd");
                    }

                    System.out.println(" ");
                    System.out.println("Vastgelegde dobbelstenen:");
                    for(int x = 0; x < 5; x++){
                        if(vastgelegdeResultaten[x] != 0){
                            System.out.print(vastgelegdeResultaten[x] + "  ");
                        }
                    }

                    break;

                case "s":
                    doorspelen = false;
            }

        }

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