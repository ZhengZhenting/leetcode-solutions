class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];

        for(int i=0; i<nums.length-k+1; i++){
           int[] window = new int[k];

           for(int j = 0; j<k; j++){
            window[j]= nums[i+j];
           }
           
           Arrays.sort(window);
           res[i]=window[k-1];
        }

        return res;
    }
}
