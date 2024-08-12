package day12;
import java.util.*;

public class Lv1_77484 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = {};
            Arrays.sort(lottos);
            Arrays.sort(win_nums);
            int count = 0;
            int zero_count = 0;
            int i = 0;
            int j = 0;
            while(i < lottos.length){
                if(j == win_nums.length){
                    j = win_nums.length-1;
                }
                if(lottos[i] == 0){
                    zero_count++;
                }
                if(lottos[i] == win_nums[j]){
                    count++;
                    i++;
                    j++;
                }else if(lottos[i] < win_nums[j]){
                    i++;
                }else if(lottos[i] > win_nums[j]){
                    j++;
                    if(j == win_nums.length){
                        break;
                    }
                }
            }

            answer = new int[] {rank(count+zero_count), rank(count)};
            return answer;
        }
        public static int rank(int count){
            switch(count){
                case 6:
                    return 1;
                case 5:
                    return 2;
                case 4:
                    return 3;
                case 3:
                    return 4;
                case 2:
                    return 5;
                default:
                    return 6;
            }
        }
    }
}
