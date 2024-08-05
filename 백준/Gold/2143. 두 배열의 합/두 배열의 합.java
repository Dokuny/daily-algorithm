import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * 최대 시간 복잡도 : 1000(1001)/2 * 3  = 150만 아니네...
 * 최대 공간 복잡도 : 8byte * 2,000,000 = 16MB 가량
 */

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long T = Long.parseLong(br.readLine());

        HashMap<Long, Long> mapA = generateCombMap(br);
        HashMap<Long, Long> mapB = generateCombMap(br);

        long result = 0;

        for (Long num : mapA.keySet()) {
            if (mapB.containsKey(T - num)) {
                result += mapA.get(num) * mapB.get(T - num);
            }
        }

        System.out.println(result);

    }

    private static HashMap<Long, Long> generateCombMap(BufferedReader br) throws IOException {
        StringTokenizer st;
        int cnt = Integer.parseInt(br.readLine());

        // i : 자리 수 , j : 시작 인덱스 + 자리 수 까지의 누적합
        // DP 활용 - A[i][j] = A[i-1][j] + A[0][j+1]
        long[][] dp = new long[cnt + 1][cnt];

        // 맵까지 활용
        HashMap<Long, Long> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            dp[1][i] = Long.parseLong(st.nextToken());
            map.put(dp[1][i], map.getOrDefault(dp[1][i], 0L) + 1);
        }

        for (int i = 2; i <= cnt; i++) {
            for (int j = 0; j <= cnt - i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[1][j + i - 1];
                map.put(dp[i][j], map.getOrDefault(dp[i][j], 0L) + 1);
            }
        }

        return map;
    }

}
