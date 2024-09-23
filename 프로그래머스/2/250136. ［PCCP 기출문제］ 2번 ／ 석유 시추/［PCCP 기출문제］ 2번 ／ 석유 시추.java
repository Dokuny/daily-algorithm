import java.util.*;

class Solution {

    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        
        int idx = 2;
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 1){
                    // BFS 계산
                    Node start = new Node(j, i);
                    q.addLast(start);
                    
                    land[i][j] = idx;
                    
                    int sum = 1;
                    
                    while(!q.isEmpty()) {
                        Node cur = q.pollFirst();
                        
                        for(int[] dir : dirs) {
                            int x = dir[0] + cur.x;
                            int y = dir[1] + cur.y;
                            
                            if(x < 0 || x >= land[0].length || y < 0 || y >= land.length) continue;
                            if(land[y][x] != 1) continue;
                            
                            land[y][x] = idx;
                            sum++;
                            
                            q.addLast(new Node(x,y));
                        }                        
                    }
                    
                    map.put(idx++, sum);
                }
            }
        }
        
        
        // 열을 돌면서 계산하기
        for(int row = 0; row < land[0].length; row++) {
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            
            for(int col = 0; col < land.length; col++) {
                if(land[col][row] != 0) {
                    int groupNum = land[col][row];
                    
                    if(set.contains(groupNum)) continue;
                    
                    sum += map.get(groupNum);
                    set.add(groupNum);
                }
            }
            
            answer = Math.max(answer, sum);
        }
                
        return answer;
    }
    
    static class Node {
        int x;
        int y;
        
        public Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}