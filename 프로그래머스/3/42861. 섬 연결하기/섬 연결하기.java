import java.util.Arrays;
import java.util.Comparator;

class Solution {

	static int[] parents;

	public int solution(int n, int[][] costs) {

		parents = new int[n];

		for(int i = 0; i < n ; i++){
			parents[i] = i;
		}

		Arrays.sort(costs, Comparator.comparingInt(cost -> cost[2]));
		
		int answer = 0;
		
		for (int i = 0; i < costs.length; i++) {
			if (find(costs[i][0]) != find(costs[i][1])) {
				union(costs[i][0], costs[i][1]);
				answer += costs[i][2];
			}
		}
		return answer;
	}

	public int find(int idx){
		if(parents[idx] == idx) {
			return idx;
		}
		return parents[idx] = find(parents[idx]);
	}

	public void union(int nodeA, int nodeB){

		int parentA = find(nodeA);
		int parentB = find(nodeB);

		if(parentA != parentB){
			parents[parentA] = parentB;
		}
	}
}
