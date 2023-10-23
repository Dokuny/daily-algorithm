import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			ArrayList<Dependency>[] list = new ArrayList[n + 1];
			parents = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				list[j] = new ArrayList<>();
				parents[j] = j;
			}

			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				list[b].add(new Dependency(b, a, s));
			}

			PriorityQueue<Dependency> queue = new PriorityQueue<>();
			queue.add(new Dependency(0, c, 0));

			int time = 0;
			int cnt = 0;
			while (!queue.isEmpty()) {
				Dependency cur = queue.poll();

				if (find(cur.from) == find(cur.to)) {
					continue;
				}
				time = cur.time;

				union(cur.from, cur.to);
				cnt++;

				for (Dependency dependency : list[cur.to]) {
					queue.add(new Dependency(dependency.from, dependency.to,
						time + dependency.time));
				}
			}
			sb.append(cnt).append(" ").append(time).append("\n");
		}
		System.out.println(sb);
	}

	static void union(int a, int b) {
		int aP = find(a);
		int bP = find(b);

		if (aP != bP) {
			parents[bP] = aP;
		}
	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}

	static class Dependency implements Comparable<Dependency> {

		int from;
		int to;
		int time;

		public Dependency(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Dependency o) {
			return Integer.compare(time, o.time);
		}
	}
}