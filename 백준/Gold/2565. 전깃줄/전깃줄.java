import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] line = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        // 한쪽을 정렬해서 정렬한 쪽으로 최장 부분 수열 구하기
        Arrays.sort(line, Comparator.comparingInt(arr -> arr[0]));

        // 각 인덱스를 
//        int[] dp = new int[N];
        int[] lis = new int[N];
        Arrays.fill(lis, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            int num = line[i][1];

            int idx = Arrays.binarySearch(lis, num);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            lis[idx] = num;
//            dp[i] = idx;
        }
        int len = 0;
        for (int i = 0; i < N; i++) {
            if (lis[i] == Integer.MAX_VALUE) {
                len = i;
                break;
            }
        }

        if(len == 0) len = N;

        System.out.println(N - len);

    }
}
