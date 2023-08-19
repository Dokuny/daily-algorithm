import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int[][] energy;
	static LinkedList<Integer>[][] trees;
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		energy = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				energy[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 5);
		}

		trees = new LinkedList[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				trees[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			trees[x][y].addLast(z);
		}

		// 년차
		while (K != 0) {

			// 봄, 여름
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (trees[i][j].size() == 0) {
						continue;
					}

					LinkedList<Integer> cur = trees[i][j];

					int deadEnergy = 0;

					int size = cur.size();

					for (int k = 0; k < size; k++) {
						Integer age = cur.pollFirst();
						int diff = map[i][j] - age;
						if (diff < 0) {
							deadEnergy += age / 2;
							continue;
						}
						map[i][j] -= age;
						cur.addLast(age + 1);
					}

					map[i][j] += deadEnergy;
				}
			}

			// 가을
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (trees[i][j].size() == 0) {
						continue;
					}

					LinkedList<Integer> cur = trees[i][j];

					int size = cur.size();

					for (int k = 0; k < size; k++) {
						Integer age = cur.pollFirst();

						if (age % 5 == 0) {
							for (int[] dir : dirs) {
								int mX = j + dir[0];
								int mY = i + dir[1];

								if (mX < 0 || mY < 0 || mX >= N || mY >= N) {
									continue;
								}

								trees[mY][mX].addFirst(1);
							}
						}
						cur.addLast(age);
					}

				}
			}

			// 겨울
			s2d2();
			K--;
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer += trees[i][j].size();
			}
		}

		System.out.println(answer);


	}

	static void s2d2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += energy[i][j];
			}
		}
	}


}