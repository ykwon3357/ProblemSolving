package programmers;

import java.util.*;
class 입국심사 {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        long l = 0, r = (long)n*times[times.length-1], m = 0, res = 0, ans = Long.MAX_VALUE;
        
        while(l<=r){
            m = (l+r)/2;
            res = 0;
            for(int time : times){
                res += m/time;
                if(res > n) break;
            }
            if(res >= n){
                r = m - 1;
                ans = Math.min(ans , m);
            }else{
                l = m + 1;
            }
        }
        
        return ans;
    }
}
