import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stWH = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(stWH.nextToken());
        int w = Integer.parseInt(stWH.nextToken());

        char[][] arrLocaion = new char[h][w];
        int[][] arrTime = new int[h][w];

        for(int i = 0; i < h; i++){
            String loc = br.readLine();
            for(int j = 0; j < w; j++){
                arrLocaion[i][j] = loc.charAt(j);
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                arrTime[i][j] = -1;
            }
        }


        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                int time = 0;
                if(arrLocaion[i][j] == 'c'){
                    for(int k = j; k < w; k++){
                        arrTime[i][k] = time;
                        time++;
                    }
                }
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                bw.write(arrTime[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();

    }
}