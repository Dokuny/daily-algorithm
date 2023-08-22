import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		HashSet<Integer> set = new HashSet<>();

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String oper = st.nextToken();

			int num = 0;
			if (!oper.equals("all") && !oper.equals("empty")) {
				num = Integer.parseInt(st.nextToken());
			}

			switch (oper) {
				case "add":
					set.add(num);
					break;
				case "remove":
					set.remove(num);
					break;
				case "check":
					if (set.contains(num)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
					sb.append("\n");
					break;
				case "toggle":
					if (set.contains(num)) {
						set.remove(num);
					} else {
						set.add(num);
					}
					break;
				case "all":
					for (int j = 1; j <= 20; j++) {
						set.add(j);
					}
					break;
				case "empty":
					for (int j = 1; j <= 20; j++) {
						set.remove(j);
					}
					break;
			}
		}
		System.out.println(sb);
	}


}