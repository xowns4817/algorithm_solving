package com.company.algorithm_solving.programmers;

import java.util.Stack;

// 크레인 인형 뽑기
public class test1 {

    public static void main(String[] args) {
        int board[][]= {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}};
        int moves[ ] = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size=board[0].length;
        Stack<Integer> bucket = new Stack<>();

        for(int i=0; i<moves.length; i++) { // 가로
            for(int j=0; j<size; j++) { // 세로
                if(board[j][moves[i] - 1] == 0) continue;
                else {
                    int tick=board[j][moves[i] - 1];
                    if(bucket.empty()) bucket.push(tick);
                    else {
                        int top = bucket.peek();
                        if(top != tick) bucket.push(tick);
                        else {
                            bucket.pop();
                            answer+=2;
                        }
                    }
                }
                board[j][moves[i] - 1] = 0;
                break;
            }
        }
        return answer;
    }
}
