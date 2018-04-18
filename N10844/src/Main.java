
/**
 * N10844 - 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long[][] d = new long[N + 1][10];

		for (int i = 1; i < 10; i++) {
			d[1][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j >= 1) {
					d[i][j] += d[i - 1][j - 1];
				}
				if (j <= 8) {
					d[i][j] += d[i - 1][j + 1];
				}
				d[i][j] %= 1000000000L;
			}
		}

		long sum = 0;
		for (int j = 0; j < 10; j++) {
			sum += d[N][j];
		}

		System.out.println(sum %= 1000000000L);

	}

}
