class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        Arrays.sort(nums);
        int res =1;
        int max =1;

        for(int i =0; i<nums.length-1; i++){
            if(nums[i+1]-nums[i]==1){
                res+=1;
            }else if(nums[i+1]-nums[i]==0){
                res+=0;
            }else{
                max=Math.max(max,res);
                res=1;
            }
        }

        return Math.max(max,res);
    }
}
