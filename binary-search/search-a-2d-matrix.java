class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] nums: matrix){
            int l = 0;
            int r = nums.length-1;

            while(l<=r){
                int mid = (l+r)/2;
                int n = nums[mid];
                if(n<target){
                    l=mid+1;
                }else if(n>target){
                    r=mid-1;
                }else{
                    return true;
                }
            }
        }

        return false;
    }
}