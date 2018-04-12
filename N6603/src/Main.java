/**
 * N6603 - 로또
 * https://www.acmicpc.net/problem/6603
 */
import java.util.Scanner;

public class Main {
	static int[] per;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K;
		while (true) {
			K = sc.nextInt();
			if (K == 0) {
				break;
			}
			int[] arr = new int[K];
			for (int i = 0; i < K; i++) {
				arr[i] = sc.nextInt();
			}

			per = new int[K];
			for (int i = 6; i < K; i++) {
				per[i] = 1;
			}

			do {
				for (int i = 0; i < K; i++) {
					if (per[i] == 0) {
						System.out.print(arr[i] + " ");
					}
				}
				System.out.println();
			} while (next_permutation());
			System.out.println();
		}
	}

	static boolean next_permutation() {
		int I = 0, J = 0;
		for (int i = per.length - 1; i > 0; i--) {
			if (per[i - 1] < per[i]) {
				I = i - 1;
				break;
			}
		}
		for (int j = per.length - 1; j > 0; j--) {
			if (per[I] < per[j]) {
				J = j;
				break;
			}
		}

		if (I == 0 && J == 0) {
			return false;
		}

		int temp = per[J];
		per[J] = per[I];
		per[I] = temp;

		for (int i = I + 1; i < per.length; i++) {
			for (int j = i + 1; j < per.length; j++) {
				if (per[i] > per[j]) {
					temp = per[i];
					per[i] = per[j];
					per[j] = temp;
				}
			}
		}
		return true;
	}
}
