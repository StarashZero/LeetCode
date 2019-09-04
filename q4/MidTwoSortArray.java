package com.company;


public class MidTwoSortArray {
    //将两个数组中的其中一个缩短至两位以下
    public double getMidBeginEnd(int[] nums1, int[] nums2, int begin1, int end1, int begin2, int end2){
        int num1 = nums1[(end1+begin1+1)/2];
        int num2 = nums2[(end2+begin2+1)/2];
        if(end1-begin1<=1||end2-begin2<=1) {
            //如果其中一个数组已经为两位以下，则返回答案
            if (end1-begin1<=1)
                return getMidNum(nums1, nums2, begin1,end1,begin2,end2);
            else
                return getMidNum(nums2, nums1, begin2, end2, begin1, end1);
        }else if(num1<num2){
            //若数组A的中位数<数组B的中位数，按数组A左半部分与数组B右半部分缩减
            int len = Math.min((end1+begin1)/2-begin1,end2-(end2+begin2+1)/2);
            return getMidBeginEnd(nums1,nums2,begin1+len,end1,begin2,end2-len);
        }else if(num1>num2){
            //若数组A的中位数>数组B的中位数，按数组A右半部分与数组B左半部分缩减
            int len = Math.min((end2+begin2)/2-begin2,end1-(end1+begin1+1)/2);
            return getMidBeginEnd(nums1,nums2,begin1,end1-len,begin2+len,end2);
        }else {
            //若两个中位数一致，则分三种情况返回答案
            if((end1+begin1)%2==0||(end2+begin2)%2==0){
                //若两个数组的长度有一个为奇数，直接返回两个中位数的值
                return nums1[(end1+begin1+1)/2];
            }else{
                //若两个数组的长度均为偶数，则将中位数与其前一位的最大值取均值
                return ((double)nums1[(end1+begin1+1)/2]+Math.max(nums1[(end1+begin1+1)/2-1],nums2[(end2+begin2+1)/2-1]))/2;
            }
        }
/*        return result;*/
    }
    //在一个两位以下的数组和另一个数组来找中位数
    public double getMidNum(int[] nums1, int[] nums2, int begin1, int end1, int begin2, int end2){
        double result;
/*        if(end1 == begin1){
            if((end2+begin2)%2==0){
                if (begin2!=end2){
                    int[] nums = {nums1[begin1], nums2[(begin2+end2+1)/2 - 1],nums2[(begin2+end2+1)/2], nums2[(begin2+end2+1)/2 + 1]};
                    Arrays.sort(nums);
                    return (double)(nums[1] + nums[2])/2;
                }else
                    return (double)(nums1[begin1] + nums2[(begin2+end2+1)/2])/2;
            }else{
                int[] nums = {nums1[begin1],nums2[(begin2+end2+1)/2 - 1], nums2[(begin2+end2+1)/2]};
                Arrays.sort(nums);
                return nums[1];
            }
        }else{
            if((end2+begin2)%2==0){
                if (begin2!=end2){
                    int[] nums = {nums1[begin1],nums1[end1], nums2[(begin2+end2+1)/2 - 1], nums2[(begin2+end2+1)/2], nums2[(begin2+end2+1)/2 + 1]};
                    Arrays.sort(nums);
                    return (double)nums[2];
                }else {
                    int[] nums = {nums1[begin1],nums1[end1], nums2[(begin2+end2+1)/2]};
                    Arrays.sort(nums);
                    return (double)nums[1];
                }
            }else{
                if(end2-begin2>2){
                    int[] nums = {nums1[begin1], nums1[end1], nums2[(begin2 + end2 + 1) / 2 - 2], nums2[(begin2 + end2 + 1) / 2 - 1], nums2[(begin2 + end2 + 1) / 2], nums2[(begin2 + end2 + 1) / 2 + 1]};
                    Arrays.sort(nums);
                    return (double) (nums[2] + nums[3]) / 2;
                }else {
                    int[] nums = {nums1[begin1], nums1[end1], nums2[(begin2 + end2 + 1) / 2], nums2[(begin2 + end2 + 1) / 2 - 1]};
                    Arrays.sort(nums);
                    return (double) (nums[1] + nums[2]) / 2;
                }
            }
        }*/
        if((end2+begin2)%2==0) {
            if (end1 == begin1) {
                if ((begin2+end2)/2- 1 >= 0 && nums1[begin1] < nums2[(begin2+end2)/2 - 1]) {
                    result = ((double) nums2[(begin2+end2)/2 - 1] + nums2[(begin2+end2)/2]) / 2;
                } else if ((begin2+end2)/2 + 1 < nums2.length && nums1[begin1] > nums2[(begin2+end2)/2 + 1]) {
                    result = ((double) nums2[(begin2+end2)/2 + 1] + nums2[(begin2+end2)/2]) / 2;
                } else
                    result = ((double) nums1[begin1] + nums2[(begin2+end2)/2]) / 2;
            }else {
                if(nums1[begin1]<=nums2[(begin2+end2)/2]&&nums1[end1]>=nums2[(begin2+end2)/2])
                    result = nums2[(begin2+end2)/2];
                else if(nums1[end1]<=nums2[(begin2+end2)/2]){
                    if((begin2+end2)/2-1>=0&&nums1[end1]<=nums2[(begin2+end2)/2-1])
                        result = nums2[(begin2+end2)/2-1];
                    else
                        result = nums1[end1];
                }else{
                    if((begin2+end2)/2+1<nums2.length&&nums1[begin1]>=nums2[(begin2+end2)/2+1])
                        result = nums2[(begin2+end2)/2+1];
                    else
                        result = nums1[begin1];
                }
            }
        }else{
            int tempBegin2 = (begin2+end2-1)/2;
            int tempEnd2 = (begin2+end2+1)/2;
            if (end1 == begin1){
                if(nums1[begin1]<=nums2[tempBegin2])
                    result = nums2[tempBegin2];
                else if(nums1[begin1]>=nums2[tempEnd2])
                    result = nums2[tempEnd2];
                else
                    result = nums1[begin1];
            }
            else{
                if(nums1[end1]<=nums2[tempBegin2]) {
                    if(tempBegin2-1>=0&&nums2[tempBegin2-1]>=nums1[end1])
                        result = ((double)nums2[tempBegin2-1]+nums2[tempBegin2])/2;
                    else
                        result = ((double)nums1[end1]+nums2[tempBegin2])/2;
                }
                else if(nums1[begin1]>=nums2[tempEnd2]){
                    if(tempEnd2+1<nums2.length&&nums2[tempEnd2+1]<=nums1[begin1])
                        result = ((double)nums2[tempEnd2+1]+nums2[tempEnd2])/2;
                    else
                        result = ((double)nums1[begin1]+nums2[tempEnd2])/2;
                }else if(nums1[begin1]<=nums2[tempBegin2]){
                    if(nums1[end1]>=nums2[tempEnd2]){
                        result = ((double)nums2[tempBegin2]+nums2[tempEnd2])/2;
                    }else
                        result = ((double)nums2[tempBegin2]+nums1[end1])/2;
                }else{
                    if(nums1[end1]<=nums2[tempEnd2]){
                        result = ((double)nums1[begin1]+nums1[end1])/2;
                    }else
                        result = ((double)nums1[begin1]+nums2[tempEnd2])/2;
                }
            }
        }
        return result;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        if(nums1.length==0){
            result = ((double) nums2[nums2.length/2]+nums2[(nums2.length-1)/2])/2;
        }else if(nums2.length==0){
            result = ((double)nums1[nums1.length/2]+nums1[(nums1.length-1)/2])/2;
        }else {
            result = getMidBeginEnd(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
        }
        return result;
    }
    public static void main(String[] args) {
        // write your code here
        int[] nums1 = {1,2};
        int[] nums2 = {3,4,5,6};
        MidTwoSortArray midTwoSortArray = new MidTwoSortArray();
        System.out.println(midTwoSortArray.findMedianSortedArrays(nums1,nums2));
    }
}
