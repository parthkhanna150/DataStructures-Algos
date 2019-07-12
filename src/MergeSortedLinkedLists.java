import datastructures.ListNode;

public class MergeSortedLinkedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1==null && l2==null) {
    		return null;
    	}
    	
        ListNode ans = l1.val<l2.val? (new ListNode(l1.val)) : (new ListNode(l2.val));
    	ListNode ret  = ans;
    	
        while(l1.next!=null && l2.next!=null) {
	    	ans = l1.val<l2.val? (new ListNode(l1.val)) : (new ListNode(l2.val));
	    	ans.next = null;
	    	ans = ans.next;
	    	l1 = l1.next;
	    	l2 = l2.next;
        }
        if(l1==null && l2==null) {
            return ans;
        }
        if(l1==null) {
        	while(l2!=null) {
        		ans = new ListNode(l2.val);
        	}
        }
        else {
        	while(l1!=null) {
        		ans = new ListNode(l2.val);
        	}
        }
        return ret;

    }
//    Input: 1->2->4, 1->3->4

    public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode ans = mergeTwoLists(l1, l2);
		System.out.println(ans.val);
		while(ans.next!=null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}