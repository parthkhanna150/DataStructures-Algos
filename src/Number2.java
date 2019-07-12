import datastructures.ListNode;;

class Number2{
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		ListNode ans = addTwoNumbers(l1, l2);
		while(ans.next!=null) {
			System.out.println(ans.val);
			ans=ans.next;
		}
		System.out.println(ans.val);
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode sum = new ListNode(0);
        ListNode curr = null;
        ListNode ans = sum;

        while(l1!=null || l2!=null) {
            int l1_data = l1==null?0:l1.val;
            int l2_data = l2==null?0:l2.val;
            int s = (l1_data+l2_data+c)%10;
            c = (l1_data+l2_data+c)/10;
            sum.val = s;
            sum.next = new ListNode(0);
            curr = sum;
            sum = sum.next;
            l1 = l1==null||l1.next==null?null:l1.next;
            l2 = l2==null||l2.next==null?null:l2.next;
        }
        if(c>0) {
            sum.val = 1;
        }
        else {
        	curr.next=null;
        }
        return ans;
    }
}