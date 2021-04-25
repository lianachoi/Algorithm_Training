import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M1_05 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int[][] land = new int[4][8];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max_05 = 0;
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				
				if (land[i][j] != 0) {
					
					for (int row_size = 0; row_size < land.length-i; row_size++) {
						for (int col_size = 0; col_size < land[i].length-j; col_size++) {
							
							int land_05 = 0;
							boolean rect = true;
							for (int k = i; k < i + row_size + 1 ; k++) {
								for (int k2 = j; k2 < j + col_size + 1; k2++) {
									land_05 += land[k][k2];
									if (land[k][k2] == 0) {
										rect = false;
									}
								}
								if (rect && max_05 < land_05) {
									max_05 = land_05;
								}
							}
						}
					}
				}
			}
		}
		bw.write(max_05+"");
		br.close();
		bw.close();
	}

}
