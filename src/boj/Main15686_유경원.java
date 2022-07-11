package boj;
import java.io.*;
import java.util.*;

public class Main15686_유경원 {
	
	static int N, M;
	static List<House> home = new ArrayList<House>(); 
	static List<House> chicken = new ArrayList<House>(); ; 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int t =Integer.parseInt(st.nextToken());
				if(t==1) home.add(new House(i,j));
				if(t==2) chicken.add(new House(i,j));
			}
		}
		
		int[] p = new int[chicken.size()];
		int cnt = 0, city, ans = Integer.MAX_VALUE;
		while(++cnt<=M) p[p.length-cnt] = 1;
		
		do {
			int[] comb = new int[M];
			for(int i=0, idx=0; i<p.length; i++) { 
				if(p[i]==1) {
					comb[idx++] = i;
				}
			}
			// 치킨 고르는 조합에 따른 치킨거리
			city = getChickenDist(comb);
			if(ans>city) ans = city;
		}while(np(p));
		
		System.out.println(ans);
		
	}
	
	// 치킨 거리 구하기
	static int getChickenDist(int[] arr) {
		
		int sumD = 0;
		for(int i=0; i<home.size(); i++) {
			int minD = Integer.MAX_VALUE;
			House homeTemp = home.get(i);
			for(int j=0; j<arr.length; j++) { // 집에서 가장 가까운 치킨집과의 거리 구하기
				int d = getDistance(homeTemp, chicken.get(arr[j]));
				if(minD>d) minD = d;
			}
			sumD += minD;
		}
		return sumD;
		
	}
	
	// 거리 구하기
	static int getDistance(House a, House b) {
		return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
	}
	
	// 넥퍼
	static boolean np(int[] numbers) {
		
		int N = numbers.length;
		
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false;
		
		int j = N-1;
		while(numbers[i-1]>=numbers[j]) --j;
		
		swap(numbers, i-1, j);
		
		int k = N-1;
		while(i<k) swap(numbers, i++, k--);
		
		return true;
	}
	
	// 스왑
	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}

class House{
	int x; int y;
	public House(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}