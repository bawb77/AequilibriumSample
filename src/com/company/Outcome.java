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

    public boolean getDoomsDay() {
        return doomsday;
    }

    public int getNumBattles() {
        return numBattles;
    }

    public boolean getAutoBotsWin() {
        return autoBotsWin;
    }

    public ArrayList<Robot> getAutoBotSurvivors() {
        return autoBotSurvivors;
    }

    public ArrayList<Robot> getDecepticonSurvivors() {
        return decepticonSurvivors;
    }
}
