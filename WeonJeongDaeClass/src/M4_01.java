import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M4_01 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} 
		
		Arrays.sort(arr);
		
		int targets = Integer.parseInt(br.readLine());
		int[] target_nums = new int[targets];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < targets ; i++) {
			target_nums[i] = Integer.parseInt(st.nextToken());
		} 
		
		for (int i = 0; i < target_nums.length; i++) {
			int s = 0;
			int e = n-1;
			char found = 'X';
			while (s <= e) {
				int mid = (s+e)/2;
				if (arr[mid] > target_nums[i]) {
					e  =  mid - 1;
				}else if (arr[mid] < target_nums[i]) {
					s =  mid + 1;
				}else {
					found = 'O';
					break;
				}
			}
			bw.write(found);
		}
		br.close();
		bw.close();
	}

}
