import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Frog implements Comparable<Frog> {
	int y;
	int x;
	int cnt;

	Frog(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Frog o) {
		if (this.y > o.y)
			return -1;
		if (this.y < o.y)
			return 1;

		if (this.cnt < o.cnt)
			return -1;
		if (this.cnt > o.cnt)
			return 1;
		return 0;
	}
}

public class M2_PLUS2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());

		int[][] Map = new int[height + 2][width + 2];
		Arrays.fill(Map[height + 1], 1);
		
		int[][] Map_max = new int[height + 2][width + 2];
		for (int i = 0; i < Map_max.length; i++) {
			Arrays.fill(Map_max[i], Integer.MIN_VALUE);
		}
		
		for (int i = 1; i <= height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= width; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<Frog> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(new Frog(1, 1, Map[1][1]));
		int max = Integer.MIN_VALUE;
		for (int i = 2; i < height + 2; i++) {
			while (i - 1 == pq.peek().y) {
				Frog now = pq.poll();
				for (int j = -1; j <= 1; j++) {
					if (Map[now.y + 1][now.x + j] != 0
							&& Map[now.y + 1][now.x + j]+now.cnt > Map_max[now.y + 1][now.x + j]) {
						pq.add(new Frog(now.y + 1, now.x + j, now.cnt + Map[now.y + 1][now.x + j]));
						Map_max[now.y + 1][now.x + j] = Map[now.y + 1][now.x + j]+now.cnt;
					}
					if (now.y + 1 == height)
						continue;
				}
				if (now.y == height && now.cnt > max) {
					max = now.cnt;
					pq.clear();
					break;
				}
			}
		}

		bw.write(max + "");
		br.close();
		bw.close();
	}

}
