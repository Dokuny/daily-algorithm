import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 북, 동, 남 , 서
	static int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		st = new StringTokenizer(br.readLine());

		Cleaner cleaner = new Cleaner(Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken()));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (true) {

			// 현재 칸이 청소되지 않은 경우, 청소
			if (map[cleaner.y][cleaner.x] == 0) {
				map[cleaner.y][cleaner.x] = 2;
				cnt++;
			}

			// 주변 4칸 확인
			int dirty = 0;

			for (int[] dir : dirs) {
				int mx = dir[0] + cleaner.x;
				int my = dir[1] + cleaner.y;

				if(mx < 0 || my < 0 || mx >= M || my >= N) continue;
				if(map[my][mx] == 0) dirty++;
			}

			// 청소되지 않은 빈 칸이 없는 경우
			if (dirty == 0) {
				// 후진하기
				int dir = (cleaner.d + 2) % 4;
				int mx = dirs[dir][0] + cleaner.x;
				int my = dirs[dir][1] + cleaner.y;

				if(mx < 0 || my < 0 || mx >= M || my >= N || map[my][mx] == 1) break;

				cleaner.x = mx;
				cleaner.y = my;
			} else {
				// 반시계 방향 90도 회전
				int dir = (cleaner.d + 3) % 4;
				cleaner.d = dir;

				int mx = cleaner.x + dirs[cleaner.d][0];
				int my = cleaner.y + dirs[cleaner.d][1];

				// 앞쪽 칸이 청소되지 않으면 전진
				if(mx < 0 || my < 0 || mx >= M || my >= N) continue;

				if (map[my][mx] == 0) {
					cleaner.x = mx;
					cleaner.y = my;
				}
			}
		}
		System.out.println(cnt);

	}

	static class Cleaner{
		int x;
		int y;
		int d;

		public Cleaner(int y, int x, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}