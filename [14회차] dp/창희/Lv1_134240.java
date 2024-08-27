package day14;

public class Lv1_134240 {

    class Solution {
        public String solution(int[] food) {
            String answer = "";
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<food.length; i++){
                int k = food[i]/2;
                for(int j=0; j<k; j++){
                    sb.append(i);
                }
            }
            String temp1 = sb.toString();
            String temp2 = sb.reverse().toString();



            answer = temp1 + "0" + temp2;
            return answer;
        }
    }
}
