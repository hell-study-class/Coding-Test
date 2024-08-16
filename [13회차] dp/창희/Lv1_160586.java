package day13;

public class Lv1_160586 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            int[] min_key = new int[26];
            for(String k : keymap){
                char[] c_arr = k.toCharArray();
                for(int i=0; i<c_arr.length; i++){
                    int index = c_arr[i] - 'A';

                    if(min_key[index] == 0 || min_key[index] > i+1)
                        min_key[index] = i+1;
                }
            }
            for(int i : min_key){
                System.out.print(i + " ");
            }

            for(int j=0; j<targets.length; j++){
                char[] target_arr = targets[j].toCharArray();
                int sum = 0;
                for(int i = 0; i<target_arr.length; i++){
                    int index = target_arr[i] - 'A';
                    if(min_key[index] == 0){
                        sum = 0;
                        break;
                    }
                    sum += min_key[index];
                }
                if(sum > 0){
                    answer[j] = sum;
                }else{
                    answer[j] = -1;
                }
            }
            return answer;
        }
    }
}
