package com.company;

import java.util.Random;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        System.out.println("Yahtzee!");

        Dobbelsteen dobbelsteen = new Dobbelsteen();
        int[] resultatenDobbelen = new int[5];

        boolean doorspelen = true;

        while (doorspelen == true) {

            String input = toonDobbelMenu();
            switch (input) {

                case "d":

                    for(int x = 0; x < 5; x++){
                        resultatenDobbelen[x] = dobbelsteen.dobbelen();
                        System.out.println("dobbelsteen " + (x + 1) + " = " + resultatenDobbelen[x]);
                    }

                    break;

                case "s":
                    doorspelen = false;
            }

        } //while loop eindigt hier

        System.out.println("Bedankt voor het spelen!");

    }

    static String toonDobbelMenu() {
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