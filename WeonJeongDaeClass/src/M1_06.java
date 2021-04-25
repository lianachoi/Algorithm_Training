import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M1_06 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int[] c = new int[91]; 
		for (int i = 0; i < str.length(); i++) {
			c[str.charAt(i)] = 1;
		}
		for (int i = 0; i < c.length; i++) {
			if (c[i] != 0) {
				bw.write((char)i);
			}
		}
		
		br.close();
		bw.close();
	}

}
