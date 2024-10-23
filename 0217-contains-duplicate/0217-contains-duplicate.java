class Solution {
    public boolean containsDuplicate(int[] nums) {
        int size = Arrays.stream(nums).distinct().toArray().length;
        if (nums.length != size) {
            return true;
        }
        
        return false;
    }
}