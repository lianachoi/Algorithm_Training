import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class M2_06 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		long [] ugly_nums = new long[1501];
		pq.add((long) 1);
		int a = 0;
		long pre = 0;
		while(true) {
			if(a > 1500) {
				break;
			}
			long now = pq.poll();

			if (now == pre) {
				continue;
			}
			ugly_nums[a++] = now;
			pre = now;
			pq.add(now*2);
			pq.add(now*3);
			pq.add(now*5);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			bw.write(ugly_nums[Integer.parseInt(st.nextToken())-1] + " ");
		}
		br.close();
		bw.close();
	}
}
