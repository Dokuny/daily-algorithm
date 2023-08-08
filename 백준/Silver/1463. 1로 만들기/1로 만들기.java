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

        System.out.println(recur(X,0));

    }

    static int recur(int n, int cnt) {
        if (n <= 1) {
            return cnt;
        }

        return Math.min(recur(n/2,cnt+1+(n%2)), recur(n/3,cnt+1+(n%3)));
    }
    
}
