package day12;

public class Lv1_161989 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 1;
            int s = section[0];
            int e = s + m -1;
            for(int i=1; i<section.length; i++){
                if(section[i] > e){
                    answer++;
                    s = e;
                    e = section[i] + m -1;
                }else if(e > n){
                    break;
                }
            }

            return answer;
        }
    }
}
