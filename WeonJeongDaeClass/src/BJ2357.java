import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class MinMax{
	int min;
	int max;
	public MinMax(int min, int max) {
		this.min = min;
		this.max = max;
	}
}
public class BJ2357 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static MinMax[] minmax;
	static int[] NumArr;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		NumArr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			NumArr[i] = Integer.parseInt(br.readLine());
		}
		//세그먼트 트리 계산
		minmax = new MinMax[(N+1) * 4];
		Init(1,N,1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//세그먼트트리 찾기
			MinMax ans = Find(1, N, 1, from, to);
			System.out.println(ans.min+" "+ans.max);
		}
		
		bw.close();
		br.close(); 

	}


	private static MinMax Find(int start, int end, int node, int from, int to) {
		if (to < start || end < from) {
			return new MinMax(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		if (from <= start && end <= to) {
			return minmax[node];
		}
		
		int mid = (start + end) / 2;
		MinMax half1 = Find(start,mid,node*2, from, to);
		MinMax half2 = Find(mid+1,end,node*2+1, from, to);
		int min = Math.min(half1.min, half2.min);
		int max = Math.max(half1.max, half2.max);
		return new MinMax(min, max);
	}


	private static MinMax Init(int start, int end, int node) {
		if (start == end) {
			return minmax[node] = new MinMax(NumArr[start],NumArr[end]);
		}
		int mid = (start+end)/2;
		MinMax half1 = Init(start,mid,node*2);
		MinMax half2 = Init(mid+1,end,node*2+1);
		int min = Math.min(half1.min, half2.min);
		int max = Math.max(half1.max, half2.max);
		return minmax[node] = new MinMax(min, max);
	}

}
