import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();

		int kingX = a.charAt(0);
		int kingY = a.charAt(1);
		int stoneX = b.charAt(0);
		int stoneY = b.charAt(1);

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String command = br.readLine();

			int[] dir = null;

			switch (command) {
				case "R":
					dir = dirs[0];
					break;
				case "L":
					dir = dirs[1];
					break;
				case "B":
					dir = dirs[2];
					break;
				case "T":
					dir = dirs[3];
					break;
				case "RT":
					dir = dirs[4];
					break;
				case "LT":
					dir = dirs[5];
					break;
				case "RB":
					dir = dirs[6];
					break;
				case "LB":
					dir = dirs[7];
					break;
			}

			int mx = kingX + dir[0];
			int my = kingY + dir[1];

			if (mx < 'A' || mx > 'H' || my < '1' || my > '8') {
				continue;
			}

			if (mx == stoneX && my == stoneY) {
				int sx = stoneX + dir[0];
				int sy = stoneY + dir[1];

				if (sx < 'A' || sx > 'H' || sy < '1' || sy > '8') {
					continue;
				}
				stoneX = sx;
				stoneY = sy;
				kingX = mx;
				kingY = my;
			} else {
				kingX = mx;
				kingY = my;
			}

		}

		StringBuilder sb = new StringBuilder();

		sb.append((char) kingX).append((char) kingY).append("\n")
			.append((char) stoneX).append((char) stoneY);

		System.out.println(sb);

	}

}