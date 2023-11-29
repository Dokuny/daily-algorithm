import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		System.out.println(pow(a, b, c));
	}

	static long pow(long a, long b, long c) {

		long base = 1;

		while (b != 0) {

			if (b % 2 != 0) {
				base = ((base % c) * (a % c)) % c;
			}

			b /= 2;
			a = ((a % c) * (a % c)) % c;
		}

		return base % c;
	}

}

