import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        var arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var check = new boolean[2000000];

        bf(arr, check, 0, 0);

        for (int i = 1; i < check.length; i++) {
            if (!check[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void bf(int[] arr, boolean[] check, int index, int sum) {
        if (index == arr.length) {
            check[sum] = true;
            return;
        }

        bf(arr, check, index + 1, sum + arr[index]);
        bf(arr, check, index + 1, sum);
    }
}
