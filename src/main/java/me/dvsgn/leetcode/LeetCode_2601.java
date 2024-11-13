package me.dvsgn.leetcode;

public class LeetCode_2601 {
    public static void main(String[] args) {
        Solution_2601 sol = new Solution_2601();
        sol.primeSubOperation(new int[]{15, 20, 17, 7, 16});
    }
}

class Solution_2601 {
    public boolean primeSubOperation(int[] nums) {
        if (isSort(nums)) {
            return true;
        }
        var primes = makePrimes();

        return bf(nums, primes, 0);
    }

    public boolean bf(int[] nums, boolean[] primes, int depth) {
        if (depth == nums.length) {
            return isSort(nums);
        }

        var prime = 0;
        for (int i = nums[depth] - 1; i >= 0; i--) {
            if (i < 2) {
                break;
            }

            if (primes[i] == false) {
                prime = i;
                break;
            }
        }
        var temp = nums[depth];
        nums[depth] -= prime;
        var changed = bf(nums, primes, depth + 1);
        nums[depth] = temp;
        var unchanged = bf(nums, primes, depth + 1);
        return changed || unchanged;
    }

    public boolean isSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public boolean[] makePrimes() {
        var primes = new boolean[1001];
        primes[0] = primes[1] = true;
        for(int i = 2; i <= Math.sqrt(1000); i++) {

            // 이미 체크된 배열이면 다음 반복문으로 skip
            if(primes[i] == true) {
                continue;
            }

            // i 의 배수들을 걸러주기 위한 반복문
            for(int j = i * i; j < primes.length; j = j + i) {
                primes[j] = true;
            }
        }

        return primes;
    }
}
