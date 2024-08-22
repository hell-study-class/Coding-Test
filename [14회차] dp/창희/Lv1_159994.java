package day14;

public class Lv1_159994 {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "Yes";
            int card1_index = 0;
            int card2_index = 0;
            for(int i=0; i<goal.length; i++){
                boolean check = false;

                if(card1_index < cards1.length&& cards1[card1_index].equals(goal[i])){
                    card1_index++;
                    check = true;
                    continue;
                }

                if(card2_index < cards2.length && cards2[card2_index].equals(goal[i])){
                    card2_index++;
                    check = true;
                    continue;
                }

                if(!check){
                    answer = "No";
                    return answer;
                }
            }
            return answer;
        }
    }
}
