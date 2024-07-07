import java.util.Scanner;

public class Main{
    public static int[][] arr = new int[15][15];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i<arr.length; i++){
            arr[0][i] = i;
            arr[i][1] = 1;
        }

        for(int i = 1; i < arr.length; i++){
            for(int j = 2; j < arr.length; j++){
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        for(int i = 0; i<t; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(arr[k][n-1] + arr[k-1][n]);
        }

    }
}