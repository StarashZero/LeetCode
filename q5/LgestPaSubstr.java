package com.company;

public class LgestPaSubstr {
    public String longestPalindrome(String s) {
        if(s.length()==0)
            return "";
        int maxLen = 1;
        String result = ""+s.charAt(0);
        for (int temp1=0;temp1<2*s.length()-1;temp1++){
            int temp2;
            if(temp1%2==0)
                temp2 = 2;
            else
                temp2 = 1;
            for (;(temp1+temp2)/2<s.length()&&(temp1-temp2)/2>=0&&s.charAt((temp1-temp2)/2)==s.charAt((temp1+temp2)/2);temp2+=2);
            temp2-=2;
            if(temp2+1>maxLen){
                maxLen = temp2+1;
                result = s.substring((temp1-temp2)/2,(temp1+temp2)/2+1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // write your code here
        String s = "babadsadczxcxzczc";
        LgestPaSubstr lgestPaSubstr = new LgestPaSubstr();
        System.out.println(lgestPaSubstr.longestPalindrome(s));
    }
}
