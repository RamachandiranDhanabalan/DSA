package com.learning.dsa.arrays;
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class AddTwoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l3.next = null;
		l2.next = l3;
		l1.next = l2;

		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l6.next = null;
		l5.next = l6;
		l4.next = l5;

		ListNode ls = addTwoNumbers(l1, l4);
		while (ls != null) {
			System.out.print(ls.val);
			ls = ls.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = null;
		int carry = 0;
		ListNode dummy = l1;

		while (l1 != null || l2 != null) {
			int l1Value = 0, l2Value = 0, sum = 0;
			if (l1 != null)
				l1Value = l1.val;
			if (l2 != null)
				l2Value = l2.val;

			sum = carry + l1Value + l2Value;
			carry = sum / 10;
			sum = sum % 10;
			if (ans == null) {
				ans = new ListNode(sum);
				dummy = ans;
			} else {
				dummy.next = new ListNode(sum);
				dummy = dummy.next;

			}
			// carry=sum/10;
			if(l1!=null)
				l1 = l1.next;
			if(l2!=null)
				l2 = l2.next;
			// dummy=ans.next;
		}

		if (carry > 0)
			dummy.next = new ListNode(carry);

		return ans;
	}

}
