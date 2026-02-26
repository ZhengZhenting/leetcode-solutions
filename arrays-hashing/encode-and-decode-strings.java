class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";

        List<Integer> sizes = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for (String s: strs){
            sizes.add(s.length());
        }

        for(int n: sizes){
            res.append(n).append(',');
        }
        res.append('#');

        for(String s:strs){
            res.append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        if(str.length()==0){
            return new ArrayList<>();
        }

        int i=0;
        
        List<String> res = new ArrayList<>();

        List<Integer> sizes = new ArrayList<>();

        while(str.charAt(i) != '#'){
            StringBuilder cur = new StringBuilder();
            while(str.charAt(i) != ','){
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for(int s: sizes){
            res.add(str.substring(i,i+s));
            i+=s;
        }
        return res;
    }
}
