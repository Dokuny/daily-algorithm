
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = 0;
            int right = N - 1;

            int max = 0;
            while (left < right) {
                int weight = arr[left] + arr[right];

                // 무게가 제한 보다 작고, 최대치보다 클때
                if (weight <= M) {
                    max = Math.max(max, weight);
                    left++;
                } else {
                    right--;
                }
            }

            sb.append("#").append(test_case).append(" ").append(max == 0 ? -1 : max).append("\n");
        }
        System.out.println(sb);
    }
}