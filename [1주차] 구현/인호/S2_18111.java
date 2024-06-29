import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st1.nextToken());
        int w = Integer.parseInt(st1.nextToken());

        int block = Integer.parseInt(st1.nextToken());
        int time = 999999999;
        int goal = 0;

        int[][] arr = new int[h][w];

        int max = 0;
        int min = 256;

        for(int i = 0; i < h ; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < w ; j++ ){
                arr[i][j] = Integer.parseInt(st2.nextToken());
                if(arr[i][j] > max) max = arr[i][j];
                if(arr[i][j] < min) min = arr[i][j];
            }
        }

        for(int i = min; i<max+1; i++){
            int pBlock = block;
            int[][] pArr = arr;
            int pTime = 0;
            for(int j = 0; j < h; j++){
                for(int k = 0; k < w; k++){
                    int change = pArr[j][k] - i;
                    pBlock += change;
                    if(change<0) pTime+=change * (-1);
                    if(change>0) pTime+=change*2;
                }
            }
            if(pBlock < 0 || time < pTime) break;
            goal = i;
            time = pTime;
        }

        bw.write(time + " " + goal);
        bw.flush();

        bw.close();
        br.close();
    }
}