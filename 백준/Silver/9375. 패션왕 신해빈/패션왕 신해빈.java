import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {


	static ArrayList<Integer> list;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int test_case = 0; test_case < T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			// 의상 종류 개수 체크

			// 종류별 개수
			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				String name = st.nextToken();
				String kind = st.nextToken();
				map.put(kind, map.getOrDefault(kind, 0) + 1);
			}

			if (map.keySet().size() == 1) {
				for (Integer value : map.values()) {
					sb.append(value).append("\n");
				}
			} else {
				int sum = 1;
				for (Integer value : map.values()) {
					sum *= (value + 1);
				}

				sb.append(sum - 1).append("\n");
			}

		}
		System.out.println(sb);
	}

}