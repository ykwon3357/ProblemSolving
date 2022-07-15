package groom;

import java.io.*;
import java.util.*;

public class 주파수_망가트리기 {
	// solve : 주파수번호 x 마을번호 행렬 만들어서
	// 제일 많은 마을에 있는 주파수 부터 망가뜨리기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int u = 0, maxWaveNum = 0, waveNum = 0;
		int[][] map = new int[101][N]; // 주파수번호 x 마을번호 행렬
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			for (int j = 0; j < u; j++) {
				waveNum = Integer.parseInt(st.nextToken());
				map[waveNum][i]++; // 해당 주파수가 있는 마을 1로
				if (maxWaveNum < waveNum) maxWaveNum = waveNum;
			}
		}
		int maxWaveCnt = 0, waveCnt = 0, maxWaveCntNum = 0, answer = 0;
		boolean flag = false;
		while (true) { // 모든 마을 0 될때까지 다음과정 반복 : 제일 많은 마을에 있는 주파수 찾고 해당 마을에 있는 주파수 0으로
			maxWaveCnt = 0;
			maxWaveCntNum = 0;
			flag = false;
			for (int i = 1; i <= maxWaveNum; i++) {
				waveCnt = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						waveCnt++; // 주파수 카운트
						flag = true; // 모든 마을 0 될때 체크하기 위함
					}
				}
				if (maxWaveCnt < waveCnt) { // 가장 많은 마을에 있는 주파수 찾기
					maxWaveCnt = waveCnt;
					maxWaveCntNum = i;
				}
			}
			if (!flag)
				break; // 모든 마을 0이면 반복 종료

			for (int j = 0; j < N; j++) {
				if (map[maxWaveCntNum][j] == 1) { // 가장 많은 마을에 있는 주파수 찾고 해당 마을 주파수 모두 0 으로
					for (int i = 1; i <= maxWaveNum; i++) {
						map[i][j] = 0;
					}
				}
			}
			answer++; // 위 과정 반복횟수
		}
		System.out.println(answer);

	}
}
