/**
 * N14891 - 톱니바퀴
 * https://www.acmicpc.net/problem/14891
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = null;
		int[] A1 = new int[8];
		int[] A2 = new int[8];
		int[] A3 = new int[8];
		int[] A4 = new int[8];

		line = sc.nextLine();
		for (int j = 0; j < 8; j++) {
			A1[j] = Integer.parseInt(line.substring(0 + j, 1 + j));
		}
		line = sc.nextLine();
		for (int j = 0; j < 8; j++) {
			A2[j] = Integer.parseInt(line.substring(0 + j, 1 + j));
		}
		line = sc.nextLine();
		for (int j = 0; j < 8; j++) {
			A3[j] = Integer.parseInt(line.substring(0 + j, 1 + j));
		}
		line = sc.nextLine();
		for (int j = 0; j < 8; j++) {
			A4[j] = Integer.parseInt(line.substring(0 + j, 1 + j));
		}

		int K = sc.nextInt();
		int num = 0, dir = 0;
		for (int i = 0; i < K; i++) {
			num = sc.nextInt();
			dir = sc.nextInt();

			if (num == 1) {
				if (A1[2] != A2[6]) {
					if (A2[2] != A3[6]) {
						if (A3[2] != A4[6]) {
							if (dir == 1) shift(A4, -1);
							else if (dir == -1) shift(A4, 1);
						}
						if (dir == 1) shift(A3, 1);
						else if (dir == -1) shift(A3, -1);
					}
					if (dir == 1) shift(A2, -1);
					else if (dir == -1) shift(A2, 1);
				}
				if (dir == 1) shift(A1, 1);
				else if (dir == -1) shift(A1, -1);
			}

			if (num == 2 && dir == 1) {
				if (A1[2] != A2[6]) {
					// shift
					shift(A1, -1);
				}
				if (A2[2] != A3[6]) {
					// shift
					if (A3[2] != A4[6]) {
						// shift
						shift(A4, 1);
					}
					shift(A3, -1);
				}
				shift(A2, 1);
			}

			if (num == 2 && dir == -1) {
				if (A1[2] != A2[6]) {
					// shift
					shift(A1, 1);
				}
				if (A2[2] != A3[6]) {
					// shift
					if (A3[2] != A4[6]) {
						// shift
						shift(A4, -1);
					}
					shift(A3, 1);
				}
				shift(A2, -1);
			}

			if (num == 3 && dir == 1) {
				if (A2[2] != A3[6]) {
					// shift
					if (A1[2] != A2[6]) {
						// shift
						shift(A1, 1);
					}
					shift(A2, -1);
				}
				if (A3[2] != A4[6]) {
					// shift
					shift(A4, -1);
				}
				shift(A3, 1);
			}

			if (num == 3 && dir == -1) {
				if (A2[2] != A3[6]) {
					// shift
					if (A1[2] != A2[6]) {
						// shift
						shift(A1, -1);
					}
					shift(A2, 1);
				}
				if (A3[2] != A4[6]) {
					// shift
					shift(A4, 1);
				}
				shift(A3, -1);
			}

			if (num == 4 && dir == 1) {
				if (A3[2] != A4[6]) {
					// shift
					if (A2[2] != A3[6]) {
						// shift
						if (A1[2] != A2[6]) {
							// shift
							shift(A1, -1);
						}
						shift(A2, 1);
					}
					shift(A3, -1);
				}
				shift(A4, 1);
			}

			if (num == 4 && dir == -1) {
				if (A3[2] != A4[6]) {
					// shift
					if (A2[2] != A3[6]) {
						// shift
						if (A1[2] != A2[6]) {
							// shift
							shift(A1, 1);
						}
						shift(A2, -1);
					}
					shift(A3, 1);
				}
				shift(A4, -1);
			}
		}

		int sum = A1[0] * 1 + A2[0] * 2 + A3[0] * 4 + A4[0] * 8;
		// if (A1[0] == 1)
		// sum += 1;
		// if (A2[0] == 1)
		// sum += 2;
		// if (A3[0] == 1)
		// sum += 4;
		// if (A4[0] == 1)
		// sum += 8;

		System.out.println(sum);
	}

	public static int[] shift(int[] Anum, int dir) {
		int[] arr = Anum;
		if (dir == -1) {
			int first = arr[0];
			for (int i = 1; i < 8; i++) {
				arr[i - 1] = arr[i];
			}
			arr[arr.length - 1] = first;
		}

		if (dir == 1) {
			int last = arr[7];
			for (int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = last;
		}

		return arr;
	}
	//
	// public static int[] leftShift(int[] Anum) {
	// int[] arr = Anum;
	// int first = arr[0];
	// for (int i = 1; i < 8; i++) {
	// arr[i - 1] = arr[i];
	// }
	// arr[arr.length - 1] = first;
	//
	// return arr;
	// }
	//
	// public static int[] rightShift(int[] Anum) {
	// int[] arr = Anum;
	// int last = arr[7];
	// for (int i = arr.length - 1; i > 0; i--) {
	// arr[i] = arr[i - 1];
	// }
	// arr[0] = last;
	//
	// return arr;
	// }
}
