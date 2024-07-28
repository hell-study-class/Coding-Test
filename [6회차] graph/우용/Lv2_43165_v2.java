import java.util.*;

class Solution {

    public static int[] arr;
    public static int t;
    public static int count = 0;

    public int solution(int[] numbers, int target) {
        arr = numbers;
        t = target;

        dfs(0,0);

        return count;
    }

    public static void dfs(int index, int sum){
        if(index == arr.length){
            if(sum == t){
                count++;
            }
            return;
        }

        dfs(index+1, sum+arr[index]);
        dfs(index+1, sum-arr[index]);
    }
}