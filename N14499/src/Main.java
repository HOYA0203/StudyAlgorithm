/**
 * N14499
 * https://www.acmicpc.net/problem/14499
 * 18-04-14 success
 */
import java.util.Scanner;

public class Main {
	static int[] dice = {2, 1, 5, 6, 4, 3};//new int[6];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		simul(1);
		for(int i = 0; i<6; i++) {
			System.out.print(dice[i] + " ");
		}
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		while (k-- > 0) {
			int dir = sc.nextInt() - 1;
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}

			if (dir == 1) {
				simul(dir);
			}

			if (dir == 2) {
				simul(dir);
			}

			if (dir == 3) {
				simul(dir);
			}

			if (dir == 4) {
				simul(dir);
			}

			x = nx;
			y = ny;
			if (map[x][y] == 0) {
				map[x][y] = dice[3];
			} else {
				dice[3] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[1]);
		}
	}

	public static void simul(int dir) {
		int temp;
		if (dir == 1) {
			temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
		}

		if (dir == 2) {
			temp = dice[1];
			dice[1] = dice[4];
			dice[4] = temp;

			temp = dice[1];
			dice[1] = dice[5];
			dice[5] = temp;

			temp = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
		}

		if (dir == 3) {
			temp = dice[0];
			for (int i = 0; i < 4; i++) {
				dice[i] = dice[i + 1];
			}
			dice[3] = temp;
		}

		if (dir == 4) {
			temp = dice[3];
			for (int i = 3; i > 0; i--) {
				dice[i] = dice[i - 1];
			}
			dice[0] = temp;
		}
	}
}
