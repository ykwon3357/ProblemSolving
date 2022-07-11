package boj;
import java.io.*;
import java.util.*;

public class Main3109_유경원 {
	/*
	 * dfs로 파이프라인을 설치한다
	 * 설치 완료시 flag를 true하고 리턴한다
	 * 첫 열 모든행에서 반복 후 flag가 true면 파이프라인 수++
	 */
	static int R, C;
	static char[][] map;
	static boolean flag; // 마지막열 까지 파이프라인 설치여부
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		
		for(int i=0; i<R; i++) 
			map[i] = br.readLine().toCharArray();
		
		int result = 0; // 파이프라인 개수
        for (int i = 0; i < R; i++) { // 첫 열 모든 행에서 설치하기
        	flag = false;
            dfs(i, 0);
            if(flag) result++; // 마지막 열 도착시 flag true
        }
		System.out.println(result);
	}
	
	static void dfs(int x, int y) {
        if (x <= -1 || x >= R) return;
        
        if (map[x][y] == '.') { // 빈칸이면
        	map[x][y] = 'p'; // 파이프라인 설치
        	if (y == C-1) { // 마지막 열 도착하면 flag true하고 종료
        		flag = true;
        		return;
        	}
        	if(!flag) dfs(x - 1 , y + 1); // 오른쪽 위
            if(!flag) dfs(x , y + 1); // 오른쪽
            if(!flag) dfs(x + 1, y + 1); // 오른쪽 아래
        }
        return;
    }
}
