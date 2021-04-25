import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class M2_04 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(schedule, new Comparator<int[]>(
				) {

					@Override
					public int compare(int[] o1, int[] o2) {
						if (o1[1]>o2[1]) return 1;
						if (o1[1]<o2[1]) return -1;
						return 0;
					}
		});
		int next_time = 0;
		int cnt_meetings = 1;
		next_time = schedule[0][1];
		for (int i = 1; i < schedule.length; i++) {
			if (schedule[i][0] >= next_time) {
				next_time = schedule[i][1];
				cnt_meetings++;
			}
		}
		
		bw.write(cnt_meetings+"");
		br.close();
		bw.close();
	}

}
