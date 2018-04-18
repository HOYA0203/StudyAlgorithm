/**
 * N10950 A+B=3
 * https://www.acmicpc.net/problem/10950
 * 
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = 0;
		int[][] num;
		testCase = sc.nextInt();
		num = new int[testCase][2];
		for(int i = 0; i<testCase; i++) {
			num[i][0] = sc.nextInt();
			num[i][1] = sc.nextInt();
		}
		for(int i = 0; i<testCase; i++) {
			System.out.println(num[i][0] + num[i][1]);
		}
	}
}
