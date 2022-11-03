package programmers;
import java.util.*;
public class N으로표현 {
	public int solution(int N, int number) {
        if(N == number) return 1;
        
        List<Set<Integer>> setList = new ArrayList<>();
        for(int i=0; i<9; i++){
            setList.add(new HashSet<>());
        }
        setList.get(1).add(N);
        for(int i=2; i<9; i++){
            for(int j=1; j<=i/2; j++){
                unionSet(setList.get(i), setList.get(i-j), setList.get(j));
                unionSet(setList.get(i), setList.get(j), setList.get(i-j));
            }
            int num = 0;
            for(int k=0; k<i; k++){
               num += N * Math.pow(10, k);
            }
            setList.get(i).add(num);
            for(int target : setList.get(i)){
                if(target == number){
                    return i;
                }
            }
        }
        
        return -1;
    }
    private void unionSet(Set<Integer> union, Set<Integer> a, Set<Integer> b){
        for(int n1 : a){
            for(int n2 : b){
                union.add(n1 + n2);
                union.add(n1 * n2);
                union.add(n1 - n2);
                if(n2 > 0)
                    union.add(n1 / n2);
            }
        }
    }

}
