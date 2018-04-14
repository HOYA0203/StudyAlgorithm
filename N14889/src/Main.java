/**
 * N14889
 * https://www.acmicpc.net/problem/14889
 * 
 */
import java.util.Scanner;

public class Main {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		p = new int[N];
		for (int i = N / 2; i < p.length; i++) {
			p[i] = 1;
		}

		int result = Integer.MAX_VALUE;
		do {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < N; i++) {
				if (p[i] == 1) {
					for (int j = i + 1; j < p.length; j++) {
						if (p[j] == 1) {
							sum1 += (map[i][j] + map[j][i]);
						}
					}
				}
				if (p[i] == 0) {
					for (int j = i + 1; j < p.length; j++) {
						if (p[j] == 0) {
							sum2 += (map[i][j] + map[j][i]);
						}
					}
				}
			}
			if (result > Math.abs(sum1 - sum2))
				result = Math.abs(sum1 - sum2);
		} while (next_permutation());
		System.out.println(result);
	}

	public static boolean next_permutation() {
		int I = 0, J = 0;
		for (int i = p.length - 1; i > 0; i--) {
			if (p[i - 1] < p[i]) {
				I = i - 1;
				break;
			}
		}

		for (int j = p.length - 1; j > 0; j--) {
			if (p[I] < p[j]) {
				J = j;
				break;
			}
		}

		if (I == 0 && J == 0) {
			return false;
		}

		int temp = p[I];
		p[I] = p[J];
		p[J] = temp;

		for (int i = I + 1; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i] > p[j]) {
					temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
			}
		}
		return true;
	}

}
