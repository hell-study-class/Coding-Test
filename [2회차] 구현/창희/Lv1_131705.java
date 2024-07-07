package programmers.weeks2;

public class Lv1_131705 {
    class Solution {
        public int solution(int[] number) {
            int answer = 0;
            int l = number.length;
            for(int i=0; i<l-2; i++){
                for(int j=i+1; j<l-1; j++){
                    for(int k=j+1; k<l; k++){
                        if((number[i]+number[j]+number[k]) == 0){
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
