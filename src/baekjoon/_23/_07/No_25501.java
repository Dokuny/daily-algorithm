package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 23.07.24
 */
public class No_25501 {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			cnt = 0;
			int result = isPalindrome(br.readLine().toCharArray());

			System.out.println(result +" "+cnt);
		}

	}

	private static int recursion(char[] s, int l, int r){
		cnt++;
		if(l >= r) return 1;
		else if(s[l] != s[r]) return 0;
		else return recursion(s, l+1, r-1);
	}

	private static int isPalindrome(char[] s){
		return recursion(s, 0, s.length - 1);
	}

}
