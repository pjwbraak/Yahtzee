package com.company;

import java.util.Arrays;

public class Speler {

    String naam;

    int beurt;                                      //welke beurt voor speler
    int dobbelKeer;                                 //hoeveel keer speler heeft gedobbeld tijdens beurt
    int[] resultatenDobbelen    = new int [5];      //wat de speler dobbelt
    int[] vastgelegdeResultaten = new int[5];       //wat de speler vastlegt
    Dobbelsteen dobbelsteen     = new Dobbelsteen();
    Score resultaten            = new Score();

    Speler(String naam){
        this.naam = naam;
    }

    //array resultatenDobbelen vullen met 5 waarden
    public void dobbelenEersteKeer(){
        for (int x = 0; x < 5; x++) {
            resultatenDobbelen[x] = dobbelsteen.dobbelen();
            System.out.print(resultatenDobbelen[x] + "  ");
        }
    }

    public int[] dobbelenNaEersteKeer(){
        int i = 0;
        // nieuwe waarden invoeren in resultatenDobbelen
        for (int x = 0; x < 5; x++) {
            resultatenDobbelen[x] = dobbelsteen.dobbelen();
        }
        // vastgelegde waarden vooraan in array plaatsen
        for (int x = 0; x < 5; x++) {
            if (vastgelegdeResultaten[x] > 0) {
                resultatenDobbelen[i] = vastgelegdeResultaten[x];
                i++;
            }
        }
        //reeks laten zien
        for (int x = 0; x < 5; x++) {
            System.out.print(resultatenDobbelen[x] + "  ");
        }
        System.out.println();
        //array teruggeven om score op te slaan
        return resultatenDobbelen;
    }

    public void printResultatenDobbelen(){
        System.out.println("Resultaten dobbelen:  ");
        for (int x = 0; x < 5; x++){
            System.out.print(resultatenDobbelen[x] + "  ");
        }
        System.out.println();
    }

    public void printVastgelegdeResultaten(){
        System.out.println("Vastgelegd zijn: ");
        for (int x = 0; x < 5; x++){
            if(vastgelegdeResultaten[x] > 0){
                System.out.print(vastgelegdeResultaten[x] + "  ");
            }
        }
        System.out.println();
    }

    public void resetVastgelegdeResultaten(){
        for (int x = 0; x < 5; x++){
            vastgelegdeResultaten[x] = 0;
        }
    }

    public void updateScorelijst(){
        int[] resultatenDobbelen    = new int [5];
        for(int x = 0; x < 5; x++){
            resultatenDobbelen[x] = this.resultatenDobbelen[x];
        }
        resultaten.scorelijst.add(resultatenDobbelen);
        System.out.println(Arrays.deepToString(resultaten.scorelijst.toArray()));
    }

}
