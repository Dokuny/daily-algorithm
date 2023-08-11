import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] wires = new int[K];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            wires[i] = Integer.parseInt(br.readLine());
            pq.add(wires[i]);
        }

        int length = 0;
        while (!pq.isEmpty()) {
            length = pq.poll();

            int cnt = 0;
            for (int wire : wires) {
                cnt += wire / length;
            }
            if (cnt >= N) {
                break;
            } else {
                pq.add(length / 2);
            }
        }

        for (int i = length+1; true; i++) {

            int cnt = 0;
            for (int wire : wires) {
                cnt += wire / i;
            }
            if (cnt >= N) {
                length = i;
            } else {
                System.out.println(length);
                return;
            }
        }

    }


}

