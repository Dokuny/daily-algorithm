package baekjoon._23._07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10798 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        char[][] arr = new char[15][15];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(arr[j][i] == '\u0000') continue;
                sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);
    }
    // 이전 코드
    // public static void main(String[] args) throws IOException {

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     StringBuilder sb = new StringBuilder();

    //     int maxLen = -1;

    //     String[] arr = new String[5];
    //     for (int i = 0; i < 5; i++) {
    //         arr[i] = br.readLine();
    //         if(maxLen < arr[i].length()) maxLen = arr[i].length();
    //     }

    //     char[][] arr2 = new char[5][maxLen];

    //     for (int i = 0; i < arr2.length; i++) {
    //         for (int j = 0; j < arr[i].length(); j++) {
    //             arr2[i][j] = arr[i].charAt(j);
    //         }
    //     }

    //     for (int i = 0; i < maxLen; i++) {
    //         for (int j = 0; j < 5; j++) {
    //             if(arr2[j][i] == '\0') continue;
    //             sb.append(arr2[j][i]);
    //         }
    //     }

    //     System.out.println(sb);
    // }

}
