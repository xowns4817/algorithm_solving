package com.company.algorithm_solving.programmers;

import java.util.Stack;

public class test16 {

    public static void main(String args[ ]) {
        int[] arr = {1,2,3,2,3};
        int n = arr.length;
        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            result[i] = 0;
        };

        Stack<Pair> stack = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            if(stack.empty()) stack.push(new Pair(arr[i], i));
            else {
                while(true){
                    Pair top = stack.peek();
                    int topValue = top.value;
                    int topIdx = top.idx;

                    if(topValue > arr[i]) {
                        stack.pop();
                        result[topIdx] = (i - topIdx);
                        if(stack.empty()) {
                            stack.push(new Pair(arr[i],i));
                            break;
                        }
                    } else {
                        stack.push(new Pair(arr[i],i));
                        break;
                    }
                }
            }
        }

        while(!stack.empty()) {
            Pair top = stack.pop();
            int topIdx = top.idx;
            result[topIdx] = (arr.length - 1) - topIdx;
        }

        for(int i=0; i<result.length; i++) {
            System.out.print(result[i]);
        }
    }

    static class Pair {
        int value;
        int idx;

        public Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}
