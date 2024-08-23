package day12;

public class Lv1_161990 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = {};
            int min_x = wallpaper[0].length();
            int min_y = wallpaper.length;
            int max_x = 0;
            int max_y = 0;
            for(int i=0; i<wallpaper.length; i++){
                for(int j=0; j<wallpaper[i].length(); j++){
                    if(wallpaper[i].charAt(j) == '#'){
                        if(min_x > j){
                            min_x = j;
                        }
                        if(min_y > i){
                            min_y = i;
                        }
                        if(max_x < j){
                            max_x = j;
                        }
                        if(max_y < i){
                            max_y = i;
                        }
                    }
                }
            }
            answer = new int[] {min_y, min_x, max_y+1, max_x+1};
            return answer;
        }
    }
}
