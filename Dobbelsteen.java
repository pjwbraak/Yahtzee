package com.company;

import java.util.Random;

class Dobbelsteen {

    public int dobbelen() {
        Random random = new Random();
        int resultaat = random.nextInt(6);
        return (resultaat + 1);
    }
}
