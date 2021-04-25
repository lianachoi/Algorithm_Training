import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M3_03 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		char [][] Area = new char[4][5];
		for (int i = 0; i < Area.length; i++) {
			for (int j = 0; j < Area[i].length; j++) {
				Area[i][j] = '_';
			}
		}
		int [] move_y = {-1,-1, 0, 1, 1, 1, 0,-1};
		int [] move_x = { 0, 1, 1, 1, 0,-1,-1,-1};
		
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] bomb = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			for (int j = 0; j < move_x.length; j++) {
				if ((bomb[1]+move_x[j]) < 0 || (bomb[1]+move_x[j]) >= Area[0].length 
						||(bomb[0]+move_y[j]) < 0 ||(bomb[0]+move_y[j]) >= Area.length) {
					
				}else {
					Area[bomb[0]+move_y[j]][bomb[1]+move_x[j]] = '#';
				}
			}	
		}
		
		for (int i = 0; i < Area.length; i++) {
			for (int j = 0; j < Area[i].length; j++) {
				bw.write(Area[i][j]+" ");
			}
			bw.write("\n");
		}
				
		br.close();
		bw.close();
	}

}
