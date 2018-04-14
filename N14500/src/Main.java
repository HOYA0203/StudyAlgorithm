/**
 * N14500
 * https://www.acmicpc.net/problem/14500
 */

import java.util.Scanner;

public class Main {
	static int MIN = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j + 3 < M) { // 1
					compare(map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3]);
				}

				if (i + 3 < N) { // 1
					compare(map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j]);
				}

				if (i + 1 < N && j + 1 < M) { // 2
					compare(map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1]);
				}

				if (i + 2 < N && j + 1 < M) { // 3 - 1
					compare(map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i][j + 1]);
				}

				if (i + 1 < N && j + 2 < M) { // 3 - 2
					compare(map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i][j + 2]);
				}

				if (i + 2 < N && j + 1 < M) { // 3 - 3
					compare(map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1]);
				}

				if (i - 1 >= 0 && j + 2 < M) { // 3 - 4
					compare(map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i - 1][j + 2]);
				}

				if (i - 2 >= 0 && j + 1 < M) { // 3 - 5
					compare(map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i - 2][j + 1]);
				}

				if (i + 1 < N && j + 2 < M) { // 3 - 6
					compare(map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2]);
				}

				if (i + 2 < N && j + 1 < M) { // 3 - 7
					compare(map[i][j] + map[i + 1][j] + map[i+ 2][j] + map[i + 2][j+ 1]);
				}

				if (i + 1 < N && j + 2 < M) { // 3 - 2
					compare(map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2]);
				}

				if (i + 1 < N && j - 1 >= 0 && j + 1 < M) { // 4 - 1
					compare(map[i][j] + map[i + 1][j - 1] + map[i + 1][j] + map[i + 1][j + 1]);
				}

				if (i + 2 < N && j - 1 >= 0) { // 4 - 2
					compare(map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j - 1]);
				}

				if (i + 1 < N && j + 2 < M) { // 4 - 3
					compare(map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1]);
				}

				if (i + 2 < N && j + 1 < M) { // 4 - 4
					compare(map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1]);
				}

				if (i - 1 >= 0 && j + 2 < M) { // 5
					compare(map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i - 1][j + 2]);
				}

				if (i + 2 < N && j + 1 < M) { // 5
					compare(map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1]);
				}

				if (i + 1 < N && j + 2 < M) { // 5
					compare(map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2]);
				}

				if (i + 2 < N && j - 1 >= 0) { // 5
					compare(map[i][j] + map[i + 1][j] + map[i + 1][j - 1] + map[i + 2][j - 1]);
				}
			}
		}
		System.out.println(MIN);
	}

	public static void compare(int sum) {
		if (MIN < sum)
			MIN = sum;
	}
}
