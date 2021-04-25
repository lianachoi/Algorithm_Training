import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M3_01 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int [][] Map = new int [N][N];
//		ArrayList<ArrayList<Integer>> love = new ArrayList<ArrayList<Integer>>(); 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
//			love.add(new ArrayList<>());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				Map[i][j] = num;
//				if (num>0) {
//					love.get(i).add(j);
//				}
			}
		}
		int min_cnt = Integer.MAX_VALUE;
		int max_cnt = Integer.MIN_VALUE;
		int min_col = -1;
		int max_col = -1;
		for (int col = 0; col < Map.length; col++) {
			int cnt = 0;
			for (int row = 0; row < N ; row++) {
				if (Map[row][col] >0) {
					cnt++;
				}
			}
			if (max_cnt<cnt) {
				max_cnt = cnt;
				max_col = col;
			}
			if (min_cnt>cnt) {
				min_cnt = cnt;
				min_col = col;
			}
		}
		bw.write(max_col+" "+min_col);
		br.close();
		bw.close();
	}

}
