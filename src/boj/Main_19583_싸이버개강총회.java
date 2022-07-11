package boj;

import java.io.*;
import java.util.*;

public class Main_19583_싸이버개강총회 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Map<String,Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		String [] times = br.readLine().split(" ");
		
		String input = "";
		
		while ( (input=br.readLine()) !=null) {
			st=new StringTokenizer(input);
			
			String time=st.nextToken();
			String name=st.nextToken();
			
			if(time.compareTo(times[0])<=0 ){// 개총 시작 전 입장
				map.put(name,1);
			}
			
			if(time.compareTo(times[1])>=0&&time.compareTo(times[2])<=0) {// 퇴장
				if(map.containsKey(name)) set.add(name);
			}
		}
		System.out.println(set.size());
	}
}
