package programmers.weeks4;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_43165 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = bfs(numbers, target);
        return answer;
    }
    public static int bfs(int[] numbers, int target){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(numbers[0]);
        queue.offer(-numbers[0]);
        int index = 1;
        int answer = 0;
        int q = 1;
        while(index < numbers.length){
            q = q * 2;
            for(int i=0; i < q ; i++){
                int n = queue.poll();
                queue.offer(n+numbers[index]);
                queue.offer(n-numbers[index]);

            }
            index++;

        }

        while(!queue.isEmpty()){
            int t = queue.poll();
            if(t == target){
                answer++;
            }
        }
        return answer;

    }
}
