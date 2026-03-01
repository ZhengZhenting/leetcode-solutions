class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxFreq = 0;
        int[] count = new int[26];
        int l = 0;

        for(int r = 0; r<s.length(); r++){
            count[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r)-'A']);

            while((r-l+1) - maxFreq > k){
                count[s.charAt(l)-'A']--;
                l++;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }
}

//maxFreq只增不减仍然是正确的
//maxFreq不是当前窗口真实最大频率,而是窗口历史上出现过的最大频率（upper bound）
//只有符合条件，指针右移时，才能真正增加maxFreq
//其他时候遇到不满足条件的情况左移指针只是保持了窗口长度，对于窗口内有什么内容来说不重要
//因此允许它“不准确” 不会影响最终答案
