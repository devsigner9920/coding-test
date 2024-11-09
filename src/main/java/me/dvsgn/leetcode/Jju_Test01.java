package me.dvsgn.leetcode;


/*
    Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).

    Your system should accept a timestamp parameter (in seconds granularity), and you may assume that calls are being
    made to the system in chronological order (i.e., timestamp is monotonically increasing). Several hits may arrive roughly at the same time.

    Implement the HitCounter class:

    HitCounter() Initializes the object of the hit counter system.
    void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Several hits may happen at the same timestamp.
    int getHits(int timestamp) Returns the number of hits in the past 5 minutes from timestamp (i.e., the past 300 seconds).


    Example 1:

    Input
    ["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
    [[], [1], [2], [3], [4], [300], [300], [301]]
    Output
    [null, null, null, null, 3, null, 4, 3]

    Explanation
    HitCounter hitCounter = new HitCounter();
    hitCounter.hit(1);       // hit at timestamp 1.
    hitCounter.hit(2);       // hit at timestamp 2.
    hitCounter.hit(3);       // hit at timestamp 3.
    hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
    hitCounter.hit(300);     // hit at timestamp 300.
    hitCounter.getHits(300); // get hits at timestamp 300, return 4.
    hitCounter.getHits(301); // get hits at timestamp 301, return 3.

    1 <= timestamp <= 2 * 109
    All the calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing).
    At most 300 calls will be made to hit and getHits.
*/

import java.util.ArrayList;
import java.util.List;

public class Jju_Test01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }


}

class HitCounter {
    //[1,2,3, 300, 500, 800] getHit(300)
    List<Integer> hitTimes;

    public HitCounter() {
        this.hitTimes = new ArrayList<>();
    }

    public void hit(int timestamp) {
        hitTimes.add(timestamp);
    }

    public int getHits(int timestamp) {
        //300 (5min)
        //(timestamp - 300 ~ timestamp)
        int target = timestamp - 300 + 1;
        int start = 0;
        int end = hitTimes.size() - 1;

        if (hitTimes.size() != 0 && timestamp > hitTimes.get(hitTimes.size()-1)+300-1) {
            return 0;
        }
        //end -> start point
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (hitTimes.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return hitTimes.size() - start;
        ///////////////////////


//        int leftBound = start;
//
//        int counter = 0;
//        while(leftBound < hitTimes.size() && hitTimes.get(leftBound) <= timestamp){
//            counter++;
//            leftBound++;
//        }
//        return counter;
        //[60, 70, 300, 400, 500, 600, 700, 800]

        //timestamp 3, timestamp - 300 index 0 3 -9 = 3

    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */