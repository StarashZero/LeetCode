package com.company;

public class SumTwoNum {
    public int[] twoSum(int[] nums, int target) {
        int[] newNums = new int[2];
        for (int temp = 0;temp<nums.length;temp++){
            for (int temp1 = temp+1;temp1<nums.length;temp1++){
                if (nums[temp]+nums[temp1]==target){
                   newNums[0] = temp;
                   newNums[1] = temp1;
                   temp = nums.length;
                   break;
                }
            }
        }
        return newNums;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7,11 ,15};
        int target = 9;
        int[] result;
        SumTwoNum S = new SumTwoNum();
        result = S.twoSum(nums,target);
        System.out.println(result[0]+""+result[1]);
        // write your code here
    }
}
