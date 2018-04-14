/**
 * N14502 - 연구소
 * https://www.acmicpc.net/problem/14502
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int N, M;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int MIN = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // y
		M = sc.nextInt(); // x
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, map);
		System.out.println(MIN);
	}

	/* 벽세우기 */
	public static void dfs(int wall, int[][] map) {
		int safe = 0;
		if (wall == 3) {
			safe = bfs(map);
			if (MIN < safe) {
				MIN = safe;
			}
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						dfs(wall + 1, map);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	/* 오염구역 탐색 */
	public static int bfs(int[][] map) {
		Queue<int[]> q = new LinkedList<>();
		int[][] newMap = new int[N][M];
		/**
		 * 방문 배열을 전역변수에 뒀을 때 이전에 방문했던 것을 초기화해주지 않아서 다음 검사때마다 체크하지 않음..
		 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
				int[] col = { i, j };
				if (newMap[i][j] == 2) {
					q.offer(col);
				}
			}
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int[] next = { now[0] + dy[i], now[1] + dx[i] };
				if (next[1] >= 0 && next[1] < M && next[0] >= 0 && next[0] < N) {
					if (newMap[next[0]][next[1]] == 0) {
						q.offer(next);
						newMap[next[0]][next[1]] = 2;
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
