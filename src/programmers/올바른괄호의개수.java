package programmers;

import java.util.*;

public class 올바른괄호의개수 {

	public static void main(String[] args) {
		올바른괄호의개수 sol = new 올바른괄호의개수();
		
		System.out.println(sol.solution(3));

	}
	// 카탈란 수의 법칙
	public int solution(int n) {

        long a = 2*n, b = n, c = 1, d = 1;
        for(int i=0; i<n; i++){
            c *= a--; 
            d *= b--;
        }
        
        return (int)(c/d)/(n+1);
    }
}
