import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 23.07.30
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int idx = 1;

		StringTokenizer st;
		while (N != 0) {

			HashMap<String, String> map = new HashMap<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				String giver = st.nextToken();
				String receiver = st.nextToken();

				map.put(giver, receiver);
			}

			int cnt = 0;

			HashSet<String> set = new HashSet<>();

			String start;
			
			for (String name : map.keySet()) {
				if(set.contains(name)) continue;

				start = name;
				String next = start;
				while (true) {
					if (map.containsKey(next)) {
						next = map.get(next);
						set.add(next);
					} else {
						break;
					}

					if (next.equals(start)) {
						cnt++;
						break;
					}
				}
			}

			System.out.println(idx++ + " " + cnt);
			N = Integer.parseInt(br.readLine());
		}

	}


}
