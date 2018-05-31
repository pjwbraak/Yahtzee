package com.company;

import java.util.Random;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
//        System.out.println("Welkom bij mijn spel");
//        boolean doorspelen = true;
//        while(doorspelen) {
//            String input = toonMenu();
//            switch(input) {
//                case "a":
//                    ietsRandom();
//                    break;
//                case "q":
//                    doorspelen = false;
//            }
//
//        }
//        System.out.println("Bedankt voor het spelen");
//    }
//    static String toonMenu() {
//        System.out.println("Voer uw input in: a voor random of q voor quit");
//        Scanner scanner = new Scanner(System.in);
//        return scanner.next();
//    }
//    static void ietsRandom() {
//        Random random = new Random();
//        int uitkomst = random.nextInt(6);
//        System.out.println(uitkomst);

        Dobbelsteen dobbelsteen = new Dobbelsteen();

        int dobbelResultaat1 = dobbelsteen.dobbelen();
        System.out.println("dobbelsteen 1: " + dobbelResultaat1);

        int dobbelResultaat2 = dobbelsteen.dobbelen();
        System.out.println("dobbelsteen 2: " + dobbelResultaat2);

        int dobbelResultaat3 = dobbelsteen.dobbelen();
        System.out.println("dobbelsteen 3: " + dobbelResultaat3);

        int dobbelResultaat4 = dobbelsteen.dobbelen();
        System.out.println("dobbelsteen 4: " + dobbelResultaat4);

        int dobbelResultaat5 = dobbelsteen.dobbelen();
        System.out.println("dobbelsteen 5: " + dobbelResultaat5);

    }
}

class Dobbelsteen{

    int dobbelen(){
        // create random object
        Random random = new Random();

        int resultaat = random.nextInt(6);

        //let op: waarden die terug kunnen komen liggen tussen 0 - 5 (inclusief)!
        return (resultaat + 1);
    }

}
