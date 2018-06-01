package com.company;

import java.util.Scanner;

public class Yahtzee {

    Dobbelsteen dobbelsteen = new Dobbelsteen();
    Scanner input = new Scanner( System.in );
    int[] resultatenDobbelen = new int[5];
    int[] vastgelegdeResultaten = new int[5];
    boolean doorspelen = true;


    public void beginSpel() {

        System.out.println("Yahtzee!");
        System.out.println("1: Start eerste gooi | 2: Stop spel");

        boolean keuzeGemaakt = false;

        while(!keuzeGemaakt) {
            int keuze = input.nextInt(); //moet in de while loop staan anders verandert waarde niet wanneer 1 of 2 niet wordt gekozen = infinite loop
            if (keuze == 1) {
                dobbelenEersteKeer();
                System.out.println("");
                keuzeGemaakt = true;
            } else if (keuze == 2) {
                doorspelen = false;
                keuzeGemaakt = true;
            } else {
                System.out.println("Ongeldige waarde! 1: Start eerste gooi | 2: Stop spel");
                continue; //gaat terug naar begin van loop
            }
        }

        while (doorspelen) {
            for (int x = 0; x < 5; x++) {
                boolean vastleggenKeuzeGemaakt = false;
                System.out.println("Dobbelsteen " + (x + 1) + " met waarde: " + resultatenDobbelen[x] + " vastleggen? 1: ja | 2: nee");
                while(!vastleggenKeuzeGemaakt){
                    int keuze = input.nextInt();
                    if(keuze == 1){
                        vastgelegdeResultaten[x] = resultatenDobbelen[x];
                        System.out.println("Dobbelsteen " + (x + 1) + " met waarde: " + resultatenDobbelen[x] + " vastgelegd");
                        System.out.println("Vastgelegd zijn: ");
                        printVastgelegdeResultaten();
                        vastleggenKeuzeGemaakt = true;
                    }
                    else if(keuze == 2){
                        System.out.println("Dobbelsteen " + (x + 1) + " met waarde: " + resultatenDobbelen[x] + " NIET vastgelegd");
                        System.out.println("Vastgelegd zijn: ");
                        printVastgelegdeResultaten();
                        vastleggenKeuzeGemaakt = true;
                    } else {
                        System.out.println("Ongeldige waarde! 1: vastleggen | 2: nee");
                        continue;
                    }
                }
            }
        }

        System.out.println("Programma stopt");
    }

    public void dobbelenEersteKeer(){ //vult array resultatenDobbelen met 5 random waardes voor de eerste keer dobbelen per beurt
        for (int x = 0; x < 5; x++) {
            resultatenDobbelen[x] = dobbelsteen.dobbelen();
                System.out.print(resultatenDobbelen[x] + "  ");
            }
    }

//    public void printResultatenDobbelen(){
//        for (int x = 0; x < 5; x++){
//            System.out.print(resultatenDobbelen[x] + "  ");
//        }
//        System.out.println("");
//    }

    public void printVastgelegdeResultaten(){
        for (int x = 0; x < 5; x++){
            if(vastgelegdeResultaten[x] > 0){
                System.out.print(vastgelegdeResultaten[x] + "  ");
            }
        }
        System.out.println("");
    }
}
