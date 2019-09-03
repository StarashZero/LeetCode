package com.company;

public class MaxSubStrLen {
    public int lengthOfLongestSubstring(String s) {
        int[] mp = new int[256];
        int count;
        int maxCnt = 0;
        int low=0,high=0;
        while(high<s.length()){
            if  (mp[s.charAt(high)]<low+1){
                mp[s.charAt(high)] = high+1;
                high++;
            }else{
                count = high - low;
                if(maxCnt<count)
                    maxCnt = count;
                low = mp[s.charAt(high)];
            }
        }
        count = high - low;
        if(maxCnt<count)
            maxCnt=count;
        return maxCnt;
    }
    public static void main(String[] args) {
        MaxSubStrLen maxSubStrLen = new MaxSubStrLen();
        System.out.println(maxSubStrLen.lengthOfLongestSubstring("au"));
        // write your code here
    }
}
