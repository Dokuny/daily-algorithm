import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			Turret a = new Turret(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
			Turret b = new Turret(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));

			// 위치와 거리가 같으면 무한대
			if (a.equals(b)) {
				sb.append("-1").append("\n");
				continue;
			}

			// 두 터렛 사이의 거리 계산
			double dist = Math.sqrt(
				Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y), 2));

			int rSum = a.r + b.r;
			// 반지름의 길이의 합이 두 터렛 사이의 거리보다 겹치는거
			if (rSum > dist && Math.abs(a.r - b.r) < dist) {
				sb.append(2).append("\n");
			} else if (rSum == dist || dist == Math.abs(a.r - b.r)) { // 반지름 합이 길이와 같다면 한점 만남
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}

		}

		System.out.println(sb);
	}


	static class Turret {

		int x;
		int y;
		int r;

		public Turret(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Turret turret = (Turret) o;
			return x == turret.x && y == turret.y && r == turret.r;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y, r);
		}
	}
}
