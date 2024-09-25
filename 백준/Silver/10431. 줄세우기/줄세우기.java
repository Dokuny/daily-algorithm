import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());

            int[] arr = new int[20];

            int cnt = 0;
            // 삽입 정렬
            for (int j = 0; j < 20; j++) {
                int idx = j;
                int tall = Integer.parseInt(st.nextToken());

                arr[idx] = tall;
                for (int k = idx - 1; k >= 0; k--) {
                    if(arr[k] > tall) {
                        swap(k, idx, arr);
                        idx = k;
                        cnt++;
                    }else {
                        break;
                    }
                }
            }
            sb.append(no).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void swap(int aIdx, int bIdx, int[] arr) {
        int temp = arr[aIdx];
        arr[aIdx] = arr[bIdx];
        arr[bIdx] = temp;
    }
}
