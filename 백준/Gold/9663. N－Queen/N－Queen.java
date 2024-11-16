import java.util.Scanner;

public class Main {
    private static int n;
    private static int count = 0;
    private static boolean[][] check = new boolean[15][15];

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        n = Integer.parseInt(sc.next());
        calc(0);
        System.out.println(count);
    }

    private static void calc(int row) {
        if (row == n) {
            count += 1;
        }

        for (int col = 0; col < n; col++) {
            check[row][col] = true;
            if (chk(row, col)) {
                calc(row + 1);
            }
            check[row][col] = false;
        }
    }

    private static boolean chk(int row, int col) {
        // 수직
        for (int i = 0; i < n; i++) {
            if (i == row) continue;

            if (check[i][col]) {
                return false;
            }
        }

        // \ 대각 -> 근데 여기서 왜 위로만 체크하냐면? 아직 밑에는 전개도 되지 않아서 굳이 해도 되지 않은 작업이기 때문
        var x = col - 1;
        var y = row - 1;
        while (x >= 0 && y >= 0) {
            if (check[y][x]) {
                return false;
            }

            x--;
            y--;
        }

        // / 대각
        x = col + 1;
        y = row - 1;
        while (x < n && y >= 0) {
            if (check[y][x]) {
                return false;
            }

            x++;
            y--;
        }
        return true;
    }
}

