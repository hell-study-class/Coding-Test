package programmers;

public class CreateStrangeCharacters_12930 {
    public String solution(String s) {
        String result = "";
        String[] temp = s.split("");
        int idx = 0;
        for(int i=0; i<temp.length; i++){
            if(temp[i].equals(" ")){
                idx = 0;
            }else if(idx%2 == 0){
                temp[i] = temp[i].toUpperCase();
                idx++;
            }else if(idx%2 != 0){
                temp[i] = temp[i].toLowerCase();
                idx++;
            }
            result += temp[i];
        }
        return result;
    }
}
