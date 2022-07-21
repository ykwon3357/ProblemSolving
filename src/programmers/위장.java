package programmers;

import java.util.*;
public class 위장 {
	
    public static void main(String[] args) {
		위장 sol = new 위장();
		String[][] clothes = new String[][] {{"yh", "hg"}, {"bsg", "ew"}, {"gt", "hg"}};
		System.out.println(sol.solution(clothes));
		
		String[][] clothes2 = new String[][] {{"yh", "hg"}};
		System.out.println(sol.solution(clothes2));
	}
        
    // 의상 종류별 안 입는 경우 포함한 경우의 수 구하고, 모두 안 입는 경우 빼기
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) map.put(cloth[1], map.getOrDefault(cloth[1],0)+1); // 의상 종류별 카운트

        int answer = 1;
        for(int value : map.values()) answer *= (value + 1); // 종류별 안 입는 경우 포함

        return answer - 1; // 모두 안 입는 경우 빼기
    }
}
