import java.util.Scanner;

public class Main {
    public static int[][] map = new int[100][100];

    public static void main(String[] argS){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int area = 0;
        for(int i = 0; i<4; i++){
            int x_l_bottom = sc.nextInt();
            int y_l_bottom = sc.nextInt();
            int x_r_top = sc.nextInt();
            int y_r_top = sc.nextInt();

            for(int q = x_l_bottom; q<x_r_top; q++){
                for(int j = y_l_bottom; j<y_r_top; j++){
                    if(map[q][j] == 0){
                        map[q][j]++;
                        area++;
                    }
                }
            }
        }
        System.out.println(area);
    }
}