import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[] oper = {'+', '-', 'x', '%'};
    static int[] arr;
    static int N;
    static int[] operator;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        operator = new int[4];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // bfs로 풀게 아님
        // dfs ㄱㄱ
        dfs(1, arr[0]);


        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int depth, int sum) {
        // 탈출 조건
        if (depth == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        // 연산자 순회
        for (int i = 0; i < 4; i++) {
            // 해당 연산자의 갯수가 부족하면 pass
            if (operator[i] == 0) continue;
            operator[i]--;
            int prev = sum;
            switch (oper[i]) {
                case '+':
                    sum += arr[depth];
                    break;
                case '-':
                    sum -= arr[depth];
                    break;
                case 'x':
                    sum *= arr[depth];
                    break;
                case '%':
                    sum /= arr[depth];
                    break;
            }
            dfs(depth + 1, sum);
            operator[i]++;
            sum = prev;
        }
    }

}
