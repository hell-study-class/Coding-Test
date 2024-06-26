import java.util.*;

class Solution {
    StringBuilder rs = new StringBuilder();

    Map<String, Integer> map = Map.of(
        "zero",0,
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight",8,
        "nine", 9
    );

    public int solution(String s) {
        StringBuilder word = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){         // 숫자일 경우, 바로 결과 값에 저장
                rs.append(s.charAt(i));
            }else{                                      // 숫자가 아닐 경우, word에 저장
                word.append(s.charAt(i));

                if(map.containsKey(word.toString())){   // 저장 후, map에 포함되면 value 추출 후 word 초기화
                    rs.append(map.get(word.toString()).toString());
                    word.setLength(0);
                }
            }
        }

        return Integer.parseInt(rs.toString());
    }
}