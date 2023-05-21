package leetcode;

public class Solution3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0;
        int num2 = 0;
        int result;
        boolean carrier = false;
        ListNode p = new ListNode();
        ListNode first = p;
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        while (l1 != null || l2 != null) {
            if (l1 != null) {       //finding two numbers to add for that single node
                num1 = l1.val;
                l1 = l1.next;
            } else {
                num1 = 0;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            } else {
                num2 = 0;
            }
            if (num1 + num2 < 10) { // if result i lesser than 10 put that number in node, except if we have 1 from last addition
                if (carrier) {      // then we have to check if that has carrier also ( we can have 9+1=10 which is bigger than single digit)
                    if(num1 + num2 + 1 > 9){
                        p.val = (num1 + num2 + 1)%10;
                        carrier = true;
                    }else {
                        p.val = num1 + num2 + 1;
                        carrier = false;
                    }
                } else p.val = num1 + num2;
            } else {                //our result is bigger than 10 so new node has to store result%10 and we have to check
                if(carrier){        // for carrier if it exists add 1, carrier can always be only 1, because biggest number we can
                    p.val = (num1 + num2 + 1) % 10; // get is 9+9+1 = 19
                    carrier = false;
                }else {
                    p.val = (num1 + num2) % 10;
                }
                carrier = true;
            }
            if(l1 != null || l2 != null) {
                p.next = new ListNode();
                p = p.next;
            }
        }
        if(carrier){
            p.next = new ListNode(1);
        }

        return first;
    }
    public static void main(String[] args){

    }
}


