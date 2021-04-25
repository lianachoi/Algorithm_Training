import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bomb implements Comparable<Bomb>{
	int sec;
	int x;
	int y;
	public Bomb(int sec, int x, int y) {
		this.sec = sec;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Bomb o) {
		if (this.sec > o.sec) return 1;
		if (this.sec < o.sec) return -1;
		return 0;
	}
	
}

public class M2_08 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] bombs = new int[N][N];
		PriorityQueue<Bomb> pq = new PriorityQueue<Bomb>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				bombs[i][j] = Integer.parseInt(st.nextToken());
				Bomb bomb = new Bomb(bombs[i][j],i,j);
				pq.add(bomb);
			}
		}
		Bomb bomb;
		int total = 0;
		while (!pq.isEmpty()) {
			bomb = pq.poll();
			if (bombs[bomb.x][bomb.y] != 0) {
				total = bomb.sec;  
			
				bombs[bomb.x][bomb.y] = 0;
				if (bomb.x>0) {
					bombs[bomb.x-1][bomb.y] = 0;
				}
				if (bomb.y>0) {
					bombs[bomb.x][bomb.y-1] = 0;
				}
				if (bomb.y<N-1) {
					bombs[bomb.x][bomb.y+1] = 0;
				}
				if (bomb.x<N-1) {
					bombs[bomb.x+1][bomb.y] = 0;
				}
			}
		}
		bw.write(total+"ÃÊ");
		br.close();
		bw.close();
	}

}
