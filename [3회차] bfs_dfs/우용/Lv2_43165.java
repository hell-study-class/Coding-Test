import java.util.*;

class Solution {

    public static int t;
    public static int count = 0;
    public static int[] arr;

    public int solution(int[] numbers, int target) {

        t = target;
        arr = numbers;

        dfs(-1, 0);


        return count;
    }

    public static void dfs(int index, int sum){
        if(index == arr.length-1){
            if(sum == t){
                count++;
            }
            return;
        }
        for(int i = 0; i< 2; i++){
            if(i == 0){
                dfs(index+1, sum + arr[index+1]);
            }
            if(i == 1){
                dfs(index+1, sum - arr[index+1]);
            }
        }
    }
}