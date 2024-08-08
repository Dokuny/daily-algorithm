import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());


        long[] cost = new long[N - 1];

        for (int i = 0; i < cost.length; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long[] oilPrice = new long[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            oilPrice[i] = Long.parseLong(st.nextToken());
        }

        long result = 0;
        long road = 0;
        long minCost = Long.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            if(oilPrice[i] < minCost) {
                result += minCost * road;
                minCost = oilPrice[i];
                road = 0;
            }

            road += cost[i];
        }

        System.out.println(result + road * minCost);
    }


}
