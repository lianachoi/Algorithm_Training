import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Mather_in_law implements Comparable<Mather_in_law>{
	int Y;
	int X;
	int dist;
	public Mather_in_law(int Y, int X, int dist) {
		this.Y = Y;
		this.X = X;
		this.dist = dist;
	}
	@Override
	public int compareTo(Mather_in_law o) {
		if(this.dist > o.dist) return 1;
		if(this.dist < o.dist) return -1;
		
		return 0;
	}
}
public class M5_02 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken())+1;
		int X = Integer.parseInt(st.nextToken())+1;
		int N = Integer.parseInt(br.readLine());
		int [][] Map = new int [N+2][N+2];
		int [][] check = new int [N+2][N+2];
		Arrays.fill(Map[0], -1);
		Arrays.fill(Map[N+1], -1);
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(Map[i], -1);			
			for (int j = 1; j <= N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		for (int i = 0; i < check.length; i++) {
			Arrays.fill(check[i], 123456789);
		}
		check[Y][X] = Map[Y][X];
		PriorityQueue<Mather_in_law> mil = new PriorityQueue<>();
		mil.add(new Mather_in_law(Y, X, Map[Y][X]));
		
		int[] move_y = {-1, 0, 1, 0};
		int[] move_x = { 0, 1, 0, -1};
		int max = Integer.MIN_VALUE;
		while(!mil.isEmpty()) {
			Mather_in_law now = mil.poll();
			int now_y = now.Y;
			int now_x = now.X;
			for (int i = 0; i < move_x.length; i++) {
				int next_y = now_y+move_y[i];
				int next_x = now_x+move_x[i];
				if (Map[next_y][next_x]>-1 
						&& check[next_y][next_x] == 123456789
						&& check[next_y][next_x] >= check[now_y][now_x]+Map[next_y][next_x]) {
					check[next_y][next_x] = check[now_y][now_x]+Map[next_y][next_x];
					mil.add(new Mather_in_law(next_y, next_x, check[next_y][next_x]));
					if (check[next_y][next_x]  > max) {
						max = check[next_y][next_x] ;
					}
				}
			}
			
		}
		bw.write(max+"");
		br.close();
		bw.close();
	}

}
