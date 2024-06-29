import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int zr = sc.nextInt();
        int zc = sc.nextInt();

        String[] arr = new String[r];

        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.next();
        };


        for(int i = 0; i<arr.length; i++){
            if(zc > 1){
                String[] strArr = arr[i].split("");
                StringBuilder builder = new StringBuilder();
                for(String s : strArr){
                    for(int j = 0; j <zc; j++){
                        builder.append(s);
                    }
                }
                arr[i] = builder.toString();
            }
            for(int j = 0; j<zr; j++){
                System.out.println(arr[i]);
            }
        }
    }
}