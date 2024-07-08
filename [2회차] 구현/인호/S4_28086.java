import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main{

    static int num1;
    static int num2;
    static String operator;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> input = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(),"*-/+",true);

        while(st.hasMoreTokens()){
            input.add(st.nextToken());
        }
        for(String s: input){
            System.out.println(s);
        }

        if(input.size() == 5){
            num1 = Integer.parseInt(input.get(0) + input.get(1));
            num2 = Integer.parseInt(input.get(3) + input.get(4));
            operator = input.get(2);
        }else if(input.size() == 4){
            if(input.get(0).equals("-")){
                num1 = Integer.parseInt(input.get(0) + input.get(1));
                num2 = Integer.parseInt(input.get(3));
                operator = input.get(2);
            }
            else if(input.get(2).equals("-")){
                num1 = Integer.parseInt(input.get(0));
                num2 = Integer.parseInt(input.get(2) + input.get(3));
                operator = input.get(1);
            }
        }else if(input.size() == 3){
            num1 = Integer.parseInt(input.get(0));
            num2 = Integer.parseInt(input.get(2));
            operator = input.get(1);
        }else{
            bw.write("invalid");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        num1 = toDecimal(num1);
        num2 = toDecimal(num2);


        String result = operating(num1,num2,operator);


        if(result.equals("invalid")){
            bw.write("invalid");
        }else{
            String tResult = toOctal(Integer.parseInt(result));
            bw.write(tResult);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int toDecimal(int n){
        if (n == 0) {
            return 0;
        }
        int state = 0;
        int nstate = 1;
        int decimal = 0;
        if(n<0){
            nstate = -1;
            n = n*-1;
        }
        while(n > 0){
            decimal += (int) n%10*(Math.pow(8,state));
            n /= 10;
            state++;
        }
        return decimal*nstate;
    }

    public static String toOctal(int n){
        if (n == 0) {
            return "0";
        }
        String octal = "";
        int nstate = 1;
        if(n<0){
            nstate = -1;
            n = n*-1;
        }
        while(n > 0 ){
            octal = String.valueOf(n%8)+octal;
            n= n/8;
        }
        if(nstate == -1){
            return "-"+octal;
        }
        else{
            return octal;
        }
    }

    public static String operating(int n1, int n2, String operator){
        String result ="";

        switch (operator){
            case "+":
                result = String.valueOf(n1+n2);
                break;
            case "-":
                result = String.valueOf(n1-n2);
                break;
            case "/":
                if(n2 != 0){
                    if(n1*n2 <0){
                        result = String.valueOf((int) Math.floor((double) n1/n2));
                    }else if(n1*n2 >=0){
                        result = String.valueOf((int) Math.ceil((double) n1/n2));
                    }
                }else{
                    result ="invalid";
                }
                break;
            case "*":
                result = String.valueOf(n1*n2);
                break;
        }
        return result;
    }
}