package groom;

import java.io.*;
import java.util.*;

public class 사탕_가져가기 {
	// solve 
	// 	 1 2 3 4 5 6 7 8 9 10
	// a w w w   w   w   w  
	// b       w   w   w   w
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int candy = 0, A = 0, B = 0;
		for(int i=0; i<T; i++){
			candy = Integer.parseInt(st.nextToken());
			if(candy < 4 || candy%2 == 1){
				A++;
			}else{
				B++;
			}
		}
		
		System.out.println((A==B)?"tie":Math.max(A, B));
	}
}
