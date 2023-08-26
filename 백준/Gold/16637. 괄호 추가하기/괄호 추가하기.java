import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int N;
	static String input;
	static long answer = Integer.MIN_VALUE;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		input = br.readLine();

		dfs(1, input.charAt(0) - '0');
		System.out.println(answer);
	}

	// depth 기준은 숫자 수로
	static void dfs(int depth, int sum) {
		if (depth == N) {
			answer = Math.max(sum, answer);
			return;
		}

		// 경우의 수는 두가지
		// 그냥 num1을 oper1으로 sum과 연산하던가 , num1 oper2 num2 연산한 후 sum oper1 하던가
		char oper1 = input.charAt(depth);
		int num1 = input.charAt(depth + 1) - '0';

		if (depth + 2 <= N) {
			dfs(depth + 2, calc(sum, num1, oper1));
		}

		if (depth + 4 <= N) {
			char oper2 = input.charAt(depth + 2);
			int num2 = input.charAt(depth + 3) - '0';
			dfs(depth + 4, calc(sum, calc(num1, num2, oper2), oper1));
		}

	}

	static int calc(int a, int b, char oper) {
		switch (oper) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
		}
		return 0;
	}
}
