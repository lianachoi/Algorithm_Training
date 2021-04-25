import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Printer implements Comparable<Printer>
{
	long en; //출력 완료 시간
	int ind; //프린터 번호
	Printer(long en,	int ind) {
		this.en = en;
		this.ind = ind;
	}
	public int compareTo(Printer o) {
		//츨력이 빨리 완료되면 그대로
		if (en < o.en) return -1;
		//출력이 늦게 완료되면 변경
		if (en > o.en) return 1;
		//프린터 번호가 빠른 순으로
		if (ind < o.ind) return -1;
		if (ind > o.ind) return 1;
		return 0;
	}
}

class Doc implements Comparable<Doc>{
	int req_order; //문서 번호
	long req_time; //출력 요청 시간
	long print_time; //문서 출력에 필요한 시간
	public Doc(int req_order, long req_time, long print_time) {
		this.req_order = req_order;
		this.req_time = req_time;
		this.print_time = print_time;
	}
	@Override
	public int compareTo(Doc o) {
		//출력 요청 빠른 순서
		if (this.req_time < o.req_time) return -1;
		if (this.req_time > o.req_time) return 1;
		//출력 시간 짧은 순서
		if (this.print_time < o.print_time) return -1;
		if (this.print_time > o.print_time) return 1;
		//문서 번호 빠른 순서
		if (this.req_order < o.req_order) return -1;
		if (this.req_order > o.req_order) return 1;
		return 0;
	}
}
public class M2_09 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//출력물 배열
		Doc [] doc = new Doc[N];
		int [] doc_printer = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			doc[i] = new Doc(i, Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		}
		Arrays.sort(doc); // NlogN
		//프린터 수만큼 생성
		PriorityQueue<Printer> pq = new PriorityQueue<Printer>();
		for (int i = 1; i <= M; i++) {
			pq.add(new Printer((long)0,i));
		}
		
		//1. 요청이 빠른 문서부터 프린터를 배정한다.
		//2. 출력이 빨리 완료된 프린터에 배정한다.
		for (int i = 0; i < N; i++) {
			Printer now = pq.poll();//완료시간 젤 짧은것
			long now_en = now.en;
			if (now.en <= doc[i].req_time) {
				now_en = doc[i].req_time + doc[i].print_time;
			}else {
				now_en = now_en + doc[i].print_time;
			}
			pq.add(new Printer(now_en, now.ind));
			doc_printer[doc[i].req_order] = now.ind;
		}
		for (int i = 0; i < N; i++) {
			bw.write(doc_printer[i]+"\n");
		}
		br.close();
		bw.close();
	}

}
