package programmers;

import java.util.*;
class Hindex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<=1000; i++){
            
            for(int j=0; j<citations.length; j++){
                if(citations[j] >= i){       
                    int cnt = citations.length - j;
                    if(cnt >= i)
                        answer = Math.max(answer, i);
                    break;
                }
            }
        }
        return answer;
    }
}
