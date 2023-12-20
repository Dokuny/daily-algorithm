import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static HashMap<Integer, Integer> performanceMap;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];

		Queue<Node> car = new ArrayDeque<>();
		Queue<Node> rain = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				if (input.charAt(j) == 'W') {
					car.add(new Node(j,i));
				} else if (input.charAt(j) == '*') {
					rain.add(new Node(j, i));
				}

				map[i][j] = input.charAt(j);
			}
		}

		int cnt = 0;
		boolean isPossible = false;
		while (!car.isEmpty()) {

			int rainSize = rain.size();

			for (int i = 0; i < rainSize; i++) {
				Node curRain = rain.poll();

				for (int[] dir : dirs) {
					int mx = dir[0] + curRain.x;
					int my = dir[1] + curRain.y;

					if(mx < 0 || my < 0 || mx >= C || my >= R) continue;
					if(map[my][mx] != '.' && map[my][mx] != 'V') continue;

					map[my][mx] = '*';
					rain.add(new Node(mx, my));
				}
			}

			int carSize = car.size();
			for (int i = 0; i < carSize; i++) {
				Node curCar = car.poll();

				for (int[] dir : dirs) {
					int mx = dir[0] + curCar.x;
					int my = dir[1] + curCar.y;

					if(mx < 0 || my < 0 || mx >= C || my >= R) continue;
					if(map[my][mx] == 'H'){
						isPossible = true;
						break;
					}
					if(map[my][mx] != '.') continue;

					map[my][mx] = 'V';
					car.add(new Node(mx, my));
				}
			}
			cnt++;

			if (isPossible) {
				break;
			}
		}

		if (isPossible) {
			System.out.println(cnt);
		} else {
			System.out.println("FAIL");
		}
	}
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


}
