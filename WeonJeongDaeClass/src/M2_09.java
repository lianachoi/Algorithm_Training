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
	long en; //��� �Ϸ� �ð�
	int ind; //������ ��ȣ
	Printer(long en,	int ind) {
		this.en = en;
		this.ind = ind;
	}
	public int compareTo(Printer o) {
		//������ ���� �Ϸ�Ǹ� �״��
		if (en < o.en) return -1;
		//����� �ʰ� �Ϸ�Ǹ� ����
		if (en > o.en) return 1;
		//������ ��ȣ�� ���� ������
		if (ind < o.ind) return -1;
		if (ind > o.ind) return 1;
		return 0;
	}
}

class Doc implements Comparable<Doc>{
	int req_order; //���� ��ȣ
	long req_time; //��� ��û �ð�
	long print_time; //���� ��¿� �ʿ��� �ð�
	public Doc(int req_order, long req_time, long print_time) {
		this.req_order = req_order;
		this.req_time = req_time;
		this.print_time = print_time;
	}
	@Override
	public int compareTo(Doc o) {
		//��� ��û ���� ����
		if (this.req_time < o.req_time) return -1;
		if (this.req_time > o.req_time) return 1;
		//��� �ð� ª�� ����
		if (this.print_time < o.print_time) return -1;
		if (this.print_time > o.print_time) return 1;
		//���� ��ȣ ���� ����
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
		//��¹� �迭
		Doc [] doc = new Doc[N];
		int [] doc_printer = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			doc[i] = new Doc(i, Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		}
		Arrays.sort(doc); // NlogN
		//������ ����ŭ ����
		PriorityQueue<Printer> pq = new PriorityQueue<Printer>();
		for (int i = 1; i <= M; i++) {
			pq.add(new Printer((long)0,i));
		}
		
		//1. ��û�� ���� �������� �����͸� �����Ѵ�.
		//2. ����� ���� �Ϸ�� �����Ϳ� �����Ѵ�.
		for (int i = 0; i < N; i++) {
			Printer now = pq.poll();//�Ϸ�ð� �� ª����
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
