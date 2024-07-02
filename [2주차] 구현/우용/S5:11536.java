import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] arr = new String[n];

        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.next();
        }

        String rs = "NEITHER";

        if(arr[0].compareTo(arr[1])>0){
            rs = "DECREASING";
        }else if(arr[0].compareTo(arr[1]) < 0){
            rs = "INCREASING";
        }

        for(int i = 2; i<arr.length; i++){
            if(rs.equals("DECREASING")){
                if(arr[i-1].compareTo(arr[i]) <= 0){
                    System.out.print("NEITHER");
                    return;
                }
            }else if(rs.equals("INCREASING")){
                if(arr[i-1].compareTo(arr[i]) >= 0){
                    System.out.print("NEITHER");
                    return;
                }
            }
        }
        System.out.println(rs);
    }
}