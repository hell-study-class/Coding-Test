import java.util.*;

public class Main{
    public static void main(String[] argS){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[][] arr = new int[h][w];

        for(int i = 0; i<h; i++){
            String row = sc.next();
            String[] row_split = row.split("");
            boolean existsCloud = false;
            int cloudCnt = 1;
            for(int j = 0; j<w; j++){
                if(row_split[j].equals("c")){
                    existsCloud = true;
                    arr[i][j] = 0;
                    cloudCnt = 1;
                }else if(row_split[j].equals(".")){
                    if(existsCloud){
                        arr[i][j] = cloudCnt;
                        cloudCnt++;
                    }else{
                        arr[i][j] = -1;
                    }
                }
            }
        }
        for(int i =0; i< h; i++){
            for(int j = 0; j<w; j++){
                System.out.print(arr[i][j]+" "
                );
            }
            System.out.println();
        }
    }
}