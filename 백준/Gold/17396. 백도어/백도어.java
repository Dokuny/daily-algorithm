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

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		
		// 간접 리스트 만들기
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			if (st.nextToken().equals("0")) { // 시야가 존재하는 곳은 간선이 필요가 없음
				adjList[i] = new ArrayList<>();
			}
		}
		
		adjList[N - 1] = new ArrayList<>();
		

		// 다익스트라 - ElogV : 600000 * 16 = 960만 정도
		
		// 간선 정보 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());

			// 시야가 보이는 곳이라면 굳이 넣을 필요가 없음
			if(adjList[a] == null || adjList[b] == null) continue;
			
			adjList[a].add(new Edge(b, w));
			adjList[b].add(new Edge(a, w));
		}

		// 다익스트라 준비
		distances = new long[N];
		Arrays.fill(distances, Long.MAX_VALUE);
		distances[0] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(edge -> edge.time));

		pq.add(new Edge(0, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			// 기록된 시간보다 현재 간선 시간이 더 길면 할 필요가 없음
			if(distances[cur.to] < cur.time) continue;

			for (Edge adj : adjList[cur.to]) {
				long newTime = distances[cur.to] + adj.time;
				
				// 기존 시간보다 새로운 시간이 더 짧으면
				if (distances[adj.to] > newTime) {
					distances[adj.to] = newTime;
					pq.add(new Edge(adj.to, newTime));
				}
			}
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