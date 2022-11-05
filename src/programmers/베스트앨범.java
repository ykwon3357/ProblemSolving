import java.util.*;
import java.util.Map.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreCntMap = new HashMap<>();
        Map<String, Queue<int[]>> genreNumMap = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            String gen = genres[i];
            int play = plays[i];
            genreCntMap.put(gen, genreCntMap.getOrDefault(gen, 0) + play);
            if(genreNumMap.get(gen)!=null){
                Queue<int[]> pq = genreNumMap.get(gen);
                pq.offer(new int[]{i, play});
                genreNumMap.put(gen, pq);
            }else{
                Queue<int[]> pq = new PriorityQueue<>((a,b)-> (b[1] == a[1])? a[0] - b[0] : b[1] - a[1]);
                pq.offer(new int[]{i, play});
                genreNumMap.put(gen, pq);
            }
        }
        List<Entry<String, Integer>> entryList = new ArrayList<>(genreCntMap.entrySet());
        Collections.sort(entryList, (a, b) ->b.getValue() - a.getValue());
        List<Integer> ansList = new ArrayList<>();
        for(Entry<String, Integer> entry : entryList){
            String gen = entry.getKey();
            Queue<int[]> pq = genreNumMap.get(gen);
            for(int i=0; i<2; i++){
                if(!pq.isEmpty()){
                    int[] temp = pq.poll();    
                    ansList.add(temp[0]);
                }
            }
        }
        int[] answer = new int[ansList.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = ansList.get(i);
        }

        return answer;
    }
}
