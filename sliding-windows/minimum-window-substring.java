class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length() || t.isEmpty()) return "";

        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> mapT = new HashMap<>();

        for(char a: t.toCharArray()){
            if(mapT.containsKey(a)){
                mapT.put(a,mapT.get(a)+1);
            }else{
                mapT.put(a,1);
            }
        }

        int l = 0;
        int have = 0;
        int need = mapT.size();
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1,-1};

        for(int r = 0; r < s.length(); r++){
            char charR = s.charAt(r);
            if(window.containsKey(charR)){
                window.put(charR,window.get(charR)+1);
            }else{
                window.put(charR,1);
            }

            if(mapT.containsKey(charR) && mapT.get(charR)==window.get(charR)){
                have++;
            }

            while(have==need){
                if(r-l+1<resLen){
                    resLen=r-l+1;
                    res[0]=l;
                    res[1]=r;
                }

                char charL = s.charAt(l);
                window.put(charL, window.get(charL)-1);
                if(mapT.containsKey(charL) && window.get(charL) < mapT.get(charL)){
                    have--;
                }

                l++;
            }
        }

        if(resLen==Integer.MAX_VALUE){
            return "";
        }else{
            return s.substring(res[0], res[1]+1);
        }

    }
}
