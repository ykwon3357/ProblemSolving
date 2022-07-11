package programmers;

import java.util.*;
public class 가장큰수 {
	// 테케 2.9초까지 소요됨
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) strNums[i] = numbers[i]+"";
        Arrays.sort(strNums, (o1, o2) -> {
            String v1 = o1+o2; String v2 = o2+o1;
            return v2.compareTo(v1);
        });
        for(String s : strNums) answer += s;
        if(answer.startsWith("0")) return "0";
        return answer;
    }
        
    // 개선버전 StringBuilder 사용
    // 170ms
    public String solution2(int[] numbers) {
        String[] strNums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) strNums[i] = numbers[i]+"";

        Arrays.sort(strNums, (o1, o2) -> (o2+o1).compareTo(o1+o2) );
        if(strNums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : strNums) sb.append(s);
        return sb.toString();
    }
}
