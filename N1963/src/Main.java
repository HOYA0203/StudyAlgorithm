/**
 * N1963 - 소수경로
 * https://www.acmicpc.net/problem/1963
 * 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] pri = new int[10001];
		ArrayList<Integer> p = new ArrayList();

		for (int i = 0; i < pri.length; i++) {
			pri[i] = i;
		}

		for (int i = 2; i < pri.length; i++) {
			if (pri[i] == 0)
				continue;

			for (int j = i + i; j < pri.length; j += i) {
				pri[j] = 0;
			}

			if (pri[i] >= 1000) {
				p.add(i);
			}
		}

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int fir = sc.nextInt();
			int sec = sc.nextInt();

			boolean[] visit = new boolean[10001];
			int[] dist = new int[10001];
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(fir);
			visit[fir] = true;

			while (!q.isEmpty()) {
				int now = q.poll();
				for (int j = 1; j < 5; j++) {
					for (int k = 0; k < 10; k++) {
						int next = change(now, j, k); // !!
						if (p.contains(next) && !visit[next]) {
							q.offer(next);
							dist[next] = dist[now] + 1;
							visit[next] = true;
						}
					}
				}
			}
			System.out.println(dist[sec]);
		}
	}

	public static int change(int num, int seq, int nNum) {
		if (seq == 1) {
			num = nNum * 1000 + num % 1000;
		}
		if (seq == 2) {
			num = (num / 1000) * 1000 + nNum * 100 + num % 100;
		}
		if (seq == 3) {
			num = (num / 100) * 100 + nNum * 10 + num % 10;
		}
		if (seq == 4) {
			num = (num / 10) * 10 + nNum;
		}
		return num;
	}
}
