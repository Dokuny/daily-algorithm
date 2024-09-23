class Solution {

    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;

        double second = 6;
        double minute = 0.1;
        double hour = 1.0 / 120;

        int cnt = 0;

        int startTime = (s1 + m1 * 60 + h1 * 3600);
        int endTime = (s2 + m2 * 60 + h2 * 3600);

        double prevS = second * startTime % 360;
        double prevM = minute * startTime % 360;
        double prevH = hour * startTime % 360;

        int minusCnt = 0;

        if(startTime % 43200 == 0)  minusCnt++;

        int mCnt = 60;
        int hCnt = 60;

        for (int i = startTime + 1; i <= endTime; i++) {
            double s = second * i % 360;
            double m = minute * i % 360;
            double h = hour * i % 360;

            if(i % 43200 == 0) {
                minusCnt++;
            }

            if(prevS <= prevM && m <= (s == 0.0 ? 360.0 : s) && mCnt >= 59) {
                cnt++;
                mCnt = 0;
            }

            if(prevS <= prevH && h <= (s == 0.0 ? 360.0 : s) && hCnt >= 59) {
                cnt++;
                hCnt = 0;
            }

            prevS = s;
            prevM = m;
            prevH = h;
            mCnt++;
            hCnt++;

        }

        return cnt - minusCnt;
    }
}