import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node1 implements Comparable<Node1>{
	int to;
	int dist;
	Node1(int to, int dist){
		this.to = to;
		this.dist = dist;
	}
	@Override
	public int compareTo(Node1 o) {
		if(this.dist > o.dist) return 1;
		if(this.dist < o.dist) return -1;
		
		return 0;
	}
}
public class M5_01 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node1>> al = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			al.add(new ArrayList<Node1>());
		}
				
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			al.get(a).add(new Node1(b,dist));
		}
		
		int [] Dist = new int[N];
		Arrays.fill(Dist, Integer.MAX_VALUE);
		Dist[0] = 0;
		PriorityQueue<Node1> pq = new PriorityQueue<>();
		
		pq.add(new Node1(0,0));
		
		while (!pq.isEmpty()) {
			Node1 now = pq.poll();
			int now_to = now.to;
			int now_dist = now.dist;
			for (int i = 0; i < al.get(now_to).size(); i++) {
				Node1 next = al.get(now_to).get(i);
				int next_to = next.to;
				int next_dist = next.dist;
				if (Dist[next_to] > Dist[now_to] + next_dist) {
					Dist[next_to] = Dist[now_to] + next_dist;
					pq.add(new Node1(next_to, Dist[next_to]));
				}
			}
		}
		if (Dist[N-1] == Integer.MAX_VALUE) {
			bw.write("impossible");
		}else {
			bw.write(Dist[N-1]+"");
		} 
		br.close();
		bw.close();
	}

}
