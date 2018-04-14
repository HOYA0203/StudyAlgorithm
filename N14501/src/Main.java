/**
 * N14501
 * https://www.acmicpc.net/problem/14501
 * 
 */
import java.util.Scanner;

public class Main {
	static int res = 0;
	static int N;
	static int[] t;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		t = new int[N];
		p = new int[N];

		for (int i = 0; i < N; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		calc(0, 0);
		System.out.println(res);
	}

	public static void calc(int sum, int index) {
		if (index == N) {
			if (res < sum) {
				res = sum;
			}
			return;
		}

		if (index > N) {
			return;
		}

		calc(sum, index + 1); // 상담 안한다.
		calc(sum + p[index], index + t[index]); // 상담한다.
	}
}
