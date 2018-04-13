/**
 * N1697
 * https://www.acmicpc.net/problem/1697
 * @author TAEHO
 *
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int MAX = 100000;
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[] visit = new boolean[MAX + 1];
		int[] dist = new int[MAX + 1];

		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(n);
		visit[n] = true;
		while (!q.isEmpty()) {
			int next = q.poll();
			if (next + 1 <= MAX) {
				if (!visit[next + 1]) {
					dist[next + 1] = dist[next] + 1;
					visit[next + 1] = true;
					q.offer(next + 1);
				}
			}

			if (next * 2 <= MAX) {
				if (!visit[next * 2]) {
					dist[next * 2] = dist[next] + 1;
					visit[next * 2] = true;
					q.offer(next * 2);
				}
			}

			if (next - 1 >= 0) {
				if (!visit[next - 1]) {
					dist[next - 1] = dist[next] + 1;
					visit[next - 1] = true;
					q.offer(next - 1);
				}
			}
		}
		System.out.println(dist[k]);
	}
}
