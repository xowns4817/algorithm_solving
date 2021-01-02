package com.company.algorithm_solving.programmers;

import java.util.ArrayList;

public class test8 {

    //  모의고사
    public static void main(String[ ] args) {

        int[ ] answer = {1,2,3,4,5};
       solution(answer);
    }

    public static int[ ] solution(int[] answers) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int A[ ] = {1, 2, 3, 4, 5};
        int B[ ] = {2, 1, 2, 3, 2, 4, 2, 5};
        int C[ ] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int correct_A = 0;
        int correct_B = 0;
        int correct_C = 0;

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == A[i%5]) correct_A++;
            if(answers[i] == B[i%8]) correct_B++;
            if(answers[i] == C[i%10]) correct_C++;
        }
        int correct_max = Math.max(Math.max(correct_A, correct_B), correct_C);

        if(correct_max == correct_A) arrayList.add(1);
        if(correct_max == correct_B) arrayList.add(2);
        if(correct_max == correct_C) arrayList.add(3);

        int[] res = new int[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
