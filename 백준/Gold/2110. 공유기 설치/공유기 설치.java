import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int[] accum = new int[N];
        for (int i = 1; i < N; i++) {
            accum[i] = accum[i - 1] + arr[i] - arr[i - 1];
        }
        accum[0] = 0;

        // 첫번째에는 무조건 설치한다고 가정하고 몇개 설치 가능한지 확인
        int left = 0;
        int right = arr[arr.length - 1] + 1;

        while (left < right) {
            int mid = (right + left) / 2;

            int cnt = 1;

            int l = 0;
            int r = 1;
            while (r < arr.length) {
                if (accum[r] - accum[l] >= mid) {
                    cnt++;
                    l = r;
                }
                r++;
            }

            // 더 많이 놓을 수 있다면 길이를 늘려야함. 가장 긴 길이를 찾아야하니 left는 유지
            if (cnt >= C) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);


    }
}
