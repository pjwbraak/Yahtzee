package com.company;

import java.util.Scanner;

public class Yahtzee {

    Speler speler1 = new Speler("speler1");
    Scanner input = new Scanner(System.in);
    boolean doorspelen = true;


    public void beginSpel() {

        speler1.beurt++;
        System.out.println("Yahtzee!");
        System.out.println("==============================");
        System.out.println("1e keer dobbelen voor beurt " + speler1.beurt);
        System.out.println("==============================");
        System.out.println("1: Start eerste gooi | 2: Stop spel");


        //begin menu
        beginMenu();

        //spelen
        spelSpelen();

    }

    void beginMenu() {
        boolean keuzeGemaakt = false;
        while (!keuzeGemaakt) {
            int keuze = input.nextInt();
            //dobbelen
            if (keuze == 1) {
                speler1.dobbelenEersteKeer();
                System.out.println();
                speler1.dobbelKeer++;
                keuzeGemaakt = true;
                //stoppen
            } else if (keuze == 2) {
                doorspelen = false;
                keuzeGemaakt = true;
            } else {
                System.out.println("Ongeldige waarde! 1: Start eerste gooi | 2: Stop spel");
                continue;
            }
        }
    }

    void spelSpelen() {

        while (doorspelen) {
            //speler kiest welke dobbelstenen vastgelegd worden
            vastLeggenDobbelstenen();

            //vragen door te gaan naar volgende keer dobbelen in beurt
            vraagDoorDobbelen();

            //start nieuwe beurt na 3 keer dobbelen
            startNieuweBeurt();

            //score opslaan
        }
        System.out.println("Programma stopt");
    }

    void vastLeggenDobbelstenen() {
        speler1.resetVastgelegdeResultaten(); //reset vastgelegde dobbelstenen als die er zijn
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
        //volgende keer gooien deze beurt - max 3 per beurt
        speler1.dobbelKeer++;

        System.out.println("==============================");
        System.out.println(speler1.dobbelKeer + "e keer dobbelen voor beurt " + speler1.beurt);
        System.out.println("==============================");
        speler1.printVastgelegdeResultaten();
    }

    void vraagDoorDobbelen(){
        if (speler1.dobbelKeer < 3) {
            System.out.println("1: Verder dobbelen met niet-vastgelegde dobbelstenen | 2: spel stoppen");
            boolean volgendeWorp = false;
            while (!volgendeWorp) {
                int keuze = input.nextInt();
                if (keuze == 1) {
                    speler1.dobbelenNaEersteKeer();
                    volgendeWorp = true;
                } else if (keuze == 2) {
                    doorspelen = false;
                    volgendeWorp = true;
                } else {
                    System.out.println("Ongeldige waarde! 1: verder dobbelen | 2: spel stoppen");
                    continue;
                }
            }
        }
    }

    void startNieuweBeurt(){
        if (speler1.dobbelKeer == 3) {
            System.out.println("Waarden dobbelstenen beurt " + speler1.beurt + ":");

            int[] resultaat = speler1.dobbelenNaEersteKeer();

            System.out.println("Einde beurt " + speler1.beurt + "! 1: nieuwe beurt starten | 2: spel stoppen");
            speler1.dobbelKeer = 1;
            boolean nieuweBeurt = false;
            while (!nieuweBeurt) {
                int keuze = input.nextInt();
                if (keuze == 1) {
                    speler1.beurt++;
                    System.out.println("==============================");
                    System.out.println("1e keer dobbelen voor beurt " + speler1.beurt);
                    System.out.println("==============================");
                    speler1.dobbelenEersteKeer();
                    System.out.println();
                    speler1.dobbelKeer = 1;
                    nieuweBeurt = true;
                } else if (keuze == 2) {
                    doorspelen = false;
                    nieuweBeurt = true;
                } else {
                    System.out.println("Ongeldige waarde! 1: nieuwe beurt | 2: spel stoppen");
                    continue;
                }
            }
        }
    }
}