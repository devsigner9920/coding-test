package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var str = br.readLine();
        var subStr = br.readLine();

        if (str.equals(subStr)) {
            System.out.println(1);
            return;
        }

        var strArr = str.toCharArray();
        var subStrArr = subStr.toCharArray();

        for (int i = 0; i < strArr.length - subStrArr.length; i++) {
            var isOk = true;
            for (int j = 0; j < subStrArr.length; j++) {
                if (strArr[i + j] != subStrArr[j]) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
