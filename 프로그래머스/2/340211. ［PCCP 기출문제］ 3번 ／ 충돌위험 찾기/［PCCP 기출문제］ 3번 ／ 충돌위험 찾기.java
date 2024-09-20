import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {  
        PriorityQueue<Pos> pq = new PriorityQueue<Pos>();
        
        for(int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            
            int time = 0;
            for(int k = 0; k < route.length - 1; k++) {
                int[] start = points[route[k] - 1];
                int[] end = points[route[k+1] - 1];

                boolean isUpdown = false;
                // 경로 계산, r부터
                if(start[0] > end[0]) {
                    // 상하이동 먼저
                    for(int j = k == 0 ? start[0] : start[0] - 1; j >= end[0]; j--){
                        pq.add(new Pos(time++, j, start[1]));
                    }
                    isUpdown = true;

                }else if(start[0] < end[0]){
                    // 상하이동 먼저
                    for(int j = k == 0 ? start[0] : start[0] + 1; j <= end[0]; j++){
                        pq.add(new Pos(time++, j, start[1]));
                    }
                    isUpdown = true;
                }

                // 좌우이동 체크
                if(start[1] > end[1]) {
                    // 상하이동 먼저
                    for(int j = isUpdown || k != 0 ? start[1] - 1 : start[1]; j >= end[1]; j--){
                        pq.add(new Pos(time++, end[0], j));
                    }

                }else if(start[1] < end[1]){
                    // 상하이동 먼저
                    for(int j = isUpdown || k != 0 ? start[1]+1 : start[1]; j <= end[1]; j++){
                        pq.add(new Pos(time++, end[0], j));
                    }
                }
            }
          
        }
        
        Pos standard = pq.poll();
        
        int collisionCnt = 0;
        boolean isCollision = false;
        
        while(!pq.isEmpty()){
            // 비교
            Pos cur = pq.poll();
            
            // 시간 비교
            if(standard.time != cur.time) {
                standard = cur;
                isCollision = false;
                continue;
            }
            
            // 위치 비교
            if(standard.r != cur.r || standard.c != cur.c) {
                standard = cur;
                isCollision = false;
                continue;
            }
            
            if(standard.r == cur.r && standard.c == cur.c && !isCollision) {
                collisionCnt++;
                isCollision = true;
            }

        }
          
        return collisionCnt;
    }
    
    static class Pos implements Comparable<Pos>{
        int time;
        int r;
        int c;
        
        Pos(int time, int r, int c){
            this.time = time;
            this.r = r;
            this.c = c;
        }
        
        public int compareTo(Pos o){
            if(this.time == o.time){
                if(o.r == this.r) {
                    return this.c - o.c;
                }else {
                    return this.r - o.r;
                }
            }else {
                return this.time - o.time;
            }
        }    
    }
}