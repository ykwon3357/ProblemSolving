package programmers;
import java.util.*;
public class 주식가격 {
	
	public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                answer[i]++;
                if(prices[i] > prices[j]) break;
            }
        }
        return answer;
    }
	
	public int[] solution2(int[] prices) {
        int plen = prices.length;
        int answer[] = new int[plen], temp[] = null;
        Stack<int[]> s = new Stack<>();
        for(int i=0; i<plen; i++){
            while(!s.isEmpty() && s.peek()[0] > prices[i]){
                temp = s.pop();
                answer[temp[1]] = i - temp[1];
            }
            s.push(new int[]{prices[i], i});
        }
        while(!s.isEmpty()){
            temp = s.pop();
            answer[temp[1]] = plen - 1 - temp[1];
        }
        return answer;
    }

}
