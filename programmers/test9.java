package com.company.algorithm_solving.programmers;

import java.util.ArrayList;
import java.util.Comparator;

public class test9 {

    // k 번째 수
    public static void main(String[ ] args) {

        int[ ] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2,5,3}, {4,4,1}, {1,7,3}};
        solution(array, command);
    }

    public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Order> orderArrayList = new ArrayList<>();
        ArrayList<Integer> resArrayList = new ArrayList<>();

        for(int i=0; i<array.length; i++) {
            orderArrayList.add(new Order(array[i], i + 1));
        }

        orderArrayList.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int value1 = o1.value;
                int value2 = o2.value;

                if(value1 > value2) return 1;
                else if (value1 < value2) return -1;
                else return 0;
            }
        });

        for(int a=0; a<commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            int checkCount=0;

            for(int b=0; b<orderArrayList.size(); b++) {
                if(i <= orderArrayList.get(b).idx && orderArrayList.get(b).idx <= j) {
                    checkCount++;
                    if(checkCount == k) {
                        resArrayList.add(orderArrayList.get(b).value);
                        break;
                    }
                }
            }
        }

       int[ ] answer = new int[resArrayList.size()];
        for(int i=0; i<resArrayList.size(); i++) {
            answer[i] = resArrayList.get(i);
        }
        return answer;
    }

    public static class Order {
        private int value;
        private int idx;

        public Order(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        public int getValue() {
            return value;
        }
        public int getIdx() {
            return idx;
        }
    }
}
