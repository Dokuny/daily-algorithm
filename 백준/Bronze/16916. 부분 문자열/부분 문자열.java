import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		String pattern = br.readLine();

		System.out.println(searchPattern(word, pattern));
	}


	public static int[] pi(String pattern) {

		int len = 0;
		int i = 1;

		int[] pi = new int[pattern.length()];
		pi[0] = 0;

		while (i < pattern.length()) {
			if (pattern.charAt(len) == pattern.charAt(i)) {
				len++;
				pi[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = pi[len - 1];
				} else {
					pi[i] = 0;
					i++;
				}
			}
		}
		return pi;
	}

	public static int searchPattern(String text, String pattern) {
		int[] pi = pi(pattern);
		int textLength = text.length();
		int patternLength = pattern.length();
		int i = 0;  // 텍스트 인덱스
		int j = 0;  // 패턴 인덱스

		while (i < textLength) {
			if (pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}else {
				if (j != 0) {
					j = pi[j - 1];
				} else {
					i++;
				}
			}

			if (j == patternLength) {
				return 1;
			}
		}
		return 0;
	}
}