import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M1_08 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] students = new int[N];
			int[] cards = new int[N+1];
			String check = "YES";
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < students.length; j++) {
				students[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <students.length ; j++) {
				cards[students.length-Integer.parseInt(st.nextToken())+1] = students[j];
			}
			for (int j = cards.length -1 ; j > 0; j--) {
				if(cards[j] < cards[j-1]) {
					check = "NO";
					break;
				}
			}
			bw.write(check+"\n");
		}
		br.close();
		bw.close();
	}

}
