class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length<2) return false;

        Set<Integer> list = new HashSet<>();
        for(int n: nums){
            if(!list.add(n)){
                return true;
            }
        }
        return false;
    }
}