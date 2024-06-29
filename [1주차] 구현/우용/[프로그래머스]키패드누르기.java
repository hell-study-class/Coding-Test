import java.util.*;

class Solution {
    public int leftLocation = 10;
    public int rightLocation = 12;

    public String solution(int[] numbers, String hand) {
        StringBuilder rs = new StringBuilder();

        for(int num : numbers){
            if(num == 1 || num == 4 || num ==7 ){
                rs.append("L");
                leftLocation = num;
                continue;
            }
            if(num == 3 || num == 6 || num == 9 ){
                rs.append("R");
                rightLocation = num;
                continue;
            }

            if(num == 0){
                num = 11;
            }

            // 클릭할 숫자 x,y 좌표 값
            int numXLocation = (num-1) / 3;
            int numYLocation = (num-1) % 3;

            // 현재 왼손 x,y 좌표 값
            int leftXLocation = (leftLocation-1) / 3;
            int leftYLocation = (leftLocation-1) % 3;

            // 현재 오른손 x,y 좌표 값
            int rightXLocation = (rightLocation-1) / 3;
            int rightYLocation = (rightLocation-1) % 3;

            int leftDistance = Math.abs(leftXLocation - numXLocation) + Math.abs(leftYLocation - numYLocation);
            int rightDistance = Math.abs(rightXLocation - numXLocation) + Math.abs(rightYLocation - numYLocation);

            if(leftDistance == rightDistance){
                if(hand.equals("right")){
                    rs.append("R");
                    rightLocation = num;
                }else{
                    rs.append("L");
                    leftLocation = num;
                }
            }else if(leftDistance > rightDistance){
                rs.append("R");
                rightLocation = num;
            }else{
                rs.append("L");
                leftLocation = num;
            }
        }

        return rs.toString();
    }
}