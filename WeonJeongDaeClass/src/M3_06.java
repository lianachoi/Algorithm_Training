import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class route{
	int y;
	int x;
	int cnt;
	route(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}
public class M3_06 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		
		int[][] Map = { {1,1,1,1,1,1,1},
						{1,0,0,0,0,1,1},
						{1,1,0,1,0,0,1},
						{1,0,0,0,0,1,1},
						{1,1,1,1,1,1,1},
				      };
		int [] move_y = {-1, 0, 1, 0,};
		int [] move_x = { 0, 1, 0,-1,};
		int [] mouse_start = {1,1,0};
		int cnt = 0;
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target_y = Integer.parseInt(st.nextToken())+1; 
			int target_x = Integer.parseInt(st.nextToken())+1; 
			
			Queue<route> q = new LinkedList<>();
			
			q.add(new route(mouse_start[1],mouse_start[0],mouse_start[2]));
			int[][] check = new int[5][7];
			while (!q.isEmpty()) {
				route now = q.poll();
				for (int j = 0; j < move_x.length; j++) {
					int y = now.y+move_y[j];
					int x = now.x+move_x[j];
					if (check[y][x] == 0 && Map[y][x] == 0) {
						if (y == target_y && x == target_x) {
							mouse_start[0] = target_y;
							mouse_start[1] = target_x;
							mouse_start[2] = now.cnt;
							continue;
						}
						check[y][x] = 1;
						q.add(new route(y,x,now.cnt+1));
					}
				}
				
			}
		}
		bw.write(mouse_start[2]+"");
		br.close();
		bw.close();
	}

}
