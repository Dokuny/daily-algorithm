package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9498 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());

		String answer;

		// 90 이상인지
		if (A >= 90) {
			answer = "A";
		} else if (A >= 80) {  // 80 이상인지 , 앞에서 90이상이 아니므로 자연스럽게 80 ~ 89
			answer = "B";
		} else if(A >= 70){ // 70 이상인지
			answer = "C";
		}else if(A >= 60){
			answer = "D";
		}else{
			answer = "F";
		}

		System.out.println(answer);
	}

}
