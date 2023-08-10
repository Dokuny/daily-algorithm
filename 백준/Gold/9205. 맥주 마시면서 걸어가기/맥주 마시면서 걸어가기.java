import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {

            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N + 2][2];

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                
            }

            // 다익스트라로 풀기
            // 간선 리스트 만들기
            ArrayList<Edge>[] adjList = new ArrayList[N + 2];
            for (int i = 0; i < N + 2; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i <= N; i++) {
                for (int j = i + 1; j < adjList.length; j++) {
                    adjList[i].add(new Edge(j, Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])));
                    if (i != 0) {
                        adjList[j].add(new Edge(i, Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])));
                    }
                }
            }

            // 거리 배열 초기화
            int[] distance = new int[arr.length];
            for (int i = 0; i < distance.length; i++) {
                distance[i] = Integer.MAX_VALUE;
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.weight));

            pq.add(new Edge(0, 0));

            while (!pq.isEmpty()) {
                Edge cur = pq.poll();

                if (distance[cur.to] != Integer.MAX_VALUE) continue;

                distance[cur.to] = cur.weight;

                for (Edge edge : adjList[cur.to]) {
                    if (edge.weight > 1000) continue;
                    pq.add(new Edge(edge.to, distance[cur.to] + edge.weight));
                }
            }

            if (distance[N + 1] == Integer.MAX_VALUE) {
                sb.append("sad");
            } else {
                sb.append("happy");
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
