import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M4_05 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//A = 65
	static int[] indian = new int[26];
	
	static void Union(int A, int B) {
		int Find_B = Find(B);
		int Find_A = Find(A);
		if(Find_B != Find_A) indian[Find_B] = Find_A;
	}
	
	static int Find(int A) {
		if(indian[A] == A) return A;
		return indian[A] = Find(indian[A]);
	}
	public static void main(String[] args) throws IOException {
		int [] team = new int[26];
		for (int i = 0; i < 26; i++) {
			indian[i] = i;
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = st.nextToken().charAt(0)-'A';
			int B = st.nextToken().charAt(0)-'A';
			Union(A, B);
		}
		int team_num = 0;
		int solo = 0;
		for (int i = 0; i < indian.length; i++) {
			int Find_I = Find(i);
			if(i == Find_I) {
				solo++;
			} 
			team[indian[i]]++; 
		}
		for (int i = 0; i < team.length; i++) {
			if (team[i]>1) {
				team_num++;
			}
		}
		bw.write((team_num)+"\n");
		bw.write((solo-team_num)+"");
		br.close();
		bw.close();
	}

}
