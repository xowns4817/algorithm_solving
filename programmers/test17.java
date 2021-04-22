package com.company.algorithm_solving.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

// 오픈 채팅방
public class test17 {
    public static void main(String args[ ]) {

        String[ ] openChat = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        ArrayList<Pair> resList = new ArrayList<>();
        ArrayList<String> returnList = new ArrayList<>();
        HashMap<String, String> mmap = new HashMap<>();
        String inMsg = "님이 들어왔습니다.";
        String outMsg = "님이 나갔습니다.";

        for(int i=0; i<openChat.length; i++) {
            String[ ] commands = openChat[i].split(" ");
            String cmd = commands[0];
            String userId = commands[1];
            String nickName = null;

            if(cmd.equals("Enter") || cmd.equals("Change")) {
                nickName = commands[2];
                mmap.put(userId, nickName);

                if(cmd.equals("Enter")) resList.add(new Pair(userId, inMsg));
            }
            else { // "Leave"
                resList.add(new Pair(userId, outMsg));
            }
        }

        for(int i=0; i<resList.size(); i++) {
            String userId = resList.get(i).userId;
            String inOutMsg = resList.get(i).inOutMsg;
            String nickName = mmap.get(userId);
            returnList.add(nickName + inOutMsg);
        }
    }

    static class Pair {
        String userId;
        String inOutMsg;

        public Pair(String userId, String inOutMsg) {
            this.userId = userId;
            this.inOutMsg = inOutMsg;
        }
    }
}
