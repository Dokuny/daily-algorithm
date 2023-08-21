import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 분할 정복 문제
 */
public class Main {

	static String[][] paper;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		paper = new String[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = st.nextToken();
			}
		}

		String result = divide(0, 0, N);

		int white = 0;
		int blue = 0;

		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == '1') {
				blue++;
			} else {
				white++;
			}
		}

		System.out.println(white + "\n" + blue);
	}

	static String divide(int x, int y, int length) {
		if (length == 1) {
			return paper[y][x];
		}

		int newLength = length / 2;

		String first = divide(x, y, newLength);
		String second = divide(x + newLength, y, newLength);
		String third = divide(x, y + newLength, newLength);
		String fourth = divide(x + newLength, y + newLength, newLength);

		if (first.length() == 1 && first.equals(second) && second.equals(third) && third.equals(fourth)) {
			return first;
		} else {
			return first + second + third + fourth;
		}
	}


}