import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    static String[][] board;
    static int[] heart = new int[2];
    static int leftArmLen=0;
    static int rightArmLen=0;
    static int[] waistEnd = new int[2];
    static int waistLen=0;
    static int leftLegLen=0;
    static int rightLegLen=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()) +1;
        board = new String[N][N];

        for(int i = 1; i<N; i++) board[i][0] = "_"; //y
        for(int i = 0; i<N; i++) board[0][i] = "_"; //x

        for(int i = 1; i<N; i++){
            String s = br.readLine();
            String[] st = s.split("");
            for(int j = 1; j<N; j++){
                board[i][j] = st[j-1];
            }
        }

        //머리 위치를 통해 심장 찾기
        boolean find = false;
        for(int i = 1; i<N && find==false; i++){
            for(int j = 1; j<N; j++){
                if(board[i][j].equals("*")){
                    heart[0] = j;
                    heart[1] = i+1;
                    find = true;
                    break;
                }
            }
        }

        //왼쪽 팔 길이 구하기
        for(int i = heart[0]-1; i>0; i--){
            if(board[heart[1]][i].equals("*")){
                leftArmLen++;
            }else{
                break;
            }
        }

        //오른팔 길이 구하기
        for(int i = heart[0]+1; i<N; i++){
            if(board[heart[1]][i].equals("*")){
                rightArmLen++;
            }else{
                break;
            }
        }

        //허리 길이 구하기
        for(int i = heart[1]+1; i<N; i++){
            if(board[i][heart[0]].equals("*")){
                waistLen++;
            }else{
                break;
            }
        }
        waistEnd[0] = heart[0];
        waistEnd[1] = heart[1]+waistLen;


        //왼쪽 다리 길이 구하기
        for(int i = waistEnd[1]+1; i < N; i++){
            if(board[i][waistEnd[0]-1].equals("*")){
                leftLegLen++;
            }else{
                break;
            }
        }

        //오른쪽 다리 길이 구하기
        for(int i = waistEnd[1]+1; i < N; i++){
            if(board[i][waistEnd[0]+1].equals("*")){
                rightLegLen++;
            }else{
                break;
            }
        }

        bw.write(heart[1] + " " + heart[0]);
        bw.newLine();
        bw.write(leftArmLen+" ");
        bw.write(rightArmLen+" ");
        bw.write(waistLen+" ");
        bw.write(leftLegLen+" ");
        bw.write(rightLegLen+" ");

        bw.flush();

        bw.close();
        br.close();
    }
}