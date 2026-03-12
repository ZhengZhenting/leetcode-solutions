class Solution {
// Arrays.sort
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }

        return -1;
    }
	
//HashSet
	public int findDuplicate2(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int i: nums){
            if(!s.add(i)){
                return i;
            }else{
                s.add(i);
            }
        }

        return -1;
    }
}
