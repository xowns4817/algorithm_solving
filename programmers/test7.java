package com.company.algorithm_solving.programmers;

import java.util.HashMap;

public class test7 {
    // 완주하지 못한 선수
    public static void main(String[ ] args) {

        String[ ] participant = {"kiki", "eden", "leo"};
        String[ ] colpletion = {"eden", "kiki"};

        System.out.print(solution(participant, colpletion));
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap();
        String answer="";
        for(int i=0; i<completion.length; i++) {
            if(hashMap.containsKey(completion[i])) hashMap.put(completion[i], hashMap.get(completion[i]) + 1);
            else hashMap.put(completion[i], 1);
        }

        for(int i=0; i<participant.length; i++) {
            if(hashMap.containsKey(participant[i])) {
                if(hashMap.get(participant[i]) == 1) hashMap.remove(participant[i]);
                else hashMap.put(participant[i], hashMap.get(participant[i]) - 1);
            } else {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}
