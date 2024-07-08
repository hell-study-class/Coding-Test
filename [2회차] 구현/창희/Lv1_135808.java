package programmers.weeks2;
import java.util.*;

public class Lv1_135808 {

    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            //k = 최고점 사과, m은 상자 1개당 사과의 개수, score 사과 점수
            //사과 1박스의 점수는 p * m  p는 최저점
            Arrays.sort(score);
            int index = score.length;
            while(index >= m){
                index -= m;
                answer += score[index] * m;
            }

            return answer;
        }
    }
}
