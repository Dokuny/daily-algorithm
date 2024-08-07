import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] board = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = input.charAt(j - 1);
            }
        }

        int[][] blackBoard = generateMatrix('B', board);
        int[][] whiteBoard = generateMatrix('W', board);

        // 누적합 진행
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                blackBoard[i][j] =
                        blackBoard[i - 1][j] + blackBoard[i][j - 1] - blackBoard[i - 1][j - 1] + blackBoard[i][j];
                whiteBoard[i][j] =
                        whiteBoard[i - 1][j] + whiteBoard[i][j - 1] - whiteBoard[i - 1][j - 1] + whiteBoard[i][j];
            }
        }

        // 구간합 구하기
        int result = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int bVal = blackBoard[i][j] - blackBoard[i - K][j] - blackBoard[i][j - K] + blackBoard[i - K][j - K];
                int wVal = whiteBoard[i][j] - whiteBoard[i - K][j] - whiteBoard[i][j - K] + whiteBoard[i - K][j - K];

                result = Math.min(result, Math.min(wVal, bVal));
            }
        }
        System.out.println(result);

    }

    static int[][] generateMatrix(char c, char[][] origin) {

        int[][] matrix = new int[origin.length][origin[0].length];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    if (origin[i][j] != c) {
                        matrix[i][j] = 1;
                    }
                } else {
                    if (origin[i][j] == c) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        return matrix;
    }


}
