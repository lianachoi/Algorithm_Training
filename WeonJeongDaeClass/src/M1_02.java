import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M1_02 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Height = Integer.parseInt(st.nextToken());
		int Width = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < Height; i++) {
			String str =  new String(br.readLine());
			int cnt = 0;
			for (int j = 0; j < Width; j++) {
				if (str.charAt(j)-'0' > 0) {
					cnt++;
				}	
			}
			bw.write(cnt+"\n");
		}
		br.close();
		bw.close();
	}

}
