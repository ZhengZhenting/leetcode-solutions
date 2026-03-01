class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int len = s1.length();

        int[] count = new int[26];
        int[] window = new int[26];

        for(char a: s1.toCharArray()){
            count[a-'a']++;
        }

        for(int i = 0; i<len; i++){
            window[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(count, window)) return true;

        for(int i=len; i<s2.length(); i++){
            window[s2.charAt(i)-'a']++;
            window[s2.charAt(i-len)-'a']--;
            if(Arrays.equals(count, window)){
                return true;
            }
        }
        return false;
    }
}
