import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while (deque.size() > 1) {
            deque.pollFirst();
            if (deque.size() == 1) {
                break;
            }
            deque.addLast(deque.pollFirst());
        }

        System.out.println(deque.pollFirst());
    }
}