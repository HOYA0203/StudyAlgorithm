/**
 * N14888 - 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> cal;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] calCnt = new int[4];
		cal = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			calCnt[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			while (calCnt[i] != 0) {
				if (i == 0) {
					cal.add(1);
				} else if (i == 1) {
					cal.add(2);
				} else if (i == 2) {
					cal.add(3);
				} else if (i == 3) {
					cal.add(4);
				}
				calCnt[i]--;
			}
		}

		int sum;
		int Max = Integer.MIN_VALUE;
		int Min = Integer.MAX_VALUE;
		do {
			sum = 0;
			sum += arr[0];
			for (int j = 1; j < arr.length; j++) {
				if (cal.get(j - 1) == 1) {
					sum += arr[j];
				}
				if (cal.get(j - 1) == 2) {
					sum -= arr[j];
				}
				if (cal.get(j - 1) == 3) {
					sum *= arr[j];
				}
				if (cal.get(j - 1) == 4) {
					sum /= arr[j];
				}
			}
			if (Max < sum)
				Max = sum;
			if (Min > sum)
				Min = sum;
		} while (next_permutation());
		System.out.println(Max + " " + Min);
	}

	public static boolean next_permutation() {
		int I = 0, J = 0;
		int tmp = 0;

		for (int i = cal.size() - 1; i > 0; i--) {
			if (cal.get(i - 1) < cal.get(i)) {
				I = i - 1;
				break;
			}
		}

		for (int j = cal.size() - 1; j > I; j--) {
			if (cal.get(I) < cal.get(j)) {
				J = j;
				break;
			}
		}
		if (I == 0 && J == 0) {
			return false;
		}

		tmp = cal.get(I);
		cal.set(I, cal.get(J));
		cal.set(J, tmp);

		cal.subList(I + 1, cal.size()).sort(null);

		return true;
	}
}
