package com.company;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class CastleTest {
    @Test
    void testCastleBuilding(){
        int[] test1 = new int[]{1,2,3,4,3,2,1}, test2 = new int[]{1,1,1}, test3 = new int[]{1,6,6,6,1}, test4 = new int[]{6,7,6,5,4,3,6,3,2,1,2}, test5 = new int[]{1}, test6 = new int[]{1,2,3,4,2,4,1};
        CastleBuilder cB = new CastleBuilder();
        int i = cB.castleBuilder(test1);
        System.out.print("\nTest 1 Pass: " + (i==2));
        i = cB.castleBuilder(test2);
        System.out.print("\nTest 2 Pass: " + (i==1));
        i = cB.castleBuilder(test3);
        System.out.print("\nTest 3 Pass: " + (i==2));
        i = cB.castleBuilder(test4);
        System.out.print("\nTest 4 Pass: " + (i==5));
        i = cB.castleBuilder(test5);
        System.out.print("\nTest 5 Pass: " + (i==1));
        i = cB.castleBuilder(test6);
        System.out.print("\nTest 6 Pass: " + (i==4));
    }
    @Test
    void testRobotFight(){
        char decepticons = 'D', autoBots = 'A';
        int[] soundWaveStats = new int[]{8,9,2,6,7,5,6,10}, blueStreakStats = new int[]{6,6,7,9,5,2,9,7}, optimusPrimeStats = new int[]{1,2,3,4,5,6,7,8},
                predakingStats = new int[]{1,1,1,1,1,1,1,1}, hubcapStats = new int[]{4,4,4,4,4,4,4,4,4}, courageBotnewStats = new int[]{1,1,1,1,1,10,1,1},
                strengthBotStats = new int[]{10,1,1,1,1,1,1,1},skillBotStats = new int[]{1,1,1,1,1,1,1,10}, loserBotStats = new int[]{3,3,3,3,3,3,3,3};
        Robot soundWave = new Robot("Soundwave ", decepticons, soundWaveStats);
        Robot blueStreak = new Robot("BlueStreak ", autoBots, blueStreakStats);
        Robot optimusPrime = new Robot("Optimus Prime",autoBots,optimusPrimeStats);
        Robot predaKing = new Robot("predaking",decepticons,predakingStats);
        Robot hubcap = new Robot("Hubcap",autoBots,hubcapStats);
        Robot courageBot = new Robot("Courage Test",autoBots,courageBotnewStats);
        Robot strengthBot = new Robot("Strength Test",autoBots,strengthBotStats);
        Robot skillBot = new Robot("Skill Test",autoBots,skillBotStats);
        Robot loserBot = new Robot("loser",decepticons,loserBotStats);


        ArrayList<Robot> testContainer = new ArrayList<>();
        RobotFight rB = new RobotFight();
        Outcome oC;
        //courage test
        testContainer.add(loserBot);
        testContainer.add(courageBot);
        oC = rB.robotFight(testContainer);
        if(oC.getAutoBotsWin()&&oC.getDecepticonSurvivors().isEmpty()&&oC.getAutoBotSurvivors().contains(courageBot)){
            System.out.print("\nCourage Test Passed");
        }else{
            System.out.print("\nCourage Test Failed");
        }
        testContainer.clear();
        //strength test
        testContainer.add(loserBot);
        testContainer.add(strengthBot);
        oC = rB.robotFight(testContainer);
        if(oC.getAutoBotsWin()&&oC.getDecepticonSurvivors().isEmpty()&&oC.getAutoBotSurvivors().contains(strengthBot)){
            System.out.print("\nStrength Test Passed");
        }else{
            System.out.print("\nStrength Test Failed");
        }
        testContainer.clear();
        //skill test
        testContainer.add(loserBot);
        testContainer.add(skillBot);
        oC = rB.robotFight(testContainer);
        if(oC.getAutoBotsWin()&&oC.getDecepticonSurvivors().isEmpty()&&oC.getAutoBotSurvivors().contains(skillBot)){
            System.out.print("\nSkill Test Passed");
        }else{
            System.out.print("\nSkill Test Failed");
        }
        testContainer.clear();
        //leader vs leader
        testContainer.add(optimusPrime);
        testContainer.add(predaKing);
        oC = rB.robotFight(testContainer);
        if(oC.getDoomsDay()){
            System.out.print("\nLeader VS Leader Test Passed");
        }else{
            System.out.print("\nLeader VS Leader Test Failed");
        }
        testContainer.clear();
        //autobots leader
        testContainer.add(optimusPrime);
        testContainer.add(soundWave);
        oC = rB.robotFight(testContainer);
        if(oC.getAutoBotsWin()&&oC.getDecepticonSurvivors().isEmpty()&&oC.getAutoBotSurvivors().contains(optimusPrime)){
            System.out.print("\nAutobots Leader Test Passed");
        }else{
            System.out.print("\nAutobots Leader Test Failed");
        }
        testContainer.clear();
        //decepticons leader
        testContainer.add(hubcap);
        testContainer.add(predaKing);
        oC = rB.robotFight(testContainer);
        if(!oC.getAutoBotsWin()&&oC.getDecepticonSurvivors().contains(predaKing)&&oC.getAutoBotSurvivors().isEmpty()){
            System.out.print("\nDecepticons Leader Test Passed");
        }else{
            System.out.print("\nDecepticons Leader Test Failed");
        }
        testContainer.clear();
        //example case
        testContainer.add(soundWave);
        testContainer.add(blueStreak);
        testContainer.add(hubcap);
        oC = rB.robotFight(testContainer);
        if(!oC.getAutoBotsWin()&&oC.getDecepticonSurvivors().contains(soundWave)&&oC.getAutoBotSurvivors().contains(hubcap)){
            System.out.print("\nExample Test Passed");
        }else{
            System.out.print("\nExample Test Failed");
        }
        testContainer.clear();
    }
}
