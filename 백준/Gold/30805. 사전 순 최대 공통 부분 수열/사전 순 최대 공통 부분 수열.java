import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 카운트 정렬 개념 활용
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ACnt = new int[101];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            ACnt[A[i]]++;
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        int[] BCnt = new int[101];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            BCnt[B[i]]++;
        }

        int aIdx = 0;
        int bIdx = 0;

        ArrayList<Integer> list = new ArrayList<>();

        while (aIdx < N && bIdx < M) {
            // 두 수가 동일한 경우
            if (A[aIdx] == B[bIdx]) {
                // 반대쪽이 개수가 남아있는 경우
                list.add(A[aIdx]);

                ACnt[A[aIdx]]--;
                BCnt[B[bIdx]]--;

                aIdx++;
                bIdx++;
            } else if (A[aIdx] > B[bIdx]) {
                if (BCnt[A[aIdx]] > 0) {
                    BCnt[B[bIdx]]--;
                    bIdx++;
                } else {
                    ACnt[A[aIdx]]--;
                    aIdx++;
                }
            } else {
                if (ACnt[B[bIdx]] > 0) {
                    ACnt[A[aIdx]]--;
                    aIdx++;
                } else {
                    BCnt[B[bIdx]]--;
                    bIdx++;
                }
            }
        }

        // 최장 부분수열 구하기
        int[] result = new int[list.size()];

        int idx = 0;

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);

            while (idx > 0 && result[idx] < num) {
                result[idx] = 0;
                idx--;
            }

            if (result[idx] >= num) {
                result[++idx] = num;
            } else {
                result[idx] = num;
            }
            idx++;
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < result.length; i++) {
            if(result[i] == 0) break;
            sb.append(result[i]).append(" ");
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(sb);

    }

}
