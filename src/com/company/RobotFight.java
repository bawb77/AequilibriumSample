package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.min;

public class RobotFight {

    public Outcome RobotFight(ArrayList<Robot> unSortedRoster) {
        ArrayList<Robot> tempAuto = new ArrayList<>(), tempDecep = new ArrayList<>(), autoBotSurvivors = new ArrayList<>(), decepticonSurvivors = new ArrayList<>();
        int autoBotsDestroyed = 0, decepticonsDestroyed = 0;
        Robot[] autoBots, decepticons;
        Outcome oC;
        int numBattles = 0;
        boolean autoBotsWin;

        for (Robot r : unSortedRoster) {
            if (r.getTeam() == 'A') {
                tempAuto.add(r);
            } else if (r.getTeam() == 'D') {
                tempDecep.add(r);
            }
        }
        autoBots = tempAuto.toArray(new Robot[tempAuto.size()]);
        decepticons = tempDecep.toArray(new Robot[tempDecep.size()]);

        Arrays.sort(autoBots, Collections.reverseOrder());
        Arrays.sort(decepticons, Collections.reverseOrder());

        for (int i = 0; i < min(autoBots.length, decepticons.length); i++) {
            Robot victor;
            if (autoBots[i].getLeader()) {
                if (decepticons[i].getLeader()) {
                    oC = new Outcome(true);
                    return oC;
                }
                victor = autoBots[i];
                numBattles++;
                decepticonsDestroyed++;
            } else if (decepticons[i].getLeader()) {
                victor = decepticons[i];
                numBattles++;
                autoBotsDestroyed++;
            } else {
                victor = arena(autoBots[i], decepticons[i]);
                numBattles++;
            }
            if (victor.getTeam() == 'A') {
                autoBotSurvivors.add(victor);
                decepticonsDestroyed++;
            } else {
                decepticonSurvivors.add(victor);
                autoBotsDestroyed++;
            }
        }
        autoBotsWin = autoBotsDestroyed < decepticonsDestroyed;
        oC = new Outcome(numBattles, autoBotsWin, autoBotSurvivors, decepticonSurvivors);
        return oC;
    }

    public Robot arena(Robot A, Robot D) {

        if (Math.abs(A.getSKILL() - D.getSKILL()) >= 3) {
            if (A.getSKILL() > D.getSKILL()) {
                return A;
            } else {
                return D;
            }
        } else if (Math.abs(A.getSTRENGTH() - D.getSTRENGTH()) >= 3) {
            if (A.getSTRENGTH() > D.getSTRENGTH()) {
                return A;
            } else {
                return D;
            }
        } else if (Math.abs(A.getCOURAGE() - D.getCOURAGE()) >= 4) {
            if (A.getCOURAGE() > D.getCOURAGE()) {
                return A;
            } else {
                return D;
            }
        } else {
            int autoBotOverallRating = A.getSTRENGTH() + A.getINTELLIGENCE() + A.getSPEED() + A.getENDURANCE() + A.getFIREPOWER();
            int decepticonOverallRating = D.getSTRENGTH() + D.getINTELLIGENCE() + D.getSPEED() + D.getENDURANCE() + D.getFIREPOWER();
            if (autoBotOverallRating > decepticonOverallRating) {
                return A;
            } else {
                return D;
            }
        }

    }
}