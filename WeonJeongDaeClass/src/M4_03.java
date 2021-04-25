import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class M4_03 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String fuel = br.readLine();
			int s = 0;
			int e = fuel.length();
			int index = -1;
			
			while (s<e) {
				int mid = (s+e)/2;
				if (fuel.charAt(mid) == '#') {
					s = mid+1;
					index = mid;
				}else if (fuel.charAt(mid) == '_') {
					e = mid-1;
				}
				
			}
			bw.write((index+1)*100/fuel.length()+"%\n");
			
			
		}
		br.close();
		bw.close();
	}

}
