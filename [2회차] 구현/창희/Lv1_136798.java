package programmers.weeks2;

public class Lv1_136798 {
    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            int[] p = new int[number];
            for(int i=1; i<number+1; i++){
                int count = 1;
                for(int j=1; j<=i/2; j++){
                    if(i%j == 0){
                        count++;
                    }
                }
                p[i-1] = count;
            }
            for(int i=0; i<number; i++){
                if(p[i] > limit){
                    answer += power;
                }else{
                    answer += p[i];
                }

            }
            return answer;
        }
    }
}
