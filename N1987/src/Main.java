/**
 * N1987 - 알파벳
 */
import java.util.Scanner;

public class Main {
	static boolean[] visit;
	static String[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int R;
	static int C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt(); // y
		C = sc.nextInt(); // x
		arr = new String[R][C];
		String str = null;
		visit = new boolean[26];
		sc.nextLine();
		for (int i = 0; i < R; i++) {
			str = sc.nextLine();
			for (int j = 0; j < C; j++) {
				 arr[i][j] = str.substring(j, 1 + j);
				// arr[i][j] = str.charAt(j); // If use char for String
			}
		}

		visit[arr[0][0].charAt(0) - 'A'] = true;
		System.out.println(check(0, 0));
	}

	static int check(int x, int y) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
				if (!visit[arr[ny][nx].charAt(0) - 'A']) {
					visit[arr[ny][nx].charAt(0) - 'A'] = true;
					int next = check(nx, ny);
					if (result < next)
						result = next;
					visit[arr[ny][nx].charAt(0) - 'A'] = false;	// @@
				}
			}
		}
		return result + 1;
	}
}
