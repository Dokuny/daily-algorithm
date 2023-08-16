import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Road> roads;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        roads = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(end > D || end - start <= dist) continue;

            roads.add(new Road(start, end, end-start-dist));
        }

        Collections.sort(roads);
        max = Integer.MIN_VALUE;

        dfs(0, 0);

        System.out.println(D - max);

    }

    public static void dfs(int sum, int prevEnd) {


        int cnt = 0;
        for (Road road : roads) {
            if(road.start < prevEnd) continue;
            dfs(sum + road.benefit, road.end);
            cnt++;
        }

        if (cnt == 0) {
            if (sum < max) return;
            max = Math.max(max, sum);
        }

    }

    static class Road implements Comparable<Road> {
        int start;
        int end;
        int benefit;

        public Road(int start, int end, int benefit) {
            this.start = start;
            this.end = end;
            this.benefit = benefit;
        }

        @Override
        public int compareTo(Road o) {
            if (o.start == this.start) {
                return Integer.compare(this.end, o.end);
            }
            return Integer.compare(this.start, o.start);
        }
    }
}

