class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            if(!map.containsKey(n)){
                map.put(n,1);
            }else{
                int value = map.get(n)+1;
                map.put(n,value);
            }
        }

        List<Map.Entry<Integer,Integer>> values = new ArrayList<>(map.entrySet());
        values.sort((a,b)->b.getValue()-a.getValue());

        int[] output = new int[k];

        for(int i=0;i<k;i++){
            output[i]=values.get(i).getKey();
        }

        return output;
    }
}
