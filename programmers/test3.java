package com.company.algorithm_solving.programmers;

public class test3 {

    // 스킬트리
    public static void main(String[ ] args) {

        StringBuilder skill = new StringBuilder("CBD");
        StringBuilder skill_trees[] = { new StringBuilder("BACDE"),
                                        new StringBuilder("CBADF"),
                                        new StringBuilder("AECB"),
                                        new StringBuilder("BDA")
        };

        System.out.println(solution(skill, skill_trees));
    }

    public static int solution(StringBuilder skill, StringBuilder[ ] skill_trees) {

        int answer = 0;
        int skill_trees_len = skill_trees.length;

        for(int i=0; i<skill_trees_len; i++) {
            for(int j=0; j<skill_trees[i].length(); j++) {
             boolean isContain=false;
                for(int k=0; k<skill.length(); k++) {
                    if(skill_trees[i].charAt(j) == skill.charAt(k)) {
                        isContain=true;
                        break;
                    }
                 }
                 if(!isContain) {
                     skill_trees[i].deleteCharAt(j);
                     j--;
                 }
            }

            if(isCanSkillTree(skill_trees[i], skill)) answer++;
        }

        return answer;
    }

    public static boolean isCanSkillTree(StringBuilder skillTree, StringBuilder skill) {

        for(int i=0; i<skillTree.length(); i++) {
            if(skillTree.charAt(i) != skill.charAt(i)) return false;
        }
        return true;
    }
}
