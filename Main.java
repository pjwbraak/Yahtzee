package com.company;

import java.util.Random;
import java.util.Scanner;

class Main{

    public static void main(String[] args) {

        System.out.println("Yahtzee!");

        Dobbelsteen dobbelsteen = new Dobbelsteen();

        boolean doorspelen = true;

        while(doorspelen = true){
            String input = toonMenu();
            switch(input){
                case "d":

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

                    break;
                case "s":
                    doorspelen = false;
            }

        } //while loop eindigt hier

        System.out.println("Bedankt voor het spelen");

    }

    static String toonMenu() {
        System.out.println("Voer uw input in: d om te dobbelen of s om te stoppen");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
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
