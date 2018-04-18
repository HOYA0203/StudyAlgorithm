/**
 * N10818 - 최대, 최소
 * https://www.acmicpc.net/problem/10818
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int value = 0;
		for (int i = 0; i < t; i++) {
			value = sc.nextInt();
			if (value > max) {
				max = value;
			}
			if (value < min) {
				min = value;
			}
		}
		System.out.println(min + " " + max);
	}

}
