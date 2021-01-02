package com.company.algorithm_solving.programmers;

import java.lang.reflect.Array;
import java.util.*;

public class test2 {

    // 두 개 뽑아서 더하기
    public static void main(String[ ] args) {

        int arr[ ] = {2,1,3,4,1};
        int arr2[ ] = {5, 0, 2, 7};

       // Arrays.sort(arr2);
        solution(arr2);

    }

    public static List<Integer> solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, String> hashMap = new HashMap<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int temp = numbers[i] + numbers[j];
                hashMap.put(temp, "ok");
            }
        }

        for(Integer i: hashMap.keySet()) {
            list.add(i);
        }

        Collections.sort(list);
        return list;
    }
}
