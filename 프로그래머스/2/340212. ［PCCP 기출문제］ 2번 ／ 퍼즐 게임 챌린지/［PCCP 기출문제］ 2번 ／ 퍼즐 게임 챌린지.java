class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 이분탐색 문제 (log(DiffMax) * diffs.lengthMax  )
    
        int l = 1;
        int r = 100000;
        
        while(l < r) {
            int mid = (l+r) / 2;
            
            long time = 0L;
            
            for(int i = 1; i < diffs.length; i++) {
                long repeat = diffs[i] - mid;
                
                if(repeat > 0) {
                    time += repeat * (times[i-1] + times[i]);
                }
                
                time += times[i];
            }
            time += diffs[0] - mid > 0 ? (diffs[0] - mid) * times[0] : times[0];
            
            if(time > limit) {
                l = mid + 1;
            }else {
                r = mid;
            }
            System.out.println(time);
        }
  
        
        return l;
    }
}