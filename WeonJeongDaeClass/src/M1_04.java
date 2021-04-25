import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M1_04 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		char[] book = new char[Y*X];
		for (int i = 0; i < Y; i++) {
			String str = br.readLine();
			for (int j = 0; j < X; j++) {
				book[i*X+j] = str.charAt(j);
			}
		}
		int num = Integer.parseInt(br.readLine());
		String qoute = br.readLine();
		String out = "";
		for (int i = 0; i < book.length-num+1; i++) {
			if (book[i] == qoute.charAt(0)) {
				for (int j = 0; j < num; j++) {
					if (book[i+j] != qoute.charAt(j)) {
						out = "";
						break;
					}
					out = "("+(i/X)+","+(i%X)+")\n";
				}
				bw.write(out);
			}
		}
		br.close();
		bw.close();
	}

}
