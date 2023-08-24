import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {

	static ArrayList<Integer> numbers;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		numbers = new ArrayList<>();

		int left = 0;
		int right = 0;
		while (right < s.length()) {
			if (s.charAt(right) >= '0' && s.charAt(right) <= '9') {
				right++;
			} else {
				numbers.add(Integer.parseInt(s.substring(left, right)));

				if (s.charAt(right) == '-') {
					left = right;
					right = left + 1;
				} else {
					left = right + 1;
					right = left;
				}
			}
		}
		numbers.add(Integer.parseInt(s.substring(left, right)));

		int sum = 0;
		boolean isMinus = false;
		for (Integer number : numbers) {
			if (number < 0) {
				isMinus = true;
				sum += number;
			} else {
				if (isMinus) {
					sum -= number;
				} else {
					sum += number;
				}
			}
		}
		System.out.println(sum);
	}
}