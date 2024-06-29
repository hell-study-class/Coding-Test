import java.util.Scanner;
import java.util.*;

public class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> que = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();

        // 데이터 삽입
        for(int i = 1; i<=n; i++){
            que.add(i);
        }
        int count = 0;
        while(!que.isEmpty()){
            count++;
            int value = que.poll();
            if(count % k == 0){
                arr.add(value);
            }else{
                que.add(value);
            }
        }

        System.out.print('<');
        for(int i = 0; i<arr.size(); i++){
            if(i == arr.size()-1){
                System.out.print(arr.get(i));
            }else{
                System.out.print(arr.get(i)+", ");
            }
        }
        System.out.print('>');
    }
}