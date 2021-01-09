package com.company.algorithm_solving.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class test12 {

    //  문자열 내 마음대로 정렬하기
    public static void main(String[ ] args) {

        String[ ] strings = {"sun", "bed", "caa", "car"};
        solution(strings, 1);
    }

    public static String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n)) return 1;
                else if(o1.charAt(n) == o2.charAt(n)) return o1.compareTo(o2);
                else return -1;
            }
        });

        return strings;
    }
}
