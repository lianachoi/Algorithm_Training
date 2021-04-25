import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int Elsa_r, Elsa_c;
	int Anna_r, Anna_c;
	Node(int Elsa_r, int Elsa_c, int Anna_r, int Anna_c){
		this.Elsa_r = Elsa_r;
		this.Elsa_c = Elsa_c;
		this.Anna_r = Anna_r;
		this.Anna_c = Anna_c;
	}
}

public class M3_08 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		char[][] Map = new char[N+2][N+2];
		
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= s.length(); j++) {
				char temp =  s.charAt(j-1);
				if (temp == '_') {
					Map[i][j] = temp;
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] Elsa = {Integer.parseInt(st.nextToken())+1,Integer.parseInt(st.nextToken())+1};
		int[] Anna = {Integer.parseInt(st.nextToken())+1,Integer.parseInt(st.nextToken())+1};
		
		int[][][][] check = new int[N+2][N+2][N+2][N+2];
		
		
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(Elsa[0], Elsa[1],Anna[0],Anna[1]));
		check[Elsa[0]][Elsa[1]][Anna[0]][Anna[1]] = 1;
		
		int dr[] = {-1,1,0, 0,0};
		int dc[] = { 0,0,1,-1,0};
		int num = 0;
		while (!q.isEmpty()) {
			Node now = q.poll();
			int now_Elsa_r = now.Elsa_r;
			int now_Elsa_c = now.Elsa_c;
			int now_Anna_r = now.Anna_r;
			int now_Anna_c = now.Anna_c;
			
			if (now_Elsa_r == now_Anna_r && now_Elsa_c == now_Anna_c) {
				bw.write(check[now_Elsa_r][now_Elsa_c][now_Anna_r][now_Anna_c]-1+"");
				q.clear();
				continue;
			}
			for (int i = 0; i < 5; i++) {
				int next_Elsa_r = now_Elsa_r + dr[i];
				int next_Elsa_c = now_Elsa_c + dc[i];
				if ((int)Map[next_Elsa_r][next_Elsa_c] == 0) {
					continue;
				}
				
				for (int j = 0; j < 5; j++) {
					int next_Anna_r = now_Anna_r + dr[j];
					int next_Anna_c = now_Anna_c + dc[j];
					if ((int)Map[next_Anna_r][next_Anna_c] == 0) {
						continue;
					}
					if (check[next_Elsa_r][next_Elsa_c][next_Anna_r][next_Anna_c] == 0
							&& Map[next_Elsa_r][next_Elsa_c] == '_'
							&& Map[next_Anna_r][next_Anna_c] == '_') {
						q.add(new Node(next_Elsa_r, next_Elsa_c,next_Anna_r,next_Anna_c));
						check[next_Elsa_r][next_Elsa_c][next_Anna_r][next_Anna_c] 
								= check[now_Elsa_r][now_Elsa_c][now_Anna_r][now_Anna_c]+1;
					}
				}
			}
		}
		
		br.close();
		bw.close();
	}

}
