package com.company.algorithm_solving.programmers;

import java.util.ArrayList;

public class test15_2 {
    public static void main(String args[ ]) {
        int n = 5;
        int[ ][ ] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = 0;
            }
        }

        int value = 1;

        int now_x = 0;
        int now_y = 0;
        int direction = 0; // 0(아래), 1(오른쪽), 2(좌상단)

        arr[now_x][now_y] = value++;
        for(int i=1; i<n; i++) { // 아래
            now_x = i;
            arr[now_x][now_y] = value++;
        }

        for(int i=1; i<n; i++) { // 가로
            arr[now_x][++now_y] = value++;
        }

        direction = 2; // 좌상단
        while(n != 1 && n != 2) {
            if(direction == 0) { // 하
                if(arr[now_x + 1][now_y] != 0) {
                    if(arr[now_x][now_y + 1] != 0) break; // 하 -> 우
                    else {
                        now_y +=1;
                        direction = 1;
                    }
                } else {
                    now_x+=1;
                }
            } else if(direction == 1) { // 우
                if(arr[now_x][now_y + 1] != 0) {
                    if(arr[now_x - 1][now_y - 1] != 0) break;   // 우 -> 좌상단
                    else {
                        now_x -= 1;
                        now_y -= 1;
                        direction = 2;
                    }
                } else {
                    now_y += 1;
                }
            } else if(direction == 2) { // 좌상단
                if(arr[now_x -1][now_y - 1] != 0) {
                    if(arr[now_x + 1][now_y] != 0) break;  // 좌상단 -> 아래
                    else {
                        now_x += 1;
                        direction = 0;
                    }
                } else {
                    now_x-=1;
                    now_y-=1;
                }
            }

            arr[now_x][now_y] = value++;
        }

        ArrayList<Integer> resArrayList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 0) break;
                resArrayList.add(arr[i][j]);
            }
        }

        int[ ] resArr = new int[resArrayList.size()];
        for(int i=0; i<resArrayList.size(); i++) {
            resArr[i] = resArrayList.get(i);
            System.out.println(resArr[i]);
        }
    }
}
