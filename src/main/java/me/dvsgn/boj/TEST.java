package me.dvsgn.boj;

import java.util.Random;

public class TEST {
    public static void main(String[] args) {
        var a = new int[]{1, 2, 5};
        Solution solution = new Solution(a);

        System.out.println(solution.pickIndex());
    }
}

class Solution {
    int[] sum;
    Random rand;

    public Solution(int[] w) {
        sum = new int[w.length];
        rand = new Random();
        for(int i = 0; i < w.length; i++){
            if(i == 0) sum[i] = w[i];
            else sum[i] = sum[i-1]+w[i];
        }
    }

    public int pickIndex() {
        int len = sum.length;
//        int idx = rand.nextInt(sum[len-1])+1;
        int idx = 4;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(sum[mid] == idx) return mid;
            else if(sum[mid] < idx){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}
