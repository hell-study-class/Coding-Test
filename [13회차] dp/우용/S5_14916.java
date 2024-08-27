import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int change = 100000/ 2;
        if(num % 5 == 0){
            System.out.println(num/5);
            return;
        }else{
            for(int i=num/5; i>=1; i--){
                int next = num - (5*i);
                if(next % 2 == 0 && (next /2) +i < change){
                    change = (next/2)+i;
                }
            }
            if(num % 2 ==0 && change > (num / 2)){
                System.out.println(num / 2);
                return;
            }
            else if(change == 100000/2){
                System.out.println(-1);
                return ;
            }else{
                System.out.println(change);
            }
        }
    }
}