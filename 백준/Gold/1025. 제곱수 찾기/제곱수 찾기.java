import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		// 대각선이거나
		// 가로 / 세로 거나

		HashSet<Long> set = new HashSet<>();

		// 증가 좌표 - i , j
 		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {


				// 시작 위치 - k , l
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < M; l++) {
						if (i == 0 && j == 0) {
							set.add((long) (map[k][l] - '0'));
							continue;
						}

						int x = l;
						int y = k;

						StringBuilder sb = new StringBuilder();
						while (x >= 0 && x < M && y >= 0 && y < N) {

							sb.append(map[y][x]);
							set.add(Long.valueOf(sb.toString()));
							set.add(Long.valueOf(sb.reverse().toString()));
							sb.reverse();

							x += j;
							y += i;
						}

						int rX = l;
						int rY = k;

						StringBuilder rSb = new StringBuilder();
						while (rX >= 0 && rX < M && rY >= 0 && rY < N) {

							rSb.append(map[rY][rX]);
							set.add(Long.valueOf(rSb.toString()));
							set.add(Long.valueOf(rSb.reverse().toString()));
							rSb.reverse();

							rX += j;
							rY -= i;
						}

					}
				}
			}
		}

		ArrayList<Long> list = new ArrayList<>(set);

		list.sort(Collections.reverseOrder());

		for (Long num : list) {
			long root = (long) Math.sqrt(num);

			if (root * root == num) {
				System.out.println(num);
				return;
			}
		}
		System.out.println(-1);


	}

}