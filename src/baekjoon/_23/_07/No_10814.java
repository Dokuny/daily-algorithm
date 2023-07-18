package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No_10814 {
	static ArrayList<String>[] list;

	/**
	 * 리스트로 푸는 거 말고 그냥 StringBuilder 배열 만들어서 풀어도 좋은 듯
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder[] arr = new StringBuilder[201];
//        list = new ArrayList[201];

		for (int i = 1; i <= 200; i++) {
//            list[i] = new ArrayList<>();
			arr[i] = new StringBuilder();
		}


		for (int i = 0; i < n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int age = Integer.parseInt(st.nextToken());

			arr[age].append(age)
				.append(" ")
				.append(st.nextToken())
				.append("\n");
		}

//        StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 200; i++) {
			if(arr[i].length() != 0)
				System.out.print(arr[i]);

//            for (String s : list[i]) {
//                sb.append(i)
//                        .append(" ")
//                        .append(s)
//                        .append("\n");
//            }
		}
	}
}
