class Solution {
    public int search(int[] nums, int target) {      
        int len = nums.length;

        if(len==0) return -1;

        int l = 0;
        int r = len - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            int n = nums[mid];

            if(n<target){
                l = mid+1;
            }else if(n>target){
                r = mid-1;
            }else{
                return mid;
            }
        }

        return -1;
    }
}
