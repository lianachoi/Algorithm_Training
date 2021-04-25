import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M1_09 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			st =  new StringTokenizer(br.readLine());
			int[] subject = new int[N];
			for (int j = 0; j < N; j++) {
				subject[j] = Integer.parseInt(st.nextToken());
			}

			int score = 0;
			for (int j2 = 0; j2 < W; j2++) {
				score += subject[j2]; 
			}
			int[] best = {0, score};
			for (int j = 1; j <= subject.length-W; j++) {
				score -= subject[j-1];
				score += subject[j+W-1];
				if (best[1] < score) {
					best[0] = j;
					best[1] = score;
				}
				
			}
			bw.write("#"+(i+1)+" "+best[0]+" "+(best[0]+W-1)+" "+best[1]+"\n");
		}
		br.close();
		bw.close();
	}

}
