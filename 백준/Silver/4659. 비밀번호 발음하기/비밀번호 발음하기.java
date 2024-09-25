import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            String word = br.readLine();

            if (word.equals("end")) {
                break;
            }

            int vowelCnt = 0;
            int consonantCnt = 0;

            boolean isIncludeVowel = false;

            boolean isAcceptable = true;

            for (int i = 0; i < word.length(); i++) {

                char c = word.charAt(i);

                // 1. 모음 체크 -> 반드시 하나가 포함되는지

                if (!isIncludeVowel && checkVowel(c)) {
                    isIncludeVowel = true;
                }

                // 2. 모음 or 자음이 연속으로 세개 오는지 체크

                if (checkVowel(c)) {
                    vowelCnt++;
                    consonantCnt = 0;
                }else {
                    consonantCnt++;
                    vowelCnt = 0;
                }

                if(vowelCnt == 3 || consonantCnt == 3) {
                    isAcceptable = false;
                    break;
                }

                // 같은 글자가 연속적으로 오는지 체크
                if(i != 0 && c == word.charAt(i - 1) && c != 'e' && c != 'o') {
                    isAcceptable = false;
                    break;
                }

            }

            if(isIncludeVowel && isAcceptable) {
                sb.append("<").append(word).append(">").append(" is acceptable.");
            }else {
                sb.append("<").append(word).append(">").append(" is not acceptable.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean checkVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
