import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] arr = new char[N];

		String input = br.readLine();

		ArrayList<Integer> robots = new ArrayList<>();
		ArrayList<Integer> parts = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr[i] = input.charAt(i);

			if (arr[i] == 'P') {
				robots.add(i);
			} else {
				parts.add(i);
			}
		}

		int partCnt = parts.size();

		boolean[] visited = new boolean[N];
		for (Integer robot : robots) {
			if (partCnt == 0) {
				break;
			}
			for (Integer part : parts) {
				if(visited[part]) continue;
				if (Math.abs(robot - part) <= K) {
					visited[part] = true;
					partCnt--;
					break;
				}
			}
		}

		System.out.println(parts.size() - partCnt);

	}
}
