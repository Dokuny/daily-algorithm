import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] adjList;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (arr[a] > arr[b]) {
				adjList[b].add(a);
			} else if (arr[a] < arr[b]) {
				adjList[a].add(b);
			} else {
				adjList[a].add(b);
				adjList[b].add(a);
			}
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (adjList[i].size() == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);


	}

}
