import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.27
 */
public class Main {


	static int[] row;
	static int N;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		row = new int[N];

		nQueen(0);

		System.out.println(cnt);
	}

	public static void nQueen(int col) {
		if (col == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			row[col] = i;

			if (isPossible(col)) {
				nQueen(col + 1);
			}
		}
	}

	private static boolean isPossible(int col) {

		// 현재 열 전까지 확인
		for (int i = 0; i < col; i++) {
			// 같은 행인지 확인
			if (row[i] == row[col]) {
				return false;
			}
			// 대각선에 위치해있는지 확인
			// 행의 차이와 열의 차이가 같으면 대각선
			if (Math.abs(col - i) == Math.abs(row[col] - row[i])) {
				return false;
			}
		}
		return true;
	}
}
