import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        int cross_count = 1;
        int prev_count_sum = 0;

        while(true){
            if(num <= prev_count_sum + cross_count){
                if(cross_count % 2 == 1){     // 홀수 경우
                    System.out.println((cross_count - (num - prev_count_sum - 1)) + "/"+(num - prev_count_sum));
                    break;
                }
                else{                        // 짝수 경우
                    System.out.println((num - prev_count_sum)+"/"+(cross_count - (num-prev_count_sum-1)));
                    break;
                }
            }else{
                prev_count_sum += cross_count;
                cross_count++;
            }

        }
    }
}