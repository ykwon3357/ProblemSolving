package programmers;

import java.io.*;
import java.util.*;
import java.time.LocalTime;
public class MiddleExam2 {

	public static void main(String[] args) throws IOException {
		String[][] booked = new String[][] {{"09:10", "lee"}};
		String[][] unbooked = new String[][] {{"09:00", "kim"}, {"09:05", "bae"}};
		String[][] booked2 = new String[][] {{"09:55", "hae"}, {"10:05", "jee"}};
		String[][] unbooked2 = new String[][] {{"10:04", "hee"}, {"14:07", "eom"}};
		String[][] booked3 = new String[][] {{"09:00", "hae"}, {"09:03", "jee"}, {"09:30", "pak"}};
		String[][] unbooked3 = new String[][] {{"09:01", "bae"}, {"09:02", "eom"}, {"14:07", "son"}};
		String[][] booked4 = new String[][] {{"09:10", "hae"}};
		String[][] unbooked4 = new String[][] {{"09:00", "bae"}, {"09:02", "eom"}, {"14:07", "son"}};
		String[][] booked5 = new String[][] {{"09:00", "bae"}, {"09:02", "eom"}, {"14:07", "son"}};
		String[][] unbooked5 = new String[][] {{"09:10", "hae"}};
		String[][] booked6 = new String[][] {{"10:00", "hae"}, {"19:47", "jee"}, {"23:30", "pak"}};
		String[][] unbooked6 = new String[][] {{"09:50", "bae"}, {"09:59", "eom"}, {"23:47", "son"}};
		MiddleExam2 sol = new MiddleExam2();
		
		System.out.println(1);
		System.out.println(Arrays.toString(sol.solution2(booked, unbooked))); // [kim, lee, bae]
		System.out.println(Arrays.toString(sol.solution(booked, unbooked))); // [kim, lee, bae]
		System.out.println(2);
		System.out.println(Arrays.toString(sol.solution2(booked2, unbooked2))); // [hae, jee, hee, eom]
		System.out.println(Arrays.toString(sol.solution(booked2, unbooked2))); // [hae, jee, hee, eom]
		System.out.println(3);
		System.out.println(Arrays.toString(sol.solution2(booked3, unbooked3))); // [hae, jee, bae, pak, eom, son]
		System.out.println(Arrays.toString(sol.solution(booked3, unbooked3))); // [hae, jee, bae, pak, eom, son]
		System.out.println(4);
		System.out.println(Arrays.toString(sol.solution2(booked4, unbooked4))); // [bae, hae, eom, son]
		System.out.println(Arrays.toString(sol.solution(booked4, unbooked4))); // [bae, hae, eom, son]
		System.out.println(5);
		System.out.println(Arrays.toString(sol.solution2(booked5, unbooked5))); // [bae, eom, hae, son]
		System.out.println(Arrays.toString(sol.solution(booked5, unbooked5))); // [bae, eom, hae, son]
		System.out.println(6);
		System.out.println(Arrays.toString(sol.solution2(booked6, unbooked6))); // [bae, hae, eom, jee, pak, son]
		System.out.println(Arrays.toString(sol.solution(booked6, unbooked6))); // [bae, hae, eom, jee, pak, son]

	}
    
	public String[] solution(String[][] booked, String[][] unbooked) {
        String[] answer = {};

        ArrayList<String> answerList = new ArrayList<>();

        // DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("mm:ss");

        LocalTime now = LocalTime.of(0, 1);

        int bIdx = 0;       //   예약 손님 배열 인덱스
        int ubIdx = 0;      // 비예약 손님 배열 인덱스
        while (bIdx < booked.length || ubIdx < unbooked.length) {
            if ( bIdx < booked.length ) {
                // 1. 예약 손님 도착 여부 확인
                if (booked[bIdx][0].compareTo(now.toString()) <= 0) {
                    // 1-1. 예약 손님이 현재 와있을 경우
                    //      업무 처리
                    answerList.add(booked[bIdx][1]);
                    now = now.plusMinutes(10);
                    // System.out.println(booked[bIdx][1] + " " + now);
                    bIdx++;
                    continue;
                }
            }
 
            if ( ubIdx < unbooked.length ) {
                // 1-1. 예약 손님이 아직 없을 경우
                //      비예약손님 확인하여 진행
                if (unbooked[ubIdx][0].compareTo(now.toString()) <= 0) {
                    answerList.add(unbooked[ubIdx][1]);
                    now = now.plusMinutes(10);
                    // System.out.println(unbooked[ubIdx][1] + " " + now);
                    ubIdx++;
                    continue;                    
                }
            }

            // 1-2. 비예약손님도 없을 경우
            //      다음 예약 손님과 비예약 손님 중 더 빨리 오는 손님
            //      시간으로 이동
            if (bIdx < booked.length && ubIdx < unbooked.length) {
                if (booked[bIdx][0].compareTo(unbooked[ubIdx][0]) <= 0) {
                    // 예약 손님이 더 빨리 올 경우.
                    now = now.parse(booked[bIdx][0]);
                }

                else {
                    // 비예약 손님이 더 빨리 올 경우.
                    now = now.parse(unbooked[ubIdx][0]);
                }
            }
            else if (bIdx < booked.length) {
                now = now.parse(booked[bIdx][0]);
            }
            else {
                now = now.parse(unbooked[ubIdx][0]);
            }
        }

        answer = answerList.toArray(new String[answerList.size()]);
        return answer;
    }
    
	
	// 예약여부 : booked "0", unbooked "1"
    // 우선순위큐에 {시간, 이름, 예약여부} 예약여부 오름차순, 같을 경우 시간순
    // 대기 없으면 예약 고객, 일반 고객 비교해서 빨리온사람
    // 대기 있으면 큐에서 하나씩 빼면서 answer에 넣음
	
    public String[] solution2(String[][] booked, String[][] unbooked) {
        int bLen = booked.length;
        int ubLen = unbooked.length;
        String[] answer = new String[bLen + ubLen];
        Queue<String[]> waiting = new PriorityQueue<>((o1, o2) -> {
            int temp = o1[2].compareTo(o2[2]);
            if(temp == 0) return o1[0].compareTo(o2[0]);
            return temp;
        });

        int i=0, j=0, k=0, bTime=0, ubTime=0, endTime = 0;
        String[] temp;
        while(i<bLen && j<ubLen){
            if(waiting.isEmpty()){
                bTime = stringToTime(booked[i][0]);
                ubTime = stringToTime(unbooked[j][0]);
                if(bTime <= ubTime){
                    answer[k++] = booked[i++][1];
                    endTime = bTime + 10;
                }else{
                    answer[k++] = unbooked[j++][1];
                    endTime = ubTime + 10;
                }
            }else{
                temp = waiting.poll();
                answer[k++] = temp[1];

                endTime = Math.max(endTime, stringToTime(temp[0])) + 10;
            }
            // 2269 -> 2309
            if(endTime % 100 >= 60) endTime += 40;
            // 대기열 추가, 인덱스 업데이트
            i = addWaiting(waiting, i, bLen, booked, true, endTime);
            j = addWaiting(waiting, j, ubLen, unbooked, false, endTime);
        }

        // 나머지 처리
        while(!waiting.isEmpty()) answer[k++] = waiting.poll()[1];       
        while(i<bLen) answer[k++] = booked[i++][1];
        while(j<ubLen) answer[k++] = unbooked[j++][1];

        return answer;
    }

    // 대기열 추가 함수, 추가 후 인덱스 반환
    private int addWaiting(Queue<String[]> waiting, int idx, int len, String[][] customer, boolean booked, int endTime) {
        while(idx<len && stringToTime(customer[idx][0])<=endTime){
            waiting.offer(new String[]{customer[idx][0], customer[idx][1], booked?"0":"1"});
            idx++;
        }
        return idx;
    }

    // 09:00 -> 0900
    private int stringToTime(String time){
        return Integer.parseInt(time.replace(":",""));
    }
	
}
