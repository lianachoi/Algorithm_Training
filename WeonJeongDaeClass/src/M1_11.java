import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M1_11 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int window_size = Integer.parseInt(br.readLine());
			int[] arr = new int[123];
			String msg = br.readLine();
			String valid = " PASS";
			for (int j = 0; j < msg.length(); j++) {
				arr[msg.charAt(j)]++;
				if (j >= window_size) {
					arr[msg.charAt(j-window_size)]--;
				}
				if(arr[msg.charAt(j)]>1) {
					valid = " FAIL";
					break;
				}
			}
			bw.write("#"+i+valid+"\n");
		}
		
		br.close();
		bw.close();
	}

}
