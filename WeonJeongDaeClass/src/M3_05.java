import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Zombie{
	int y;
	int x;
	int vac;
	int day;
	Zombie(int y, int x, int day) {
		this.y = y;
		this.x = x;
		this.vac = 3;
		this.day = day;
	}
}

public class M3_05 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int[][] Map = new int[height+2][width+2];
		int[][] check = new int[height+2][width+2];
		for (int i = 1; i < height+1; i++) {
			String s = br.readLine();
			for (int j = 1; j < width+1; j++) {
				Map[i][j] = s.charAt(j-1) - '0';
			}
		}
		st = new StringTokenizer(br.readLine());
		int v_x = Integer.parseInt(st.nextToken());
		int v_y = Integer.parseInt(st.nextToken());

		int [] move_y = {-1, 0, 1, 0,};
		int [] move_x = { 0, 1, 0,-1,};
		
		Queue<Zombie> q = new LinkedList<Zombie>();
		q.add(new Zombie(v_y,v_x,0));
		int total = 0;
		while (!q.isEmpty()) {
			Zombie now = q.poll();

			now.vac--;
			now.day++;
			total = now.day;
			if (now.vac>0) {
				q.add(now);
				Map[now.y][now.x] = 0;
			}
			for (int i = 0; i < move_x.length; i++) {
				if (Map[now.y+move_y[i]][now.x+move_x[i]] == 1 
						&& check[now.y+move_y[i]][now.x+move_x[i]] == 0) {
						q.add(new Zombie(now.y+move_y[i],now.x+move_x[i],now.day));
						Map[now.y+move_y[i]][now.x+move_x[i]] = 0;	
						check[now.y+move_y[i]][now.x+move_x[i]] = 1;
				}
			}
		}
		bw.write(total+"\n");
		int not_cure = 0;
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if(Map[i][j] == 1) not_cure++;
			}
		}
		bw.write(not_cure+"\n");
		br.close();
		bw.close();
	}

}
