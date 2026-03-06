class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int total = l1+l2;
        int half = (total+1)/2;

        int[] A = nums1;
        int[] B = nums2;

        // swap A & B, making sure length of A smaller than length of B
        if(B.length < A.length){
            int[] temp = A;
            A=B;
            B=temp;
        }

        int l = 0;
        int r = A.length;
        while(l<=r){
            int i = (l+r)/2;  // index for mid of A
            int j = half-i;   // index for B (rest of the half elements)
            
            // keeping numbers within bound
            // Java 的三元运算符，格式是：条件 ? 值A : 值B
            // 条件为true → 取值A
            // 条件为false → 取值B
            int Aleft = i>0? A[i-1]:Integer.MIN_VALUE;
            int Aright = i<A.length? A[i]:Integer.MAX_VALUE;
            int Bleft = j>0? B[j-1]:Integer.MIN_VALUE;
            int Bright = j<B.length? B[j]:Integer.MAX_VALUE;

            if(Aleft<=Bright && Bleft<=Aright){
                if(total % 2 != 0){
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft,Bleft) + Math.min(Aright,Bright))/2.0;
            }else if(Aleft>Bright){
                r=i-1;
            }else{
                l=i+1;
            }
        }
        return -1;
    }
}
