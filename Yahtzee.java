package com.company;

import java.util.Scanner;

public class Yahtzee {

    Speler speler1 = new Speler("speler1");
    Scanner input = new Scanner( System.in );
    boolean doorspelen = true;


    public void beginSpel() {

        System.out.println("Yahtzee!");
        System.out.println("==============================");
        System.out.println("1e keer dobbelen deze beurt");
        System.out.println("==============================");
        System.out.println("1: Start eerste gooi | 2: Stop spel");

        boolean keuzeGemaakt = false;

        while(!keuzeGemaakt) { //start menu
            int keuze = input.nextInt();
            if (keuze == 1) {
                speler1.dobbelenEersteKeer();
                System.out.println();
                keuzeGemaakt = true;
            } else if (keuze == 2) {
                doorspelen = false;
                keuzeGemaakt = true;
            } else {
                System.out.println("Ongeldige waarde! 1: Start eerste gooi | 2: Stop spel");
                continue; //gaat terug naar begin van loop
            }
        }
        int dobbelKeer = 1;
        while (doorspelen) {    //logic voor vastleggen van dobbelstenen in array vastGelegdeResultaten
            if(dobbelKeer < 4){
                speler1.resetVastgelegdeResultaten(); //reset de vastgelegdewaarden array voordat er nieuwe dobbelstenen vastgezet worden
                for (int x = 0; x < 5; x++) {
                    boolean vastleggenKeuzeGemaakt = false;
                    System.out.println("Dobbelsteen " + (x + 1) + " met waarde: " + speler1.resultatenDobbelen[x] + " vastleggen? 1: ja | 2: nee");
                    while (!vastleggenKeuzeGemaakt) {
                        int keuze = input.nextInt();
                        if (keuze == 1) {
                            speler1.vastgelegdeResultaten[x] = speler1.resultatenDobbelen[x];
                            speler1.printResultatenDobbelen();
                            System.out.println("Dobbelsteen " + (x + 1) + " met waarde: " + speler1.resultatenDobbelen[x] + " vastgelegd");
                            speler1.printVastgelegdeResultaten();
                            vastleggenKeuzeGemaakt = true;
                        } else if (keuze == 2) {
                            speler1.printResultatenDobbelen();
                            System.out.println("Dobbelsteen " + (x + 1) + " met waarde: " + speler1.resultatenDobbelen[x] + " NIET vastgelegd");
                            speler1.printVastgelegdeResultaten();
                            vastleggenKeuzeGemaakt = true;
                        } else {
                            System.out.println("Ongeldige waarde! 1: vastleggen | 2: nee");
                            continue;
                        }
                    }
                }
                dobbelKeer++; //volgende keer gooien deze beurt - max 3 per beurt
            }
            System.out.println("==============================");
            System.out.println(dobbelKeer + "e keer dobbelen deze beurt");
            System.out.println("==============================");
            speler1.printVastgelegdeResultaten();

            System.out.println("1: Verder dobbelen met niet-vastgelegde dobbelstenen | 2: spel stoppen");
            boolean volgendeWorp = false;
            while(!volgendeWorp){
                int keuze = input.nextInt();
                if (keuze == 1) {
                    speler1.dobbelenNaEersteKeer();
                    volgendeWorp = true;
                } else if(keuze == 2){
                    doorspelen = false;
                    volgendeWorp = true;
                } else {
                    System.out.println("Ongeldige waarde! 1: verder dobbelen | 2: spel stoppen");
                    continue;
                }
            }
        }

        System.out.println("Programma stopt");
    }


//    public void printResultatenDobbelen(){
//        System.out.println("Resultaten dobbelen:  ");
//        for (int x = 0; x < 5; x++){
//            System.out.print(speler1.resultatenDobbelen[x] + "  ");
//        }
//        System.out.println("");
//    }
//
//    public void printVastgelegdeResultaten(){
//        System.out.println("Vastgelegd zijn: ");
//        for (int x = 0; x < 5; x++){
//            if(speler1.vastgelegdeResultaten[x] > 0){
//                System.out.print(speler1.vastgelegdeResultaten[x] + "  ");
//            }
//        }
//        System.out.println("");
//    }
//
//    public void resetVastgelegdeResultaten(){
//        for (int x = 0; x < 5; x++){
//            speler1.vastgelegdeResultaten[x] = 0;
//        }
//    }
}
