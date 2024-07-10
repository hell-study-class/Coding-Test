import java.io.*;
import java.util.*;

public class Main{
    static int n,acnt;
    static int cnt = 0;
    static int[][] apt;
    static List<Integer> list = new ArrayList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        apt = new int[n][n];
        for(int i=0; i<n; i++){
            String[] st = br.readLine().split("");
            for(int j=0; j<n; j++){
                apt[i][j] = Integer.parseInt(st[j]);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(apt[i][j]==1){
                    acnt = 0;
                    dfs(i,j);
                    list.add(acnt);
                    cnt++;
                }
            }
        }

        bw.write(cnt+"");
        Collections.sort(list);
        for(int i =0; i < list.size(); i++){
            bw.newLine();
            bw.write(list.get(i)+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y){
        apt[x][y] = 0;
        acnt++;
        for(int i = 0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx < 0 || cx >= n || cy < 0|| cy >=n){
                continue;
            }
            if(apt[cx][cy] == 0){
                continue;
            }
            dfs(cx,cy);
        }
    }
}