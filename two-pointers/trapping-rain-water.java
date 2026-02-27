class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length-1;
        int leftMax=height[l];
        int rightMax=height[r];

        while(l<r){
            if(leftMax<=rightMax){
                l++;
                leftMax=Math.max(leftMax,height[l]);
                int v = leftMax-height[l];
                if(v>=0){
                    res+=v;
                }            
            }else{
                r--;
                rightMax=Math.max(rightMax,height[r]);
                int v = rightMax-height[r];
                if(v>=0){
                    res+=v;
                } 
            }
        }

        return res;
        
    }
}
