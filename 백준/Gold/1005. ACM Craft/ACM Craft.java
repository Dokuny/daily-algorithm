import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adjList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int test_case = 0; test_case < T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 건물 개수
			int N = Integer.parseInt(st.nextToken());
			// 건설순서 개수
			int K = Integer.parseInt(st.nextToken());

			int[] times = new int[N+1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}

			adjList = new ArrayList[N+ 1];
			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<Integer>();
			}

			int[] indegree = new int[N + 1];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				indegree[to]++;
				adjList[from].add(to);
			}

			int W = Integer.parseInt(br.readLine());

			if (indegree[W] == 0) {
				sb.append(times[W]).append("\n");
				continue;
			}

			PriorityQueue<Building> queue = new PriorityQueue<>(
				Comparator.comparingInt(building -> building.time));

			// 인디그리가 0인 노드 찾기
			for (int i = 1; i <= N; i++) {
				if (indegree[i] == 0) {
					queue.add(new Building(times[i], i));
				}
			}

			boolean isFinished = false;
			// 위상정렬 실시
			while (!queue.isEmpty() && !isFinished) {
				Building cur = queue.poll();

				// 인접 노드 가져오기
				for (Integer no : adjList[cur.no]) {
					indegree[no]--;

					if (indegree[no] == 0) {
						int newTime = cur.time + times[no];
						queue.add(new Building(newTime, no));

						if (W == no) {
							sb.append(newTime).append("\n");
							isFinished = true;
							break;
						}

					}
				}
			}
		}

		System.out.println(sb);
	}

	static class Building {

		int time;
		int no;

		public Building(int time, int no) {
			this.time = time;
			this.no = no;
		}
	}


}
