package programmers;

import java.util.*;

public class 다리를지나는트럭 {
	public static void main(String[] args) {
		다리를지나는트럭 sol = new 다리를지나는트럭();
		
		System.out.println(sol.solution(2, 10, new int[] {7,4,5,6}));
		System.out.println(sol.solution(100, 100, new int[] {10}));
		System.out.println(sol.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> waiting = new ArrayDeque<>();
        for(int truck : truck_weights){
            waiting.offer(truck);
        }
        Queue<int[]> bridge = new ArrayDeque<>();

        int weightSum = 0, truck = 0, temp[] = null, time = 0, truckTime = 0;
        
        while(time==0 || !bridge.isEmpty()){
            if(weightSum + waiting.peek() <= weight && bridge.size() < bridge_length){
                truck = waiting.poll();
                weightSum += truck;
                bridge.offer(new int[]{truck, time});
            }
            
            temp = bridge.peek();
            truck = temp[0];
            truckTime = temp[1];
            if(time - truckTime == bridge_length){
                bridge.poll();
                weightSum -= truck;
            }
            
            time++;
        }
        return time;
    }
}
