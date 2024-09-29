package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var e = Integer.parseInt(st.nextToken());
        var s = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());
        var esm = new ESM();

        while (!esm.isMatch(e, s, m)) {
            esm.increase();
        }

        System.out.println(esm.getUs());
    }
}

class ESM {
    private int e;
    private int s;
    private int m;
    private int us;

    public ESM() {
        this.e = 1;
        this.s = 1;
        this.m = 1;
        this.us = 1;
    }

    public void increase() {
        e++;
        s++;
        m++;
        us++;
        if (e == 16) {
            e = 1;
        }

        if (s == 29) {
            s = 1;
        }

        if (m == 20) {
            m = 1;
        }
    }

    public boolean isMatch(int e, int s, int m) {
        return e == this.e && s == this.s && m == this.m;
    }

    public int getUs() {
        return this.us;
    }
}
