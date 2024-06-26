import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        recursive(N,N,bw);

        bw.flush();

        bw.close();
        bw.close();
    }

    public static void recursive(int N, int n, BufferedWriter bw) throws IOException{

        StringBuilder snake = new StringBuilder();
        for(int i = 0; i < N-n; i++){
            snake.append("____");
        }

        bw.write(snake+"\"재귀함수가 뭔가요?\"\n");
        bw.write(snake+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        bw.write(snake+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        bw.write(snake+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        if(n-1>0) recursive(N, n-1, bw);
        else if(n-1==0){
            StringBuilder snake1 = new StringBuilder();
            for(int i = 0; i < N-n+1; i++){
                snake1.append("____");
            }
            bw.write(snake1+"\"재귀함수가 뭔가요?\"\n");
            bw.write(snake1+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            bw.write(snake1+"라고 답변하였지.\n");
        }

        bw.write(snake+"라고 답변하였지.\n");
    }
}