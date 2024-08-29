import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS?
        int[] lis = new int[N];
        Arrays.fill(lis, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            int idx = binarySearch(lis, arr[i]);

            lis[idx] = arr[i];
        }

        int i = binarySearch(lis, Integer.MAX_VALUE);

        int answer = -1;
        for (int j = 0; j < N; j++) {
            if (lis[j] == Integer.MAX_VALUE) {
                answer = j;
                break;
            }
        }

        if (answer == -1) {
            answer = N;
        }
        System.out.println(answer);

    }

    static int binarySearch(int[] arr, int target) {
        // lower bound

        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (target > arr[m]) {
                l = m + 1;
            } else {
                r = m;
            }

        }

        return l;
    }
}
