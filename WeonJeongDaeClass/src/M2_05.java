import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class M2_05 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
				
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if ("push".equals(cmd)) {
				pq.add(Integer.parseInt(st.nextToken()));
			}else if ("pop".equals(cmd)) {
				int B = Integer.parseInt(st.nextToken());
				for (int j = 0; j < B; j++) {
					bw.write(pq.poll()+" ");
				}
				bw.write("\n");
			}else if ("add".equals(cmd)) {
				int new_num = pq.poll()+Integer.parseInt(st.nextToken());
				pq.add(new_num);
			}
		}
		br.close();
		bw.close();
	}

}
