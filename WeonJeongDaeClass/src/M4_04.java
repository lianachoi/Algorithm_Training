/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M4_04 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int [] people;
	static int N;
	static int T;
	static int max_val = 0;
	static int min_val = 0;
	
	public static int Calc_team(int K) {
		int ret = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			int sum = 0;
			int cnt = 1;
			for(int j = i; j < i+N ; j++) {
				sum += people[j];
				if (sum > K) {
					cnt++;
					sum = people[j]; 
				}
			}
			if (ret > cnt) {
				ret = cnt;
			}
		}
		return ret;
	}
	
	public static int binarySearch() {
		int ret = 0;
		int left = min_val;
		int right = max_val;
		
		while (left <= right) {
			int mid = (left+right)/2;
			int cnt_team = Calc_team(mid);
			if (cnt_team == T) {
				ret = mid;
			}
			if (cnt_team <= T) {
				right = mid - 1;
			}else if (cnt_team > T) {
				left = mid + 1;
			}
		}
		return ret;
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		people = new int[N*2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int intel = Integer.parseInt(st.nextToken());
			people[i] = intel;
			people[i+N] = intel;
			max_val += people[i];
			if (min_val < people[i])
				min_val = people[i];
		}
		bw.write(binarySearch() + "");
//		int max_intel = 0;
//		
//		int[] team_score = new int[T];
//		
//		for (int i = 0; i < N; i++) {
//			int team = 0;
//			int max = Integer.MIN_VALUE;
//			int min = Integer.MAX_VALUE;
//			for (int j = 0; j < N; j++) {
//				if (team_score[team] + people[j] > max_intel) {
//					team++;
//					if (team_score[team] > max) {
//						max = team_score[team];
//					}
//					if (team_score[team] < min) {
//						min = team_score[team];
//					}
//				}
//				if (team > T&& j < N-1) max_intel = max;
//				team_score[team] += people[j];
//			}
//		}
		br.close();
		bw.close();
	}

}
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class M4_04 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int T;
	static int People[];// 두뇌회전속도
	
	static int min_head = 0;
	static int max_head = 0;
	
	private static int BinarySearch() {
		int TeamNum = 0;
		int s = min_head;
		int e = max_head;
		int MaxHead = 0;
		
		while (s<=e) {
			int mid = (s+e)/2;
			TeamNum = Calc(mid);
			if (TeamNum == T) {
				MaxHead = mid;
			}
			if (TeamNum <= T) {
				e = mid - 1;
			} else if (TeamNum > T) {
				s = mid +1;
			}
		}
		return MaxHead;
	}
	
	private static int Calc(int HeadSum) {
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int TempSum = 0;
			int TeamNum = 1;
			for (int j = i; j < i+N; j++) {
				TempSum += People[j];
				if (TempSum > HeadSum) {
					TeamNum++;
					TempSum = People[j];
				}
			}
			if (answer > TeamNum) {
				answer = TeamNum;
			}
			
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		People = new int [2*N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N ; i++) {
			People[i] = Integer.parseInt(st.nextToken());
			People[i+N] = People[i];
				max_head += People[i];
			if (min_head < People[i]) {
				min_head = People[i];
			}
		}
		bw.write(BinarySearch()+"");
		br.close();
		bw.close();
	}
}