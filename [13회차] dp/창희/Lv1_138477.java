package day13;
import java.util.*;

public class Lv1_138477 {

    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            int min = score[0];
            answer[0] = score[0];
            int[] arr = new int[k];
            arr[0] = score[0];

            for(int i=1; i<score.length; i++){
                if(i < k){
                    if(min > score[i]){
                        min = score[i];
                    }
                    arr[i] = score[i];
                    answer[i] = min;

                }else if(i >= k){
                    Arrays.sort(arr);
                    if(arr[0] < score[i]){
                        arr[0] = score[i];
                    }
                    Arrays.sort(arr);
                    answer[i] = arr[0];
                }

            }
            return answer;
        }
    }
}
