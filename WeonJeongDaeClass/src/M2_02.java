
public class M2_02 {
	public static void main(String[] args) {

        int[][] map = {{3, 4, 1, 2}, {2, 2, 3, 5}, {6, 6, 1, 2}};

        for (int y = 0; y<3; y++) {
            for (int x= 0; x<4; x++) {
            	int debug = 0;
                if (map[y][x] % 2 == 0 && map[y][x] > 4) {
                    System.out.println(map[y][x]);
                }
            }
        }

    }
}
