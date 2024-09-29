package me.dvsgn.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10430 {
    public static void main(String[] args) throws IOException {
        /*
            (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?

            (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?

            세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        var A = Integer.parseInt(st.nextToken());
        var B = Integer.parseInt(st.nextToken());
        var C = Integer.parseInt(st.nextToken());

        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);
    }
}
