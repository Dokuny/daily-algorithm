import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

class Solution {


	public static void main(String[] args) {
//		solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}});
		solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}});
	}
	public static int[] solution(int[][] edges) {

		// 노드 수 계산
		HashMap<Integer, List<Integer>> out = new HashMap<>();
		HashMap<Integer, List<Integer>> in = new HashMap<>();

		int maxNode = 0;
		for (int[] edge : edges) {
			if (!out.containsKey(edge[0])) {
				ArrayList<Integer> newList = new ArrayList<>();
				newList.add(edge[1]);
				out.put(edge[0], newList);
			} else {
				out.get(edge[0]).add(edge[1]);
			}

			if (!in.containsKey(edge[1])) {
				ArrayList<Integer> newList = new ArrayList<>();
				newList.add(edge[0]);
				in.put(edge[1], newList);
			} else {
				in.get(edge[1]).add(edge[0]);
			}

			maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
		}

		// 정점 노드
		int centerNode = -1;

		// 진입 차수가 0이고, 진출 차수가 2 이상인 경우
		for (Integer node : out.keySet()) {
			if (out.get(node).size() >= 2 && !in.containsKey(node)) {
				centerNode = node; // 정점 노드 찾기
				break;
			}
		}

		// 나머지 노드들 돌면서 형태 구하기

		boolean[] visited = new boolean[maxNode + 1];

		int donutCnt = 0;
		int stickCnt = 0;
		int eightCnt = 0;

		for (Integer node : out.get(centerNode)) {
			int edgeCnt = 0;
			int nodeCnt = 0;

			if (visited[node]) {
				continue;
			}

			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(node);

			while (!queue.isEmpty()) {
				Integer curNode = queue.poll();

				if (visited[curNode]) {
					continue;
				}

				visited[curNode] = true;
				nodeCnt++;

				if(!out.containsKey(curNode)) continue;
				for (Integer adjNode : out.get(curNode)) {
					edgeCnt++;
					if (visited[adjNode]) {
						continue;
					}

					queue.add(adjNode);
				}
			}

			// 판단하기
			// 도넛 - n개 정점, 간선
			// 막대 - n개 정점, n-1 간선
			// 8자 - 2n + 1 정점, 2n+2 간선
			if (edgeCnt == nodeCnt) {
				donutCnt++;
			} else if (nodeCnt == edgeCnt + 1) {
				stickCnt++;
			} else if(nodeCnt == edgeCnt - 1){
				eightCnt++;
			}
		}

		visited[centerNode] = true;
		visited[0] = true;
		

		return new int[]{centerNode, donutCnt, stickCnt, eightCnt};
	}
}