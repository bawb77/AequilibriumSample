package com.company;

import java.util.ArrayList;

class Outcome {
    private int numBattles;
    private boolean autoBotsWin;
    private ArrayList<Robot> autoBotSurvivors, decepticonSurvivors;
    private boolean doomsday;

    Outcome(int b, boolean t, ArrayList<Robot> a, ArrayList<Robot> d) {
        this.numBattles = b;
        this.autoBotsWin = t;
        this.autoBotSurvivors = a;
        this.decepticonSurvivors = d;
    }

    Outcome(boolean dd) {
        this.doomsday = dd;
    }

    private boolean getDoomsDay() {
        return doomsday;
    }

    private int getNumBattles() {
        return numBattles;
    }

    private boolean getAutoBotsWin() {
        return autoBotsWin;
    }

    private ArrayList<Robot> getAutoBotSurvivors() {
        return autoBotSurvivors;
    }

    private ArrayList<Robot> getDecepticonSurvivors() {
        return decepticonSurvivors;
    }
}
