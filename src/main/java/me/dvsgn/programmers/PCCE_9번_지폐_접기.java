package me.dvsgn.programmers;

public class PCCE_9번_지폐_접기 {


    public static void main(String[] args) {
        Solution_PCCE_9 solution = new Solution_PCCE_9();

        int[] wallet1 = new int[]{30, 15};
        int[] bill1 = new int[]{26, 17};
        System.out.println(solution.solution(wallet1, bill1));
    }
}

class Solution_PCCE_9 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                break;
            }

            var temp = bill[0];
            bill[0] = bill[1];
            bill[1] = temp;

            if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                break;
            }

            if (bill[0] > bill[1]) {
                bill[0] = bill[0] / 2;
            } else {
                bill[1] = bill[1] / 2;
            }
            answer++;
        }
        return answer;
    }
}