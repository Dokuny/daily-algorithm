package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 23.07.24
 * 예전엔 못풀었는데 이젠 푸네..
 * 분할정복 문제
 */
public class No_2447 {

	static char[][] board;


	public static void main(String[] args) throws IOException {
		// 초기 세팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		board = new char[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(board[i], '*');
		}

		// 재귀 돌리기
		recur(0, 0, N);

		// 결과값 출력
		StringBuilder sb = new StringBuilder();

		for (char[] chars : board) {
			sb.append(chars).append("\n");
		}

		System.out.println(sb);
	}

	/**
	 * x : x축 시작 좌표
	 * y : y축 시작 좌표
	 * k : 전체 사이즈
	 */
	public static void recur(int x, int y, int k) {
		if(k == 1)return;

		int diff = k / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) { // 중앙은 비워둬야 하므로 지우기
					remove(x + diff, y + diff, diff);
				} else {
					recur(x + diff * i, y + diff * j, diff); // 그 외는 재귀
				}
			}
		}
	}

	// 주어진 좌표 범위 공백처리
	public static void remove(int x, int y, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				board[i][j] = 32;
			}
		}
	}

}
