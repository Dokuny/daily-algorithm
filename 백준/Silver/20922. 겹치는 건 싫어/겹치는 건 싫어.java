import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 23.07.26
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] idxList = new LinkedList[100001];

        for (int i = 0; i < idxList.length; i++) {
            idxList[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 1;

        int max = 0;
        while (right <= N) {
            int cur = Integer.parseInt(st.nextToken());

            idxList[cur].add(right);

            // K를 넘은 경우
            if (idxList[cur].size() > K) {
                // cur이 처음으로 나온 인덱스를 left로 변경
                left = Math.max(idxList[cur].pollFirst(),left);
            }

            max = Math.max(max, right - left);
            right++;
        }
        System.out.println(max);
    }
}