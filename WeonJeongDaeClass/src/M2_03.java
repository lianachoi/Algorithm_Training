import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
class num_n_ch implements Comparable<num_n_ch>{
	int num;
	char ch;
	num_n_ch(int num, char ch){
		this.num = num;
		this.ch = ch;
	}
	@Override
	public int compareTo(num_n_ch o) {
		if ((num % 2) > (o.num % 2))return 1;
		if ((num % 2) < (o.num % 2))return -1;
		
		if (num < o.num) return -1;
		if (num > o.num) return 1;
		
		if (ch < o.ch) return -1;
		if (ch > o.ch) return 1;
		
		return 0;
	}
}
public class M2_03 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Integer [] nums = new Integer[N];
		num_n_ch[] nnc = new num_n_ch[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			char ch = st2.nextToken().charAt(0);
			nums[i] = num;
			nnc[i] = new num_n_ch(num, ch);
		}
		Arrays.sort(nums);
		for (int i = 0; i < nnc.length; i++) {
			bw.write(nums[i]+" ");
		}
		bw.write("\n");
		Arrays.sort(nums,Collections.reverseOrder());
		for (int i = 0; i < nnc.length; i++) {
			bw.write(nums[i]+" ");
		}
		bw.write("\n");
		Arrays.sort(nnc);
		for (int i = 0; i < nnc.length; i++) {
			bw.write(nnc[i].num+" ");
		}
		bw.write("\n");
		for (int i = 0; i < nnc.length; i++) {
			bw.write(nnc[i].ch+" ");
		}
		bw.write("\n");

		br.close();
		bw.close();
	}

}
