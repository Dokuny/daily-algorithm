package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][] map = {{0, 0}, {w, h}};

		int min = Integer.MAX_VALUE;
		for (int[] pos : map) {
			min = Math.min(min, Math.abs(x - pos[0]));
			min = Math.min(min, Math.abs(y - pos[1]));
		}
		System.out.println(min);
	}

}
