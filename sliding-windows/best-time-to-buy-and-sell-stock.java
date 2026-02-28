class Solution {
	// dynamic programming
    public int maxProfit1(int[] prices) {
        int maxP = 0;
        int minB = prices[0];

        for(int p: prices){
            maxP = Math.max(maxP, p-minB);
            minB = Math.min(minB, p);
        }

        return maxP;
    }
	
	// two pointers
	public int maxProfit2(int[] prices) {
        int l = 0;
        int r = 1;
        int maxP = 0;

        while(r<prices.length){
            if(prices[l]<prices[r]){
                maxP=Math.max(maxP, prices[r]-prices[l]);
            }else{
                l=r;
            }
            r++;
        }

        return maxP;
    }
}