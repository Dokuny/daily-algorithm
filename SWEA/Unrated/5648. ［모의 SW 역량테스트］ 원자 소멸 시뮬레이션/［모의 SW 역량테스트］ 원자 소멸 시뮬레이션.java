import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {

			int answer = 0;

			int N = Integer.parseInt(br.readLine()); // 원자들의 수

			Atom[] atoms = new Atom[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				atoms[i] = new Atom(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}

					// 각 노드 별 거리 계산하기
					Atom a = atoms[i];
					Atom b = atoms[j];

					// 같은 방향일 경우
					if (a.dir == b.dir) {
						continue;
					}

					// 마주칠 수 있는지 판단
					int diffX1 = Math.abs(a.x - b.x);
					int diffY1 = Math.abs(a.y - b.y);

					int diffX2 = Math.abs((a.x + dirs[a.dir][0]) - (b.x + dirs[b.dir][0]));
					int diffY2 = Math.abs((a.y + dirs[a.dir][1]) - (b.y + dirs[b.dir][1]));

					int diff = diffX1 + diffY1;

					// 제외되는 경우
					// 1. 반대 방향인데 높낮이가 다른 경우
					if (reverseDir(a.dir) == b.dir) {
						if(a.x != b.x && a.y != b.y) continue;
					}
					// 2. 진행 시 차이가 증가하는 경우
					if (diff < diffX2 + diffY2) {
						continue;
					}
					// 3. 차이가 매번 똑같은데 마주보는 방향이 아닌 경우
					if(diff == diffX2 + diffY2 && reverseDir(a.dir) != b.dir) continue;

					// 4. 방향이 다른데 차이가 각각 다른 경우
					if(reverseDir(a.dir) != b.dir && diffX1 != diffY1) continue;
					
					pq.add(new Node(i, j, diff));
				}

			}

			// 언제 부딪혔는지 체크
			int[] nums = new int[N];

			while (!pq.isEmpty()) {
				Node cur = pq.poll();

				if(atoms[cur.a] == null && atoms[cur.b] == null) continue;

				if (atoms[cur.a] != null && atoms[cur.b] != null) {
					answer += atoms[cur.a].energy + atoms[cur.b].energy;
					atoms[cur.a] = null;
					atoms[cur.b] = null;

					nums[cur.a] = cur.time;
					nums[cur.b] = cur.time;
					continue;
				}

				// b만 방문한 경우
				if (atoms[cur.a] != null) {
					if(cur.time != nums[cur.b]) continue;
					answer += atoms[cur.a].energy;
					atoms[cur.a] = null;
					nums[cur.a] = cur.time;
				}

				if (atoms[cur.b] != null) {
					if(cur.time != nums[cur.a]) continue;
					answer += atoms[cur.b].energy;
					atoms[cur.b] = null;
					nums[cur.b] = cur.time;
				}
			}


			sb.append("#").append(test_case).append(" ").append(answer).append("\n");

		}
		System.out.println(sb);
	}

	static int reverseDir(int num) {
		switch (num) {
			case 0:
				return 1;
			case 1:
				return 0;
			case 2:
				return 3;
			case 3:
				return 2;
		}
		return 0;
	}

	static class Node implements Comparable<Node> {

		int a;
		int b;
		int time;

		public Node(int a, int b, int time) {
			this.a = a;
			this.b = b;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(time, o.time);
		}
	}

	static class Atom {

		int x;
		int y;
		int dir;
		int energy;

		public Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
	}
}