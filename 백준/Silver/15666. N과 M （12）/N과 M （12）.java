import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int M;
	static LinkedHashSet<String> set;
	static int[] selected;
	static int N;
	static ArrayList<Integer> list;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		HashSet<Integer> numbers = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		list = new ArrayList<>(numbers);
		Collections.sort(list);

		set = new LinkedHashSet<>();

		sb = new StringBuilder();
		selected = new int[M];

		comb(0, 0);

		for (String s : set) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
		
	}

	static void comb(int depth, int prev) {
		if (depth == M) {

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}

			set.add(sb.toString());

			return;
		}

		for (int i = prev; i < list.size(); i++) {
			selected[depth] = list.get(i);
			comb(depth + 1, i);
		}

	}

}