import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class M3_02 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		int[] nArr = { 0, 1004, 1680, 9941, 3367, 3261, 2976, 4889, 1234, 6461, 7329, 5518 };
		
		ArrayList<ArrayList<Integer>> chart = new ArrayList<>(); 
		for (int i = 1; i <12 ; i++) {
			chart.add(new ArrayList<>());
		}
		
		chart.get(1).add(2);
		chart.get(1).add(3);
		chart.get(2).add(4);
		chart.get(2).add(5);
		chart.get(3).add(6);
		chart.get(3).add(7);
		chart.get(5).add(8);
		chart.get(5).add(9);
		chart.get(6).add(10);
		chart.get(6).add(11);
		
		int N = Integer.parseInt(br.readLine());
		int boss = 0;
		int company = 0;
		int[] junior = {0,0};
		for (int i = 1; i < chart.size(); i++) {
			for (int j = 0; j < chart.get(i).size(); j++) {
				if (nArr[chart.get(i).get(j)] == N) {
					boss = nArr[i];
					for (int j2 = 0; j2 < chart.get(i).size(); j2++) {
						if (nArr[chart.get(i).get(j2)] != N) {
							company = nArr[chart.get(i).get(j2)];
						}
					}
				}
				if (nArr[i] == N) {
					junior[j] = nArr[chart.get(i).get(j)];
				}
			}
			
		}
		if (boss+company+junior[0]+junior[1] == 0) {
			bw.write("no person");
		}else {
			if (boss>0) {
				bw.write(boss+"\n");
			}else {
				bw.write("no boss"+"\n");
			}
			if (company>0) {
				bw.write(company+"\n");
			}else {
				bw.write("no company"+"\n");
			}
			if (junior[0]>0) {
				bw.write(junior[0] + " " + junior[1]);
			}else {
				bw.write("no junior"+"\n");
			}
		}
		br.close();
		bw.close();
	}

}
