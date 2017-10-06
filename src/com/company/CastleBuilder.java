package com.company;

public class CastleBuilder {
    int numCastles,size;

    public int castleBuilder(int[] input) {
        size = input.length;
        int current, last;
        numCastles = 1;
        for (int i = 0; i < size - 1; i++) {
            current = input[i];
            if (i != 0) {
                last = input[i - 1];
            } else {
                last = 0;
            }
            if (current == last){
                i++;
            }else if (current < last) {
                i = inAValley(i, input);
            }else if (current > last) {
                i = inAPeak(i, input);
            }
        }
        return numCastles;
    }

    public int inAPeak(int position, int[] input) {
        if (position < size - 1) {
            if (input[position] > input[position + 1]) {
                numCastles++;
                return position;
            } else if (input[position] == input[position + 1]) {
                return inAPeak(position + 1, input);
            }
        }
        return position;
    }

    public int inAValley(int position, int[] input) {
        if(position < size - 1){
            if (input[position] < input[position + 1]) {
                numCastles++;
                return position;
            } else if (input[position] == input[position + 1]) {

                return inAValley(position + 1, input);
            }
        }
        return position;
    }
}
