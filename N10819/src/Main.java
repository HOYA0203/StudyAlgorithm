/**
 * N10819 - 차이를 최대로
 * https://www.acmicpc.net/problem/10819
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N];
		int output = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);	// sort!!
		do {
			if(output < calc()) {
				output = calc();
			}
		} while (next_permutation());
		System.out.println(output);

	}

	static int calc() {
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {	// arr.length - 1 -> time over
			sum += Math.abs(arr[i-1] - arr[i]);
		}
		return sum;
	}

	static boolean next_permutation() {
		int I = 0;
		int J = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				I = i - 1;
				break;
			}
		}

		for (int j = arr.length - 1; j > 0; j--) {
			if (arr[I] < arr[j]) {
				J = j;
				break;
			}
		}
		if (I == 0 && J == 0) {
			return false;
		}

		int temp = arr[J];
		arr[J] = arr[I];
		arr[I] = temp;
		for (int i = I + 1; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp2 = arr[i];
					arr[i] = arr[j];
					arr[j] = temp2;
				}
			}
		}
		return true;
	}
}
