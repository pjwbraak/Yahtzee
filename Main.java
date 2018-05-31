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
        dobbelsteen.dobbelen();

    }
}

class Dobbelsteen{

    void dobbelen(){
        // create random object
        Random random = new Random();

        // check next int value - let op: waarden die terug kunnen komen liggen tussen 0 - 5 (inclusief)!
        System.out.println("Gedobbeld: " + random.nextInt(6));
    }

}
