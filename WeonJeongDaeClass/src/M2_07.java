import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class M2_07 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> scores_max = new PriorityQueue<Integer>();
		PriorityQueue<Integer> scores_min = new PriorityQueue<Integer>(Collections.reverseOrder());
		scores_min.add(500);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int score1 = Integer.parseInt(st.nextToken());
			int score2 = Integer.parseInt(st.nextToken());
			if (score1 > score2) {
				scores_max.add(score1);
				scores_min.add(score2);
			}else {
				scores_max.add(score2);
				scores_min.add(score1);
			}
			if (scores_max.peek() < scores_min.peek()) {
				scores_min.add(scores_max.poll());
				scores_max.add(scores_min.poll());
			}
			bw.write(scores_min.peek()+"\n");
		}
		br.close();
		bw.close();
	}

}
