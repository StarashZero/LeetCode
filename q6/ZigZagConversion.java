package com.company;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder result= new StringBuilder();
        if(numRows<=1)
            return s;
        for(int temp = 0;temp<numRows;temp++){
            for(int ptr = temp;ptr<s.length();ptr+=2*numRows-2){
                result.append(s.charAt(ptr));
                if((temp!=0&&temp!=numRows-1)&&ptr+2*(numRows-temp-1)<s.length()){
                    result.append(s.charAt(ptr+2*(numRows-temp-1)));
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        // write your code here
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("A",1));
    }
}
