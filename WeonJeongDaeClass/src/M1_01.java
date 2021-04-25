import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M1_01 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(br.readLine());
		switch (a) {
		case 1:
			a = Integer.parseInt(br.readLine());
			int sum = 0;
			long multi = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < a; i++) {
				int b = Integer.parseInt(st.nextToken());
				sum += b;
				multi *= b;
			}
			bw.write(sum + " " + multi);
			br.close();
			bw.close();
			break;
		case 2:
			a = Integer.parseInt(br.readLine());
			int min = 100;
			int max = 0;
			String minStr = null;
			String maxStr = null;
			for (int i = 0; i < a; i++) {
				String str = new String(br.readLine());
				if (str.length() > max) {
					maxStr = str;
					max = str.length();
				} 
				if (str.length()<min) {
					minStr = str;
					min = str.length();
				}
			}
			bw.write(maxStr + "\n");
			bw.write(minStr);
			br.close();
			bw.close();
			break;
		case 3:
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st1.nextToken());
			int Y = Integer.parseInt(st1.nextToken());
			int min1 = 101;
			int cnt = 0;
			for (int i = 0; i < X; i++) {
				 st1 = new StringTokenizer(br.readLine());
				for (int j = 0; j < Y; j++) {
					 int curnum = Integer.parseInt(st1.nextToken());
					 if (min1>curnum) {
						min1 = curnum;
						cnt = 1;
					}else if (min1 == curnum) {
						cnt++;
					}
				}
			}
			bw.write(min1 + "\n");
			bw.write(cnt + "°³");
			br.close();
			bw.close();
			break;

		default:
			break;
		}
	}
}
