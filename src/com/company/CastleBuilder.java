package com.company;

public class CastleBuilder {
    int numCastles;

    public int CastleBuilder(int[] input) {
        int current, last;
        numCastles = 1;
        for (int i = 0; i < input.length - 1; i++) {
            current = input[i];
            if (i != 0) {
                last = input[i - 1];
            } else {
                last = 0;
            }
            if (current < last) {
                i = inAValley(i, input);
            }
            if (current > last) {
                i = inAPeak(i, input);
            }
        }
        //System.out.print("number of castles " + numCastles);
        return numCastles;
    }

    public int inAPeak(int position, int[] input) {
        //System.out.print("in peak");
        if (input[position] > input[position + 1]) {
            numCastles++;
            return position;
        } else if (input[position] == input[position + 1]) {
            return inAPeak(position + 1, input);
        }
        return position;

    }

    public int inAValley(int position, int[] input) {
        // System.out.print("in valley");
        if (input[position] < input[position + 1]) {
            numCastles++;
            return position;
        } else if (input[position] == input[position + 1]) {
            return inAPeak(position + 1, input);
        }
        return position;

    }
}
