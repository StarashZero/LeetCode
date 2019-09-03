package com.company;
import java.util.Vector;
public class TwoNumSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1,ptr2;
        ptr1 = l1;
        ptr2 = l2;
        int pre = 0;
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        boolean judge = true;
        while(ptr1!=null||ptr2!=null){
            int v = pre;
            if(ptr1!=null){
                v+=ptr1.val;
                ptr1 = ptr1.next;
            }
            if(ptr2!=null){
                v+=ptr2.val;
                ptr2 = ptr2.next;
            }
            if(v>=10)
                pre = 1;
            else
                pre = 0;
            if(judge) {
                ptr.val = v % 10;
                judge = false;
            }
            else {
                ptr.next = new ListNode(v % 10);
                ptr = ptr.next;
            }
        }
        if (pre==1){
            ptr.next = new ListNode(1);
        }
        return result;
    }
    public static void main(String[] args) {
        // write your code here
    }
}
