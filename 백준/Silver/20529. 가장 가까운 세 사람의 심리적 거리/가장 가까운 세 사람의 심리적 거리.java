import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int min;
	static int[] arr;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		HashMap<String, Integer> map = new HashMap<>();
		map.put("ESTJ", 0);
		map.put("ESTP", 1);
		map.put("ESFJ", 2);
		map.put("ESFP", 3);
		map.put("ENTJ", 4);
		map.put("ENTP", 5);
		map.put("ENFJ", 6);
		map.put("ENFP", 7);
		map.put("ISTJ", 8);
		map.put("ISTP", 9);
		map.put("ISFJ", 10);
		map.put("ISFP", 11);
		map.put("INTJ", 12);
		map.put("INTP", 13);
		map.put("INFJ", 14);
		map.put("INFP", 15);

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 0; test_case < T ; test_case++) {
			int N = Integer.parseInt(br.readLine());

			arr = new int[16];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[map.get(st.nextToken())]++;
			}

			min = Integer.MAX_VALUE;
			dfs(0,new int[3]);

			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth, int[] check) {
		if (depth == 3) {
			int a = check[0];
			int b = check[1];
			int c = check[2];
			min = Math.min(min, diff(a, b) + diff(a, c) + diff(b, c));
			return;
		}

		for (int i = 0; i < 16; i++) {
			if(arr[i] == 0) continue;

			check[depth] = i;
			arr[i]--;
			dfs(depth + 1, check);
			arr[i]++;
		}
	}

	static int diff(int a, int b) {

		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			boolean aR = (a & (1 << i)) != 0;
			boolean bR = (b & (1 << i)) != 0;
			if (aR != bR) {
				cnt++;
			}
		}

		return cnt;
	}
}