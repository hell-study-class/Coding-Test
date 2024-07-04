package programmers;

public class PushKeypad_67256 {
    public String solution(int[] numbers, String hand) {
        String result = "";
        int left = 10; // *
        int right = 12; // #

        for(int i : numbers){
            if(i == 0){
                i = 11;
            }
            if((i % 3) == 1){
                result += "L";
                left = i;
            }else if((i % 3) == 0){
                result += "R";
                right = i;
            }else{
                System.out.println("i = " + i);
                int dl = distance(left, i);
                System.out.println("left = " + left + ", dl = "+ dl);
                int dr = distance(right, i);
                System.out.println("right = " + right + ", dr = "+ dr);
                if(dl == dr){
                    if(hand.equals("right")){
                        result += "R";
                        right = i;
                    }else if(hand.equals("left")){
                        result += "L";
                        left = i;
                    }
                }else if(dl > dr){
                    System.out.println("R");
                    result += "R";
                    right = i;
                }else{
                    System.out.println("L");
                    result += "L";
                    left = i;
                }
            }
        }
        return result;
    }
    public static int distance(int t, int i){
        int lx = t % 3;
        int ly = (t / 3) + 1;
        if(t % 3 == 0){
            ly -= 1;
        }
        int x = i % 3;
        int y = (i / 3)+1;
        if(lx == 0){
            lx = 3;
        }
        if(x == 0){
            x = 3;
        }
        System.out.println("dx = " + lx + ", dy = " + ly);
        return Math.abs(lx-x) + Math.abs(ly-y);
    }
}
