import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] sum = new long[N];
        sum[0] = Long.parseLong(st.nextToken()) % M;
        HashMap<Long, Long> map = new HashMap<>();

        map.put(sum[0], 1L);
        for (int i = 1; i < N; i++) {
            sum[i] = (sum[i - 1] + Long.parseLong(st.nextToken())) % M;
            map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1L);
        }

        // 경우의 수 계산 , n! / r!(n-r)!
        long result = map.getOrDefault(0L,  0L);

        for (Long value : map.values()) {
            if (value == 2) {
                result++;
            } else {
                result += value * (value - 1L) / 2;
            }
        }

        System.out.println(result);
    }


}
