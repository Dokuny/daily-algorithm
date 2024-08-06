import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    stack.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        sb.append(stack.pollLast());
                    } else {
                        sb.append(-1);
                    }
                    break;
                case 3:
                    sb.append(stack.size());
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    break;
                case 5:
                    if (!stack.isEmpty()) {
                        sb.append(stack.peekLast());
                    } else {
                        sb.append(-1);
                    }
                    break;

            }

            if (command != 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }


}
