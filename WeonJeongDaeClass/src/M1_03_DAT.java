import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * DAT ÀÌ¿כ
 */
public class M1_03_DAT {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(br.readLine());
		String[][] EmpList= new String[9000][2];
		for (int i = 0; i < a; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			if (type == 1) {
				int num = Integer.parseInt(st.nextToken());
				if (EmpList[num-1000][0] == null) {
					EmpList[num-1000][0] = st.nextToken();
					EmpList[num-1000][1] = "ENTER";
					bw.write(num + " OK\n");
				} else {
					bw.write(num + " ERROR\n");
					
				}
			}else if (type == 2) {
				int num = Integer.parseInt(st.nextToken());
				if (EmpList[num-1000][0] == null) {
					bw.write(num + " ERROR\n");
				} else {
					if (EmpList[num-1000][1].equals("ENTER")) {
						bw.write(num+" "+EmpList[num-1000][0]+" "+EmpList[num-1000][1]+"\n");
						EmpList[num-1000][1] = "EXIT";
					} else {
						bw.write(num+" "+EmpList[num-1000][0]+" "+EmpList[num-1000][1]+"\n");
						EmpList[num-1000][1] = "ENTER";
						
					}
				}
			}
		}
		br.close();
		bw.close();
	}

}
