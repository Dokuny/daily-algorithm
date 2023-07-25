package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.25
 */
public class No_11729 {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		hanoi(N, 1, 3, 2);
		System.out.println(sb);

	}

	// 단순하게 생각해서 1개 짜리는 from -> to 가는 것
	// 2개의 경우, 맨 밑을 목적지로 보내기 위해서는 위에 녀석을 목적지가 아닌  via에 보내야함
	// 그리고 나서 맨 밑을 목적지로 보내고, via 보낸 녀석을 다시 목적지로 보내야함
	public static void hanoi(int move, int from, int to, int via) {
		if (move == 1) {
			sb.append(from).append(" ").append(to)
				.append("\n");
		} else {
			hanoi(move - 1, from, via, to);
			sb.append(from).append(" ").append(to)
				.append("\n");
			hanoi(move - 1, via, to, from);
		}
	}

}
