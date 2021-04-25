import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Flower{
	int y;
	int x;
	Flower(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class M3_04 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int [][] garden = new int [height][width];
		int [] move_y = {-1, 0, 1, 0,};
		int [] move_x = { 0, 1, 0,-1,};
		int [][] check = new int [height][width];
		int y = 0;
		int x = 0;
		Queue<Flower> q = new LinkedList<>();

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			garden[y][x] = 1;
			check[y][x] = 1;
			q.add(new Flower(y, x));
		}
		int total_day = 0;
		while (!q.isEmpty()) {
			Flower now = q.poll();
			total_day = check[now.y][now.x]; 
			if (garden[now.y][now.x] == 1) {
				garden[now.y][now.x]++;
				for (int i = 0; i < move_x.length; i++) {
					int next_y = now.y+move_y[i];
					int next_x = now.x+move_x[i];
					if (next_y < 0 || next_y >= height
						|| next_x < 0 || next_x >= width)
						continue;
					if (garden[next_y][next_x] < 2 
							&& check[next_y][next_x] == 0) {
						check[next_y][next_x] = check[now.y][now.x]+1;
						q.add(new Flower(next_y, next_x));
						garden[next_y][next_x]++;
							
					}
				}
			}
		}
		bw.write(total_day+"");
		br.close();
		bw.close();
	}

}
