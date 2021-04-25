import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M1_10 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			int[] foods = new int[2*N];
			String good_setting = "YES";
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				foods[j] = num;
				foods[j+N] = num;
			}
			int[] food_window = new int[201];
			for (int j = 0; j <N + R ; j++) {
				food_window[foods[j]] += 1;
				if(j>=2*R+1) {
					food_window[foods[j-(2*R+1)]] -= 1;
				}
				if (food_window[foods[j]] > 2) {
					good_setting = "NO";
				}
			}
			bw.write("#"+(i+1)+" "+good_setting+"\n");
		}
		br.close();
		bw.close();
	}

}
