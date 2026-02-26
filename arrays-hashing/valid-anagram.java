class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int l = s.length();

        Map<Character,Integer> count1 = new HashMap<>();
        for(int i=0; i<l; i++){
            char c = s.charAt(i);
            if(!count1.containsKey(c)){
                count1.put(c,1);
            }else{
                count1.put(c,count1.get(c)+1);
            }
        }

        Map<Character,Integer> count2 = new HashMap<>();
        for(int i=0; i<l; i++){
            char c = t.charAt(i);
            if(!count2.containsKey(c)){
                count2.put(c,1);
            }else{
                count2.put(c,count2.get(c)+1);
            }
        }

        return count1.equals(count2);
            
    }
}
