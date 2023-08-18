import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String N;
    static boolean[] broken;

    static int answer = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();

        int M = Integer.parseInt(br.readLine());

        broken = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        if (N.equals("100")) {
            System.out.println("0");
            return;
        }

        dfs(0, "");

        System.out.println(Math.min(answer, Math.abs(Integer.parseInt(N) - 100)));

    }

    public static void dfs(int depth, String channel) {
        if(depth == 6) return;

        for (int i = 0; i < 10; i++) {
            if (broken[i]) continue;

            String newChannel = channel + i;

            int clickCnt = Math.abs(Integer.parseInt(N) - Integer.parseInt(newChannel)) + newChannel.length();

            answer = Math.min(answer, clickCnt);

            dfs(depth + 1, newChannel);
        }
    }

}

