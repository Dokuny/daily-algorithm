package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 23.07.18
 */

public class No_7785 {



	// TreeSet으로 풀면 속도가 더 빠를까?
	// 480ms, 아무래도 따로 리스트로 변환하고 정렬하는데 시간이 더 소요되는 것 같음
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		TreeSet<String> set = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String name = st.nextToken();

			if (st.nextToken().equals("enter")) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}

		TreeSet<String> desSet = (TreeSet<String>) set.descendingSet();

		StringBuilder sb = new StringBuilder();
		for (String s : desSet) {
			sb.append(s)
				.append("\n");
		}
		System.out.println(sb);
	}

	// 640ms
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int n = Integer.parseInt(br.readLine());
//
//		HashSet<String> set = new HashSet<>();
//
//		for (int i = 0; i < n; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//
//			String name = st.nextToken();
//
//			if (st.nextToken().equals("enter")) {
//				set.add(name);
//			} else {
//				set.remove(name);
//			}
//		}
//
//		List<String> list = new ArrayList<>(set);
//
//		Collections.sort(list, Collections.reverseOrder());
//
//		StringBuilder sb = new StringBuilder();
//		for (String s : list) {
//			sb.append(s)
//				.append("\n");
//		}
//		System.out.println(sb);
//	}

}
