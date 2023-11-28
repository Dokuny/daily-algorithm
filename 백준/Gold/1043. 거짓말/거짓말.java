import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수

		// 부모 배열 초기화
		parents = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		st = new StringTokenizer(br.readLine());

		int truthNum = Integer.parseInt(st.nextToken());

		if (truthNum == 0) {
			System.out.println(M);
			return;
		}

		int[] truth = new int[truthNum]; // 진실을 아는 사람들

		for (int i = 0; i < truthNum; i++) {
			truth[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < truth.length; i++) {
			union(find(truth[0]), find(truth[i]));
		}

		int[][] parties = new int[M][];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int partyPersonNum = Integer.parseInt(st.nextToken());
			parties[i] = new int[partyPersonNum];

			int firstPerson = Integer.parseInt(st.nextToken());
			parties[i][0] = firstPerson;

			for (int j = 1; j < partyPersonNum; j++) {
				parties[i][j] = Integer.parseInt(st.nextToken());
				union(find(firstPerson), find(parties[i][j]));
			}
		}

		int cnt = 0;

		for (int[] party : parties) {

			boolean isPossible = true;

			for (int num : party) {
				if (find(num) == find(truth[0])) {
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static void union(int a, int b) {
		int aP = find(a);
		int bP = find(b);

		if (aP != bP) {
			parents[bP] = aP;
		}
	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
}

