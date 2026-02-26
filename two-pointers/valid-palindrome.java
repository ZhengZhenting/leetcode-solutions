class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char a: s.toCharArray()){
            if(Character.isLetterOrDigit(a)){
                sb.append(Character.toLowerCase(a));
            }
        }
        String res = sb.toString();

        int start = 0;
        int end = res.length()-1;

        while(start<end){
            if(res.charAt(start)==res.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }

        return true;
    }
}
