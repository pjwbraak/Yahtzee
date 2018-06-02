package com.company;

public class Speler {

    String naam;
    Dobbelsteen dobbelsteen = new Dobbelsteen();

    int[] resultatenDobbelen = new int [5];
    int[] vastgelegdeResultaten = new int[5];

    Speler(String naam){
        this.naam = naam;
    }

    public void dobbelenEersteKeer(){ //vult array resultatenDobbelen met 5 random waardes voor de eerste keer dobbelen per beurt
        for (int x = 0; x < 5; x++) {
            resultatenDobbelen[x] = dobbelsteen.dobbelen();
            System.out.print(resultatenDobbelen[x] + "  ");
        }
    }

    public void dobbelenNaEersteKeer(){
        int i = 0;

        for (int x = 0; x < 5; x++) { // nieuwe random waarden invoeren
            resultatenDobbelen[x] = dobbelsteen.dobbelen();
        }
        for (int x = 0; x < 5; x++) { // vastgelegde waarden vooraan in array zetten
            if (vastgelegdeResultaten[x] > 0) {
                resultatenDobbelen[i] = vastgelegdeResultaten[x];
                i++;
            }
        }
        for (int x = 0; x < 5; x++) { // reeks laten zien
            System.out.print(resultatenDobbelen[x] + "  ");
        }
        System.out.println();
    }

    public void printResultatenDobbelen(){
        System.out.println("Resultaten dobbelen:  ");
        for (int x = 0; x < 5; x++){
            System.out.print(resultatenDobbelen[x] + "  ");
        }
        System.out.println("");
    }

    public void printVastgelegdeResultaten(){
        System.out.println("Vastgelegd zijn: ");
        for (int x = 0; x < 5; x++){
            if(vastgelegdeResultaten[x] > 0){
                System.out.print(vastgelegdeResultaten[x] + "  ");
            }
        }
        System.out.println("");
    }

    public void resetVastgelegdeResultaten(){
        for (int x = 0; x < 5; x++){
            vastgelegdeResultaten[x] = 0;
        }
    }

}
