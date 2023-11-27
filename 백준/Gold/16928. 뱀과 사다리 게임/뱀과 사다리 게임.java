import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] map = new int[101];

		for (int i = 0; i < map.length; i++) {
			map[i] = i;
		}

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		Queue<Pos> queue = new ArrayDeque<>();

		queue.add(new Pos(1, 0));
		map[1] = 0;
		
		while (!queue.isEmpty()) {
			Pos cur = queue.poll();
			

			// 6개의 경우의 수
			for (int i = 1; i <= 6; i++) {
				int mx = cur.x + i;

				if (mx > 100) {
					break;
				}

				if(map[mx] == 0) continue;

				if (mx == 100) {
					System.out.println(cur.cnt + 1);
					return;
				}

				// 이동
				queue.add(new Pos(map[mx], cur.cnt + 1));

				map[mx] = 0;
				map[map[mx]] = 0;
			}
		}

	}

	static class Pos {

		int x;
		int cnt;

		public Pos(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}


}

