/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node2 implements Comparable<Node2>{
    int to, dist;
    Node2(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node2 o) {
        if(dist < o.dist) return -1;
        if(dist > o.dist) return 1;
        // TODO Auto-generated method stub
        return 0;
    }
}

class M5_03 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static ArrayList<ArrayList<Node2>> alist;

    public static void dijkstra(int start, int Dist[])
    {
        for(int i = 0; i <= n; i++)
        {
            Dist[i] = Integer.MAX_VALUE; // 아직 연결이 안되어 있다.(끊겨 있음)
        }
        // PriorityQueue
        PriorityQueue<Node2> pq = new PriorityQueue<>();

        // 시작점 세팅
        pq.add(new Node2(start, 0));
        Dist[start] = 0;

        // pq에서 now를 꺼내가며 갱신할 수 있는 연결된 Node2를 찾아 갱신
        while(!pq.isEmpty())
        {
            Node2 now = pq.poll();
            int now_num = now.to;
            int now_dist = now.dist;
            for(int i = 0; i < alist.get(now_num).size(); i++)
            {
                // now_num에서 갈 수 있는 Node2들을 하나씩 확인
                Node2 next = alist.get(now_num).get(i);
                int next_num = next.to;
                int next_dist = next.dist;
                if(Dist[next_num] > Dist[now_num] + next_dist)
                {
                    Dist[next_num] = Dist[now_num] + next_dist;
                    pq.add(new Node2(next_num, Dist[next_num]));
                }
            }
        }
    }

    public static int bs(int Dist[], int find_num)
    {
        int left = 0;
        int right = n - 2;
        int ret = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (Dist[mid] < find_num) {
                left = mid + 1;
            } else if (Dist[mid] >= find_num) {
                ret = mid;
                right = mid - 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {        
        int t = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= t; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            alist = new ArrayList<>();
            for(int i = 0; i<=n; i++)
                alist.add(new ArrayList<Node2>());
            //3가지 중 인접 리스트

            for(int i = 0; i < m; i++)
            {
                st = new StringTokenizer(br.readLine());
                int from =Integer.parseInt(st.nextToken());
                int to =Integer.parseInt(st.nextToken());
                int dist =Integer.parseInt(st.nextToken());
                alist.get(from).add(new Node2(to, dist));
                alist.get(to).add(new Node2(from, dist));
            }

            int Dist_front[] = new int [n + 1];//1번을 시작점으로 갖는 거리들
            int Dist_back[] = new int [n + 1];//n번을 시작점으로 갖는 거리들

            // Dijkstra
            // 1에서 시작해 모든 Node2로 가는 최단 거리들
            dijkstra(1, Dist_front);
            // n에서 시작해 모든 Node2로 가는 최단 거리들
            dijkstra(n, Dist_back);

            //binary search
            Dist_back[0] = Dist_back[1] = Dist_back[n] = Integer.MAX_VALUE;
            Arrays.sort(Dist_back);
            //0 ~ n - 2
            int ans = 0;
            for(int i = 2 ; i< n; i++)
            {
                int one_to_a = Dist_front[i];
                int a_b = 1;
                int one_to_n = Dist_front[n];
                int cnt = bs(Dist_back, one_to_n - one_to_a - a_b);
                ans += cnt;
            }
            bw.write("#"+test_case + " "+ans + "\n");;
        }

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.ObjectName;

class Road implements Comparable<Road>{
	int to;
	int time;
	Road(int to, int time){
		this.to = to;
		this.time = time;
	}
	@Override
	public int compareTo(Road o) {
		if (this.time > o.time) return 1;
		if (this.time < o.time) return -1;
		return 0;
	}
}

public class M5_03 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static ArrayList<ArrayList<Road>> al;
	static int[] One_to_N;
	static int[] N_to_One;

	private static void Find_route(int[] arr, int start) {
		PriorityQueue<Road> road = new PriorityQueue<>();		
		
		road.add(new Road(start, 0));
		while (!road.isEmpty()) {
			Road now = road.poll();
			int now_to = now.to;
			for (int i = 0; i <al.get(now_to).size() ; i++) {
				Road next = al.get(now_to).get(i);
				int next_to = next.to;
				int next_time = next.time;
				if (arr[next_to] > arr[now_to] + next_time) {
					arr[next_to] = arr[now_to] + next_time;
					road.add(new Road(next_to, arr[next_to]));
				}
			}
		}
	}

	private static int BS(int i) {
		int s = 0;
		int e = N-2;
		int cnt = -1;
		while(s <= e) {
			int m = (s+e)/2;
			int possible = One_to_N[N]-One_to_N[i]-1;
			if (possible > N_to_One[m]) {
				s = m + 1;
			}else if (possible <= N_to_One[m]) {
				cnt = m;
				e = m - 1;
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			One_to_N = new int[N+1];
			N_to_One = new int[N+1];
			al = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				al.add(new ArrayList<Road>());
				if (i > 1) {
					One_to_N[i] = Integer.MAX_VALUE;
				}
				if (i < N) {
					N_to_One[i] = Integer.MAX_VALUE;
				}
			}
			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				al.get(a).add(new Road(b,c));
				al.get(b).add(new Road(a,c));
			}
			
			Find_route(One_to_N, 1);
			Find_route(N_to_One, N);
			N_to_One[1] = N_to_One[N] = Integer.MAX_VALUE;
			Arrays.sort(N_to_One);
			
			int cnt = 0;
			for (int i = 2; i <= N; i++) {
				if (One_to_N[i] < One_to_N[N]-2) {
					int num = BS(i);
					cnt += num;
				}
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		br.close(); 
		bw.close();
	}
}


/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Road implements Comparable<Road>{
	int to;
	int time;
	Road(int to, int time){
		this.to = to;
		this.time = time;
	}
	@Override
	public int compareTo(Road o) {
		if (this.time > o.time) return 1;
		if (this.time < o.time) return -1;
		return 0;
	}
	
}

class Route1 implements Comparable<Route1>{
	int id;
	int num;
	Route1(int id, int num){
		this.id = id;
		this.num = num;
	}
	@Override
	public int compareTo(Route1 o) {
		if (this.num> o.num) return 1;
		if (this.num < o.num) return -1;
		return 0;
	}
	
}
public class M5_03 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<ArrayList<Road>> road ;
	static int [] Dist;
	static int N; 
	static PriorityQueue<Road> pq; 

	static ArrayList<Route1> From_1 = new ArrayList<>();
	static ArrayList<Route1> From_N = new ArrayList<>();
	
	static int pre_max;
	
	static int [] Dist_from_1;
	static int [] Dist_from_N;
	
	public static int[] Calc_time(int Shortest_time) {	
		
		while (!pq.isEmpty()) {
			Road now = pq.poll();
			int now_to = now.to;
			int now_time = now.time;
			for (int i = 0; i <road.get(now_to).size() ; i++) {
				Road next = road.get(now_to).get(i);
				int next_to = next.to;
				int next_time = next.time;
				if (Dist[next_to] > Dist[now_to] + next_time) {
					Dist[next_to] = Dist[now_to] + next_time;
					pq.add(new Road(next_to, Dist[next_to]));
				}
			}
		}
		return Dist ;
	}
	
	private static int BinarySearch(int i) {
		int s = 0;
		int e = N-2;
		int cnt = 0;
		int mid = 0;
		int a = pre_max - Dist_from_1[i] - 1;
		while (s<=e) {
			mid = (s+e)/2;
			if (a > Dist_from_N[mid]) {
				s = mid + 1;
				
			} else if (a <= Dist_from_N[mid]) {
				cnt = mid;
				e = mid-1;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			road = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				road.add(new ArrayList<Road>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				road.get(a).add(new Road(b, c));
				road.get(b).add(new Road(a, c));
			}
			Dist = new int [N+1];
			for (int i = 2; i <= N; i++) {
				Dist[i] = 123456789;
			}
			pq = new PriorityQueue<>();
			pq.add(new Road(1, 0));
			Dist_from_1= Calc_time(Integer.MAX_VALUE).clone();
			Dist = new int [N+1];
			for (int i = N-1; i >= 1; i--) {
				Dist[i] = 123456789;
			}
			pq = new PriorityQueue<>();
			pq.add(new Road(N, 0));
			Dist_from_N= Calc_time(Integer.MAX_VALUE).clone();
			
			
			Dist_from_N[0] = Dist_from_N[1] = Dist_from_N[N] = Integer.MAX_VALUE;
			Arrays.sort(Dist_from_N);
			pre_max = Dist_from_1[N];
			int cnt = 0;
			for (int i = 2; i < N; i++) {
				if (Dist_from_1[i] <= pre_max-2)
				  cnt += BinarySearch(i);
				
			}

			bw.write("#"+t+" "+cnt+"\n");

		}		
		br.close(); 
		bw.close();

	}

}
*/