import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Time> times = new PriorityQueue<>((o1, o2) -> {
			if (o1.end == o2.end) {
				return Integer.compare(o1.start, o2.start);
			}
			return Integer.compare(o1.end, o2.end);
		});

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			times.add(new Time(start, end));
		}


		int cnt = 0;

		int curEnd = 0;

		while (!times.isEmpty()) {
			Time time = times.poll();
			if(time.start < curEnd) continue;
			cnt++;
			curEnd = time.end;
		}
	
		System.out.println(cnt);


	}

	static class Time {
		int start;
		int end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}