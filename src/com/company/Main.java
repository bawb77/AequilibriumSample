package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        final String AUTOBOTS = "Autobots", DECEPTICONS = "Decepticons";
        RobotFight theBattle = new RobotFight();
        Scanner sC = new Scanner(System.in);

        System.out.print("Hello and welcome to the castle and robot crusher example\nPlease enter either 1 for castles or 2 for robots:");
        int program = sC.nextInt();

        if (program == 1) {
            System.out.print("\nPlease input your land features below in the format x,x,x,x \n");
            String land = sC.next();
            String[] stringArray = land.split(",");
            int[] newLand = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                String numberAsString = stringArray[i];
                newLand[i] = Integer.parseInt(numberAsString);
            }
            CastleBuilder cB = new CastleBuilder();
            System.out.print("There are " + cB.CastleBuilder(newLand) + " castles in this land");
        } else if (program == 2) {
            String addMore, tempHolder;
            Robot tempRobot;
            ArrayList<Robot> tempRoster = new ArrayList<>();
            BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.print("\nPlease input your challengers in the format Soundwave,D,8,9,2,6,7,5,6,10\n");
                tempHolder = bR.readLine();
                String[] stringArray = tempHolder.split(",");
                int[] tempStats = new int[stringArray.length - 2];
                for (int i = 2; i < stringArray.length - 2; i++) {
                    String numberAsString = stringArray[i];
                    tempStats[i] = Integer.parseInt(numberAsString);
                }
                tempRobot = new Robot(stringArray[0], stringArray[1].charAt(0), tempStats);
                tempRoster.add(tempRobot);
                System.out.print("\nInput accepted, Add another? (y/n)");
                addMore = sC.next();
            } while (addMore.contains("y"));
            bR.close();
            sC.close();
            Outcome oC = theBattle.RobotFight(tempRoster);
            if (oC.getDoomsDay()) {
                System.out.print("All Competitors Destroyed");
            } else {
                ArrayList<Robot> winningSurvivors, losingSurvivors;
                String winName, loseName;
                if (oC.getAutoBotsWin()) {
                    winningSurvivors = oC.getAutoBotSurvivors();
                    losingSurvivors = oC.getDecepticonSurvivors();
                    winName = AUTOBOTS;
                    loseName = DECEPTICONS;
                } else {
                    winningSurvivors = oC.getDecepticonSurvivors();
                    losingSurvivors = oC.getAutoBotSurvivors();
                    winName = DECEPTICONS;
                    loseName = AUTOBOTS;
                }
                System.out.print("\n" + oC.getNumBattles() + " Battles\nWinning team (" + winName + "): ");
                for (Robot r : winningSurvivors) {
                    System.out.print(r.getName());
                }
                System.out.print("\nSurvivors from the losing team (" + loseName + "): ");
                for (Robot r : losingSurvivors) {
                    System.out.print(r.getName() + ", ");
                }
            }
        } else {
            System.out.print("\nIncorrect Input please try again");
        }
    }
}
