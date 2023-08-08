import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int[] dp;
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());

        dp = new int[X + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);


        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(dp[cur.num] <= cur.cnt) continue;

            dp[cur.num] = cur.cnt;

            if (cur.num * 3 <= X){
                queue.add(new Node(cur.num * 3, cur.cnt + 1));
            }
            if (cur.num * 2 <= X) {
                queue.add(new Node(cur.num * 2, cur.cnt+1));
            }
            if (cur.num + 1 <= X) {
                queue.add(new Node(cur.num + 1, cur.cnt + 1));
            }
        }

        System.out.println(dp[X]);

    }


    static class Node{
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }



}
