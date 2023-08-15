import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	static ArrayList<Edge>[] adjList;
	static long[] distances;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 시야 배열 초기화
		st = new StringTokenizer(br.readLine());
		boolean[] inSight = new boolean[N];
		for (int i = 0; i < N; i++) {
			inSight[i] = st.nextToken().equals("1");
		}
		inSight[N - 1] = false; // 넥서스는 시야가 보이더라도 갈 수 있으므로 제외

		// 다익스트라 - ElogV : 600000 * 16 = 960만 정도

		// 인접 리스트 작성
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 간선 정보 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// 시야가 보이는 곳이라면 굳이 넣을 필요가 없음
			if(inSight[a] || inSight[b]) continue;

			// 한쪽이 시작 노드라면 시작 노드는 양방향 X
			if (a == 0) {
				adjList[a].add(new Edge(b, w));
				continue;
			} else if (b == 0) {
				adjList[b].add(new Edge(a, w));
				continue;
			}

			// 한쪽이 도착 노드라면 도착 노드 양방향 X
			if (a == N - 1) {
				adjList[b].add(new Edge(a, w));
				continue;
			} else if (b == N - 1) {
				adjList[a].add(new Edge(b, w));
				continue;
			}

			// 그 외에는 양방향
			adjList[a].add(new Edge(b, w));
			adjList[b].add(new Edge(a, w));
		}

		// 다익스트라 준비
		visited = new boolean[N];
		distances = new long[N];
		Arrays.fill(distances, Long.MAX_VALUE);
		distances[0] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(edge -> edge.time));

		pq.add(new Edge(0, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if(visited[cur.to]) continue;

			visited[cur.to] = true;

			for (Edge adj : adjList[cur.to]) {
				if(visited[adj.to]) continue;

				distances[adj.to] = Math.min(distances[adj.to], distances[cur.to] + adj.time);

				pq.add(new Edge(adj.to, distances[adj.to]));
			}

			adjList[cur.to] = null;
		}

		System.out.println(distances[N - 1] == Long.MAX_VALUE ? -1 : distances[N - 1]);

	}

	static class Edge {

		int to;
		long time;

		public Edge(int to, long time) {
			this.to = to;
			this.time = time;
		}
	}

}