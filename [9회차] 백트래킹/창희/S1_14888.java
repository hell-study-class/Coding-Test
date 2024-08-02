package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_14888 {
    static int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] cal = new int[4];
        cal[0]= Integer.parseInt(st.nextToken());
        cal[1]= Integer.parseInt(st.nextToken());
        cal[2] = Integer.parseInt(st.nextToken());
        cal[3] = Integer.parseInt(st.nextToken());
        int sum = numbers[0];
        calculate(numbers, sum, cal ,1);
        System.out.println(result[1]);
        System.out.println(result[0]);
    }
    public static int[] calculate(int[] numbers, int sum, int[]cal, int index){
        int t = 0;
        for(int i : cal){
            t += i;
        }

        if(t == 0){
            if(sum < result[0]){
                result[0] = sum;
            }
            if(sum > result[1]){
                result[1] = sum;
            }
            return result;
        }
            for(int j = 0; j < 4 ; j++){
                if(cal[j] > 0 ){
                    int tmp =sum;
                    switch(j){
                        case 0 : sum += numbers[index]; break;
                        case 1 : sum -= numbers[index]; break;
                        case 2 : sum *= numbers[index]; break;
                        case 3 : sum /= numbers[index]; break;
                    }
                    cal[j]--;
                    calculate(numbers, sum, cal,index+1);
                    sum = tmp;
                    cal[j]++;
                }
        }
         return result;
    }
}
