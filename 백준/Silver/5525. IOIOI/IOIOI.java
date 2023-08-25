import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		String base = "IO";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(base);
		}
		sb.append("I");

		String input = br.readLine();

		int cnt = 0;
		int idx = 0;
		while (true) {
			int findIdx = input.indexOf(sb.toString(), idx);

			if (findIdx == -1) {
				break;
			}
			cnt++;
			if(findIdx + 3 > input.length()) break;
			idx = findIdx+2;
		}

		System.out.println(cnt);

	}


}