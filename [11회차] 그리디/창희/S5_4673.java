package day11;

public class S5_4673 {
    static boolean[] arr = new boolean[10001];
    public static void main(String[] args) {

        int[] self_numbers = {1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97};
        arr[0] = true;

        for(int i=1; i<10000; i++){
            calculate(i);
        }
        for(int i = 1; i < arr.length; i++){
            if(!arr[i]) {
                System.out.println(i);
            }
        }
    }
    public static void calculate(int num){
        int sum = num;
        while(num > 0 && sum < arr.length){
            sum += num % 10;
            num /= 10;
        }
        if(sum > arr.length -1) return;
        arr[sum] = true;
    }
}
