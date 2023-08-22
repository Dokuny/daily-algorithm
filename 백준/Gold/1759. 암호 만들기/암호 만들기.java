import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L;
	static int C;
	static char[] chars;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		chars = new char[C];

		String input = br.readLine();
		for (int i = 0; i < C; i++) {
			chars[i] = input.charAt(i * 2);
		}
		Arrays.sort(chars);

		dfs(0, -1, false, "", 0);
	}

	static void dfs(int depth, int prev, boolean isContain, String str,int cnt) {
		if (depth == L && isContain && cnt >= 2) {
			System.out.println(str);
			return;
		}

		for (int i = prev + 1; i < C; i++) {
			boolean check = isContain;
			int count = cnt;
			if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o'
				|| chars[i] == 'u') {
				check = true;
			} else {
				count++;
			}
			dfs(depth + 1, i, check, str + chars[i], count);
		}


	}


}