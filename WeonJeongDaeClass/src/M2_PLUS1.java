import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M2_PLUS1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int a = 0;
		int[] dx = {1,0};
		int[] dy = {0,1};
		int[] pos = {0,0};
		int[] right = new int[2];
		int[] down = new int[2];
		for (int i = 0; i < 2*map.length; i++) {
			right[0] = pos[0]+dy[0];
			right[1] = pos[1]+dx[0];
			down[0] = pos[0]+dy[1];  
			down[1] = pos[1]+dx[1];
			if (right[1]>=N && down[0]<N) {
				pos = down.clone();
				a += map[pos[0]][pos[1]];
				continue;
			}
			if (down[0]>=N && right[1]<N) {
				pos = right.clone();
				a += map[pos[0]][pos[1]];
				continue;
			}
			if (right[0]>=N || right[1]>=N || down[0]>=N || down[1]>=N) {
				break;
			}
			if (map[right[0]][right[1]] < map[down[0]][down[1]]) {
				pos = right.clone();
			}else {
				pos = down.clone();
			}
			a += map[pos[0]][pos[1]];
		}
		bw.write(a+"\n");
		br.close();
		bw.close();
	}

}
