import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class M4_02 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {	
		int n = Integer.parseInt(br.readLine());
		
		int s = 1;
		int e = 3163;
		
		int answer = 0;
		
		while (s<e) {
			int mid = (s+e)/2;
			if (mid*mid > n) {
				e = mid-1;
				if ((mid-1)*(mid-1) < n) {
					answer = mid-1;		
					break;
				}
			}else if (mid*mid < n) {
				s = mid+1;
				if ((mid+1)*(mid+1) > n) {
					answer = mid;		
					break;
				}
			}else {
				answer = mid;
				break;
			}			
		}
		bw.write(answer +"");
		br.close();
		bw.close();
	}

}
