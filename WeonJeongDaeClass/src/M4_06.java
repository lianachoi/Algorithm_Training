import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M4_06 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] connection;
	static String status = "STABLE";
	
	static void Union(int A, int B) {
		int Find_B = Find(B);
		int Find_A = Find(A);
		if(Find_B != Find_A) connection[Find_B] = Find_A;
		else status = "WARNING";
	}
	
	static int Find(int A) {
		if(connection[A] == A) return A;
		return connection[A] = Find(connection[A]);
	}
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		int[][] Circuit = new int[N+2][N+2];
		connection = new int[N+1];
		for (int i = 1; i <= N; i++) {
			connection[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				Circuit[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if (Circuit[i][j] == 1) {
					Union(i, j);
				}
			}
		}
		bw.write(status);
		br.close();
		bw.close();
	}

}
