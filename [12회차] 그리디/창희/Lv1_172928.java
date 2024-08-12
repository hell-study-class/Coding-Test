package day12;

public class Lv1_172928 {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];
            int[] cur = new int[2];
            for(int i=0; i<park.length; i++){
                if(park[i].contains("S")){
                    for(int j=0; j<park[i].length(); j++){
                        if(park[i].charAt(j) == 'S'){
                            cur[0] = i;
                            cur[1] = j;
                        }
                    }
                }
            }
            for(int i=0; i<routes.length; i++){
                String[] arr = routes[i].split(" ");
                int x = cur[1];
                int y = cur[0];
                System.out.println(x + " " + y);
                if(arr[0].equals("E")){
                    int nx = x + Integer.parseInt(arr[1]);
                    cur[1] = nx;
                    for(int j=x; j<=nx; j++){
                        if(j >= park[0].length() || park[y].charAt(j) == 'X' ){
                            cur[1] = x;
                            break;
                        }
                    }
                }else if(arr[0].equals("S")){
                    int ny = y + Integer.parseInt(arr[1]);
                    cur[0] = ny;
                    for(int j=y; j<=ny; j++){
                        if(j >= park.length || park[j].charAt(x) == 'X'){
                            cur[0] = y;
                            break;
                        }
                    }
                }else if(arr[0].equals("W")){
                    int nx = x - Integer.parseInt(arr[1]);
                    cur[1] = nx;
                    for(int j=nx; j<=x; j++){
                        if(j < 0 || park[y].charAt(j) == 'X' ){
                            cur[1] = x;
                            break;
                        }
                    }
                }else if(arr[0].equals("N")){
                    int ny = y - Integer.parseInt(arr[1]);
                    cur[0] = ny;
                    for(int j=ny; j<=y; j++){
                        if(ny < 0|| park[j].charAt(x) == 'X'){
                            cur[0] = y;
                            break;
                        }
                    }
                }
            }
            answer[0] = cur[0];
            answer[1] = cur[1];
            return answer;
        }
    }
}
