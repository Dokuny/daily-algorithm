import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 입력 배열
	static int answer = Integer.MAX_VALUE;
	static int paper[] = {0,5,5,5,5,5};
	static int map[][] = new int[10][10];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 10; i++) {
			String sa[] = br.readLine().split(" ");
			for(int j = 0; j < 10; j++)
				map[i][j] = Integer.parseInt(sa[j]);
		}

		dfs(0,0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	public static boolean check(int y, int x, int size) {
		if(x+size > 10 || y+size > 10)
			return false;
		else {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(map[y+i][x+j] == 0)
						return false;
				}
			}
		}
		return true;
	}

	public static void paint(int y, int x, int size, int num) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				map[y+i][x+j] = num;
			}
		}
	}

	public static void dfs(int index, int count) {
		if(index == 100) {
			answer = Math.min(count, answer);
			return;
		}
		else if(count >= answer) return;
		else {
			int x = index%10;
			int y = index/10;
			if(map[y][x] == 1) {
				for(int i = 5; i >= 1; i--) {
					if(check(y, x, i)) {
						paper[i] --;
						if(paper[i] < 0) {
							paper[i]++;
							return;
						}
						paint(y,x,i,0);
						dfs(index+1,count+1);
						paint(y,x, i,1);
						paper[i] ++;
					}
				}
			}
			else
				dfs(index+1, count);
		}
	}


}