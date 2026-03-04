class Solution {
    public int minEatingSpeed1(int[] piles, int h) {
        Arrays.sort(piles);

        for(int k = 1; k<=piles[piles.length-1];k++){
            int time = 0;
            for(int n: piles){
            int t = (n+k-1)/k;
            time+=t;
            }

            if(time<=h){
                return k;
            }
        }

        return -1;
    }
	
	// binary search
	public int minEatingSpeed2(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length-1];

        while(l<r){
            int mid=(l+r)/2;

            int time = 0;
            for(int n: piles){
            time += (n+mid-1)/mid;
            }

            if(time<=h){
                r=mid;
            }else{
                l=mid+1;
            }
        }
            
        return l;
    }
}
