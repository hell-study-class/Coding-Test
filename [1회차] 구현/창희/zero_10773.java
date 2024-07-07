package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class zero_10773 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for(int i=0; i<k; i++) {
            int temp = Integer.parseInt(br.readLine());
            stack.add(temp);
        }

        int count = 0;

        while(!stack.isEmpty()) {
            int t = stack.pop();

            if(t == 0) {
                count++;
            }else if(t != 0 && count > 0) {
                count--;
            }else {
                sum += t;
            }
        }

        System.out.println(sum);
    }
}
