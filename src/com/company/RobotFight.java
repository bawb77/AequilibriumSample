package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RobotFight {

    public Outcome robotFight(ArrayList<Robot> unSortedRoster) {
        ArrayList<Robot>  autoBotSurvivors = new ArrayList<>(), decepticonSurvivors = new ArrayList<>();
        Robot[] autoBots, decepticons;
        Outcome oC;
        int numBattles = 0;
        boolean autoBotsWin;

        for (Robot r : unSortedRoster) {
            if (r.getTeam() == 'A') {
                autoBotSurvivors.add(r);
            } else if (r.getTeam() == 'D') {
                decepticonSurvivors.add(r);
            }
        }
        autoBots = autoBotSurvivors.toArray(new Robot[autoBotSurvivors.size()]);
        decepticons = decepticonSurvivors.toArray(new Robot[decepticonSurvivors.size()]);
        Arrays.sort(autoBots, Collections.reverseOrder());
        Arrays.sort(decepticons, Collections.reverseOrder());

        for (int i = 0; i < min(autoBots.length, decepticons.length); i++) {
            Robot loser;
            if (autoBots[i].getLeader()) {
                if (decepticons[i].getLeader()) {
                    oC = new Outcome(true);
                    return oC;
                }
                loser = decepticons[i];
                numBattles++;
            }else if (decepticons[i].getLeader()) {
                loser = autoBots[i];
                numBattles++;
            } else {
                loser = arena(autoBots[i], decepticons[i]);
                numBattles++;
            }
            if (loser.getTeam() == 'N') {
                System.out.print("\nBoth Robots Destroyed!\n");
            } else if(loser.getTeam() == 'D') {
                decepticonSurvivors.remove(loser);
            }else{
                autoBotSurvivors.remove(loser);
            }
        }
        autoBotsWin = autoBotSurvivors.size() > decepticonSurvivors.size();
        oC = new Outcome(numBattles, autoBotsWin, autoBotSurvivors, decepticonSurvivors);
        return oC;
    }

    private Robot arena(Robot A, Robot D) {

        if (Math.abs(A.getSKILL() - D.getSKILL()) >= 3) {
            if (A.getSKILL() > D.getSKILL()) {
                return D;
            } else {
                return A;
            }
        } else if (Math.abs(A.getSTRENGTH() - D.getSTRENGTH()) >= 3) {
            if (A.getSTRENGTH() > D.getSTRENGTH()) {
                return D;
            } else {
                return A;
            }
        } else if (Math.abs(A.getCOURAGE() - D.getCOURAGE()) >= 4) {
            if (A.getCOURAGE() > D.getCOURAGE()) {
                return D;
            } else {
                return A;
            }
        } else {
            int autoBotOverallRating = A.getSTRENGTH() + A.getINTELLIGENCE() + A.getSPEED() + A.getENDURANCE() + A.getFIREPOWER();
            int decepticonOverallRating = D.getSTRENGTH() + D.getINTELLIGENCE() + D.getSPEED() + D.getENDURANCE() + D.getFIREPOWER();
            if (autoBotOverallRating == decepticonOverallRating)
            {
                int[] i = new int[8];
                Robot noVictor = new Robot("",'N',i);
                return noVictor;
            }
            if (autoBotOverallRating > decepticonOverallRating) {
                return D;
            } else {
                return A;
            }
        }
    }
}