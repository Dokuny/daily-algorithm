class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {
		int answer = 0;

		// bandgage[ t= 시전시간, x =초당 회복량, y=추가 회복량]

		int curHealth = health;
		int curTime = 0;
		for (int[] attack : attacks) {
			int attackTime = attack[0];
			int damage = attack[1];

			// 연속성공
			int successCnt = attackTime - curTime - 1;

			curHealth += (bandage[1] * successCnt + successCnt / bandage[0] * bandage[2]);

			if (curHealth > health) {
				curHealth = health;
			}

			// 공격 데미지 계산
			curHealth -= damage;

			if (curHealth <= 0) {
				return -1;
			}

			curTime = attackTime;
		}

		return curHealth ;
	}
}