package groom;

import java.io.*;
import java.util.*;
public class 주파수_망가트리기 {
	// 주파수번호 x 마을번호 행렬
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int u = 0, maxWaveNum = 0, waveNum = 0;
		int[][] map = new int[101][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			for(int j=0; j<u; j++) {
				waveNum = Integer.parseInt(st.nextToken());
				map[waveNum][i]++;
				if(maxWaveNum < waveNum) maxWaveNum = waveNum;
			}
		}
		int maxWaveCnt = 0, waveCnt = 0, maxWaveCntNum = 0, answer = 0;
		boolean flag = false;
		while(true) {
			maxWaveCnt = 0; maxWaveCntNum = 0; flag = false;
			for(int i=1; i<=maxWaveNum; i++) {
				waveCnt = 0;
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1) {
						waveCnt++;
						flag = true;
					}
				}
				if(maxWaveCnt < waveCnt) {
					maxWaveCnt = waveCnt;
					maxWaveCntNum = i;
				}
			}
			if(!flag) break;
			
			for(int j=0; j<N; j++) {
				if(map[maxWaveCntNum][j] == 1) {
					for(int i=1; i<=maxWaveNum; i++) {
						map[i][j] = 0;
					}
				}
			}
			answer++; 
		}
		System.out.println(answer);

	}

}
