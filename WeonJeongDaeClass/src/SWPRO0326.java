import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


class MinMaxTree{
	int min;
	int max;
	MinMaxTree(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

class IndexedArray implements Comparable<IndexedArray>{
	int idx;
	int arrNum;
	IndexedArray(int idx, int arrNum){
		this.idx = idx;
		this.arrNum = arrNum;
	}
	@Override
	public int compareTo(IndexedArray o) {
		if (this.arrNum > o.arrNum) return 1;
		if (this.arrNum < o.arrNum) return -1;
		return 0;
	}
}
public class SWPRO0326 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static IndexedArray[] NumArr;
	static MinMaxTree[] mmTree;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			NumArr = new IndexedArray[N+1];
			NumArr[0] = new IndexedArray(0,0);
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				NumArr[i] = new IndexedArray(i,Integer.parseInt(st.nextToken()));
			}
			//인덱스 트리 생성
			mmTree = new MinMaxTree[(N+1)*4];
			Init(1,N,1);

			//숫자 배열 숫자크기순으로 정렬
			Arrays.sort(NumArr);
			int min_len = Integer.MAX_VALUE;
			int cnt = 0;
			for (int n = 1; n <= N; n++) {
				IndexedArray getIdx= BinarySearch(n,N,NumArr[n].arrNum+K);
				if (getIdx.idx > -1 && getIdx.idx-NumArr[n].idx + 1 <= min_len) {
					MinMaxTree findMM = Find(1,N,1,NumArr[n].idx,getIdx.idx);
					if (findMM.min == NumArr[n].arrNum && findMM.max == getIdx.arrNum) {
						if (getIdx.idx -NumArr[n].idx + 1 < min_len) {
							min_len = getIdx.idx -NumArr[n].idx +1;
							cnt = 1;
						}else if (getIdx.idx - NumArr[n].idx + 1 == min_len) {
							cnt++;
						}
					}
				}
			}
			//MinMaxTree findMM = Find(1,N,1,1,5);
			//최소 최대 출력
			//bw.write("#"+t+" "+ findMM.min + " "+findMM.max);
			
			bw.write("#"+t+" "+ min_len + " "+cnt+"\n");
		}
		bw.close();
		br.close(); 
	}

	private static IndexedArray BinarySearch(int s, int e, int find) {
		IndexedArray findIdx = new IndexedArray(-1, -1);
		while (s<=e) {
			int mid = (s+e)/2;
			if (NumArr[mid].arrNum <= find) {
				if (NumArr[mid].arrNum == find) {
					findIdx.idx = NumArr[mid].idx;
					findIdx.arrNum = NumArr[mid].arrNum;
					break;
				}
				s = mid+1;
			}else if (NumArr[mid].arrNum > find) {
				e = mid-1;
			}
		}
		return findIdx;
	}

	private static MinMaxTree Find(int start, int end, int node, int from, int to) {
		if (to < start || end < from) {
			return new MinMaxTree(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		if (from <= start && end <= to) {
			return mmTree[node];
		}
		int mid = (start+end)/2;
		MinMaxTree half1 = Find(start, mid, node*2, from, to);
		MinMaxTree half2 = Find(mid+1, end, node*2+1, from, to);
		int min = Math.min(half1.min, half2.min);
		int max = Math.max(half1.max, half2.max);
		
		return new MinMaxTree(min, max);
	}

	private static MinMaxTree Init(int start, int end, int node) {
		if (start == end) {
			return mmTree[node] = new MinMaxTree(NumArr[start].arrNum, NumArr[end].arrNum);
		}
		int mid = (start+end)/2;
		MinMaxTree half1 = Init(start, mid, node*2);
		MinMaxTree half2 = Init(mid+1, end, node*2+1);
		int min = Math.min(half1.min, half2.min);
		int max = Math.max(half1.max, half2.max);
		return mmTree[node] = new MinMaxTree(min, max);
	}

}
