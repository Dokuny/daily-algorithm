import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 23.07.24
 */
public class Main {


	static char[][] board;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		board = new char[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(board[i], '*');
		}

		recur(0, 0, N);

		StringBuilder sb = new StringBuilder();

		for (char[] chars : board) {
			sb.append(chars).append("\n");
		}

		System.out.println(sb);
	}

	public static void recur(int x, int y, int k) {
		if(k == 1)return;

		int diff = k / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					remove(x + diff, y + diff, diff);
				} else {
					recur(x + diff * i, y + diff * j, diff);
				}
			}
		}
	}

	public static void remove(int x, int y, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				board[i][j] = 32;
			}
		}
	}

}
