import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][][] tetris = {
		{{3, 0}, {2, 0}, {1, 0}, {0, 0}}, {{0, 3}, {0, 2}, {0, 1}, {0, 0}},
		{{1, 1}, {1, 0}, {0, 1}, {0, 0}},
		{{1, 2}, {0, 2}, {0, 1}, {0, 0}}, {{-1, 2}, {0, 2}, {0, 1}, {0, 0}},
		{{2, 0}, {0, 1}, {1, 0}, {0, 0}}, {{2, 1}, {1, 1}, {0, 1}, {0, 0}},
		{{0,2},{1,0},{0,1},{0,0}},{{1,2},{1,1},{1,0},{0,0}},
		{{2,1},{2,0},{1,0},{0,0}} , {{2,-1},{2,0},{1,0},{0,0}},
		{{1,2}, {1,1},{0,1},{0,0}} , {{-1,2},{-1,1},{0,1},{0,0}},
		{{2,1},{1,1},{1,0},{0,0}} , {{2,-1},{1,-1},{1,0},{0,0}},
		{{2,0},{1,-1},{1,0},{0,0}}, {{2,0},{1,1},{1,0},{0,0}},
		{{0,2},{1,1},{0,1},{0,0}}, {{0,2},{-1,1},{0,1},{0,0}}
	};


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				for (int[][] block : tetris) {
					int sum = 0;

					boolean isPossible = true;
					for (int[] position : block) {
						int mx = j + position[0];
						int my = i + position[1];

						if(mx < 0 || my < 0 || mx >= M || my >= N) {
							isPossible = false;
							break;
						}

						sum += map[my][mx];
					}

					if (isPossible) {
						answer = Math.max(answer, sum);
					}
				}
			}
		}

		System.out.println(answer);
	}
}