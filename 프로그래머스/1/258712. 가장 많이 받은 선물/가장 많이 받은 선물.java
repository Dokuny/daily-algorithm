import java.util.HashMap;

class Solution {

	public int solution(String[] friends, String[] gifts) {
		int answer = 0;

		int n = friends.length;

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < friends.length; i++) {
			map.put(friends[i], i);
		}

		int[][] giftRecord = new int[n][n];
		int[] jisu = new int[n];

		for (String gift : gifts) {
			String[] persons = gift.split(" ");

			Integer a = map.get(persons[0]);
			Integer b = map.get(persons[1]);

			// A는 준사람 , B는 받은 사람
			giftRecord[a][b] += 1;
			jisu[a] += 1;
			jisu[b] -= 1;
		}

		int[] count = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (giftRecord[i][j] > giftRecord[j][i]) {
					count[i] += 1;
				} else if (giftRecord[i][j] < giftRecord[j][i]) {
					count[j] += 1;
				} else {
					if (jisu[i] > jisu[j]) {
						count[i] += 1;
					} else if (jisu[i] < jisu[j]) {
						count[j] += 1;
					}
				}
			}
		}

		for (int i : count) {
			answer = Math.max(answer, i);
		}

		return answer;
	}
}