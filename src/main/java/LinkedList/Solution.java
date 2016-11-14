package LinkedList;

/**
 * Created by gnagpal on 11/2/16.
 *//**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    static public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
    }

    public static ListNode adTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int val = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null || l2 != null) {
            int l1val = (l1 == null) ? 0 : l1.val;
            int l2val = (l2 == null) ? 0 : l2.val;

            val = (l1val + l2val + carry) % 10;
            carry = (l1val + l2val + carry)/10;
            ListNode n = new ListNode(val);
            curr.next = n;
            curr = n;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }

        if(carry >= 1){
            curr.next = new ListNode(carry);
        }

        return head.next;
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static ListNode reverse(ListNode l){
        ListNode curr = l;
        ListNode prev = null;
        ListNode temp;
        while(curr.next != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        curr.next = prev;
        return curr;
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        String a = "";
        a.length();

        ListNode rev = reverse(head);
        while(rev!=null && head!=null){
            if(rev.val == head.val){
                rev = rev.next;
                head = head.next;
            }
            else return false;
        }
        return true;

    }

    public static void print(ListNode n){
        while(n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1size = 0;
        ListNode temp = l1;
        while(temp != null){
            l1size++;
            l1 = l1.next;
        }

        int l2size = 0;
        temp = l2;
        while(temp != null){
            l1size++;
            l1 = l1.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println(getPowerOf2(8));
        System.out.println(integerReplacement(2147483647));
                                                //2147483647
//        deleteNode(head1.next);
//        print(head1);
////
//        ListNode head2 = new ListNode(5);
//        head2.next = new ListNode(6);
////        head2.next.next = new ListNode(5);
//
//        ListNode h = adTwoNumbers(head1,head2);
//        print(h);
    }

    public static  int integerReplacement(int n) {
        return (integere(Long.valueOf(n)));
    }

    public static int other(int x){
        int ans = 0;
        long n = Long.valueOf(x);
        while(n!=1){
            if(n%2 == 0) n = n/2;
            else{
                if(n == 3)
                    n = 2;
                else{
                    if((n & 3) == 3){
                        n+=1;
                    }
                    else n-=1;
                }
            }
            ans++;
        }
        return ans;
    }

    public static int integere(long n){
        if(n == 1) return 0;
        if((n & (n - 1)) == 0) return getPowerOf2(n);
        if(n%2 == 0)
            return 1 + integere(n / 2);
        else{
            return Math.min(1 + integere(n + 1),1 + integere(n - 1));
        }
    }

    private static int getPowerOf2(long n) {
        int counter = 0;
        while(n!=1){
            n = n >> 1;
            counter++;
        }
        return counter;
    }
}
