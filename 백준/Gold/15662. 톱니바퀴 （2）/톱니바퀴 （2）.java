import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<Gear> gearList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            var chars = br.readLine().toCharArray();
            List<Integer> integers = new ArrayList<>();
            for (char c : chars) {
                integers.add(Character.getNumericValue(c));
            }
            gearList.add(new Gear(integers));
        }

        var gears = new Gears(gearList);

        var commandCount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine());
            var gearIndex = Integer.parseInt(st.nextToken());
            var direction = Integer.parseInt(st.nextToken());

            gears.rotate(gearIndex, direction, N);
        }

        gears.sout();
    }
}

class Gears {
    private final List<Gear> gears;

    Gears(List<Gear> gears) {
        this.gears = gears;
    }

    public void rotate(int gearIndex, int direction, int n) {
        var index = gearIndex - 1;
        int[] directions = new int[n]; // 각 기어의 회전 방향을 저장할 배열
        directions[index] = direction;

        // 왼쪽 기어들의 회전 방향 설정
        for (int i = index - 1; i >= 0; i--) {
            var currentGear = gears.get(i + 1);
            var leftGear = gears.get(i);

            if (currentGear.getLeft() != leftGear.getRight()) {
                directions[i] = -directions[i + 1];
            } else {
                break;
            }
        }

        // 오른쪽 기어들의 회전 방향 설정
        for (int i = index + 1; i < n; i++) {
            var currentGear = gears.get(i - 1);
            var rightGear = gears.get(i);

            if (currentGear.getRight() != rightGear.getLeft()) {
                directions[i] = -directions[i - 1];
            } else {
                break;
            }
        }

        // 각 기어를 회전 방향에 따라 회전
        for (int i = 0; i < n; i++) {
            if (directions[i] != 0) {
                gears.get(i).rotate(directions[i]);
            }
        }
    }

    public void sout() {
        var count = 0;
        for (Gear gear : gears) {
            if (gear.isS()) {
                count++;
            }
        }

        System.out.println(count);
    }
}

class Gear {
    private final List<Integer> gear;

    Gear(List<Integer> gear) {
        this.gear = gear;
    }

    public int getLeft() {
        return gear.get(6);
    }

    public int getRight() {
        return gear.get(2);
    }

    public void rotate(Integer direct) {
        if (direct == 1) {
            gear.add(0, gear.remove(7)); // 시계 방향 회전
        }

        if (direct == -1) {
            gear.add(gear.remove(0)); // 반시계 방향 회전
        }
    }

    public boolean isS() {
        return gear.get(0) == 1;
    }
}
