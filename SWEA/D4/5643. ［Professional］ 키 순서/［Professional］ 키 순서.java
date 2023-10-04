import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 정방향 위상 정렬 + 역방향 위상 정렬 하기
 */
public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			int[] indegree = new int[N + 1];
			int[] outdegree = new int[N + 1];

			ArrayList<Integer>[] inAdjList = new ArrayList[N + 1];
			ArrayList<Integer>[] outAdjList = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++) {
				inAdjList[i] = new ArrayList<>();
				outAdjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				// a < b
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				indegree[b]++;
				inAdjList[a].add(b);

				outdegree[a]++;
				outAdjList[b].add(a);
			}

			HashSet<Integer>[] inSet = topologySort(N, indegree, inAdjList);
			HashSet<Integer>[] outSet = topologySort(N, outdegree, outAdjList);

			int answer = 0;

			for (int i = 1; i <= N; i++) {
				if (inSet[i].size() + outSet[i].size() - 1 == N) {
					answer++;
				}
			}

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static HashSet<Integer>[] topologySort(int N, int[] degree, ArrayList<Integer>[] adjList) {
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		HashSet<Integer>[] cnt = new HashSet[N + 1];
		for (int i = 1; i <= N; i++) {
			cnt[i] = new HashSet<>();
		}

		while (!queue.isEmpty()) {
			Integer node = queue.poll();

			cnt[node].add(node);

			for (Integer adjNode : adjList[node]) {

				cnt[adjNode].addAll(cnt[node]);

				if (--degree[adjNode] == 0) {
					queue.add(adjNode);
				}
			}
		}

		return cnt;
	}


}