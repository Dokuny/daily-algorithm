package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1018 {

	static boolean[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 가로,세로 1~ N-8 까지 확인
		board = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) == 'W';
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				answer = Math.min(answer, check(j, i, true));
			}
		}
		System.out.println(answer);
	}

	public static int check(int startX, int startY, boolean isW) {

		boolean cur = isW;
		int cnt = 0;
		for (int i = startY; i < startY + 8; i++) {
			for (int j = startX; j < startX + 8; j++) {
				if (board[i][j] != cur) {
					cnt++;
				}

				cur = !cur;
			}
			cur = !cur;
		}

		// 전체에서 뒤집을 거를 빼면 반대색도 가능
		return Math.min(cnt, 64 - cnt);
	}

}
