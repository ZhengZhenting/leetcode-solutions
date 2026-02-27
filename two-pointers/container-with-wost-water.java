class Solution {
// solution mit for-loops - O(n^2)
    public int maxArea1(int[] heights) {
        int max = 0;
        int length = heights.length;

        for(int i=0; i<length; i++){
            for(int j=length-1; j>i; j--){
                int left = heights[i];
                int right = heights[j];
                int l1 = Math.min(left,right);
                int l2 = j-i;
                int area = l1 * l2;
                max = Math.max(area, max);
            }
        }

        return max;
    }
// solution mit two-pointers - O(n)	
    public int maxArea2(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length-1;

        while(left<right){
            int area = Math.min(heights[left],heights[right]) * (right-left);
            max = Math.max(max, area);

            if(heights[left]<=heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return max;
    }
	
}