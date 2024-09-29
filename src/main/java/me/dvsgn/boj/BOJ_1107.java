package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var strNum = br.readLine().split("");
        var nums = new int[strNum.length];
        for (int i = 0; i < strNum.length; i++) {
            nums[i] = Integer.parseInt(strNum[i]);
        }
        var brokenNumCount = Integer.parseInt(br.readLine());
        var brokenNums = new int[brokenNumCount];

        if (brokenNumCount > 0) {
            var st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < brokenNumCount; i++) {
                brokenNums[i] = Integer.parseInt(st.nextToken());
            }
        }
        var remote = new int[10];
        for (int i = 0; i < remote.length; i++) {
            remote[i] = i;

            for (int j = 0; j < brokenNums.length; j++) {
                if (brokenNums[j] == i) {
                    remote[i] = -1;
                }
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
            System.out.println();
        for (int i : remote) {
            System.out.print(i + " ");
        }

        var resultNums = new int[nums.length];

        var isAllBroken = true;
        for (int i = 0; i < remote.length; i++) {
            if (remote[i] != -1) {
                isAllBroken = false;
                break;
            }
        }

        if (isAllBroken) {
//            System.out.println(Math.abs(100 - String.join("")));
        }

        for (int i = 0; i < nums.length; i++) {
            var currentNum = nums[i];

            if (currentNum == remote[currentNum]) {
                resultNums[i] = currentNum;
                continue;
            }

            if (remote[currentNum] == -1) {
                var minusPosition = -1;
                var plusPosition = -1;

                // 마이너스 처리
                for (int j = currentNum - 1; j >= 0; j--) {
                    if (remote[j] > minusPosition) {
                        minusPosition = remote[j];
                    }
                }

                for (int j = currentNum + 1; j < remote.length; j++) {
                    if (remote[j] > plusPosition) {
                        plusPosition = remote[j];
                    }
                }
            }
        }
    }
}
