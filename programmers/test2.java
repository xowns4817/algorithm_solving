package com.company.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class test2 {

    // 두 개 뽑아서 더하기 ( 실패... 왜 틀리는지 모르겟음.. )
    public static void main(String[ ] args) {

        int arr[ ] = {2,1,3,4,1};
        int arr2[ ] = {5, 0, 2, 7};

       // Arrays.sort(arr2);
        solution(arr2);
    }

    public static int[] solution(int[] numbers) {
        int[] answer;
        HashMap<Integer, String> hashMap = new HashMap<>();
        Queue<Integer> tmpQueue = new LinkedList<>();

        Arrays.sort(numbers);

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                Integer temp = new Integer(numbers[i] + numbers[j]);

                if(hashMap.containsKey(temp) == true) continue;
                else {
                    hashMap.put(temp, "ok");
                    tmpQueue.offer(temp);
                }
            }
        }

        int idx=0;
        answer = new int[tmpQueue.size()];
        while(!tmpQueue.isEmpty()) answer[idx++] = (tmpQueue.poll()).intValue();

        hashMap.clear();
        tmpQueue.clear();
        return answer;
    }
}
