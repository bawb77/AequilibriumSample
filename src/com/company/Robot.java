package com.company;

import java.util.Arrays;

class Robot implements Comparable<Robot> {
    private final int STRENGTH, INTELLIGENCE, SPEED, ENDURANCE, RANK, COURAGE, FIREPOWER, SKILL, overall;
    String[] specialCase = new String[]{"optimus prime", "predaking"};
    private String name;
    private char team;
    private boolean leader;

    Robot(String n, char t, int[] s) {
        this.name = n;
        this.leader = Arrays.stream(specialCase).anyMatch(name.toLowerCase()::contains);
        this.team = t;
        this.STRENGTH = s[0];
        this.INTELLIGENCE = s[1];
        this.SPEED = s[2];
        this.ENDURANCE = s[3];
        this.RANK = s[4];
        this.COURAGE = s[5];
        this.FIREPOWER = s[6];
        this.SKILL = s[7];
        this.overall = s[0] + s[1] + s[2] + s[3] + s[6];
    }

    public boolean getLeader() {
        return leader;
    }

    public int getCOURAGE() {
        return COURAGE;
    }

    public int getENDURANCE() {
        return ENDURANCE;
    }

    public int getFIREPOWER() {
        return FIREPOWER;
    }

    public int getINTELLIGENCE() {
        return INTELLIGENCE;
    }

    public int getOverall() {
        return overall;
    }

    public int getRANK() {
        return RANK;
    }

    public int getSKILL() {
        return SKILL;
    }

    public int getSPEED() {
        return SPEED;
    }

    public int getSTRENGTH() {
        return STRENGTH;
    }

    public char getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Robot o) {
        return new Integer(this.RANK).compareTo(new Integer(o.RANK));
    }
}
