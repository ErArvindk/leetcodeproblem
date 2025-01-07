/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
............................./////////..........................
The pseudocode is as following:

Initialize current node to dummy head of the returning list.
Initialize carry to 0.
Loop through lists l1 and l2 until you reach both ends and carry is 0.
Set x to node l1's value. If l1 has reached the end of l1, set to 0.
Set y to node l2's value. If l2 has reached the end of l2, set to 0.
Set sum=x+y+carry.
Update carry=sum/10.
Create a new node with the digit value of (summod10) and set it to current node's next, then advance current node to next.
Advance both l1 and l2.
Return dummy head's next node.
Note that we use a dummy head to simplify the code. Without a dummy head, you would have to write extra conditional statements to initialize the head's value.
*/
package Problems;

public class Addtwonumber {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;  
        int carry = 0; 
        
        // Traverse both lists until both are exhausted and carry is zero
        while (l1 != null || l2 != null || carry != 0) {
            // Get the current values from l1 and l2 (or 0 if the list is empty)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Calculate sum for this digit, including carry
            int sum = carry + x + y;
            carry = sum / 10;  // New carry for next iteration
            curr.next = new ListNode(sum % 10); 
            curr = curr.next;  // Move current pointer to the new node
            
            // Move to the next nodes in l1 and l2 if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }
    // print method to print the linked list
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Create method to a linked list from an array of values
    public ListNode createList(int[] nums) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummyHead.next;
    }

    // Main method to test the Addtwonumbers
    public static void main(String[] args) {
        Addtwonumber solution = new Addtwonumber();

        // Create two sample linked lists for testing
        ListNode l1 = solution.createList(new int[] {2, 4, 3});  // Represents number 342
        ListNode l2 = solution.createList(new int[] {5, 6, 4});  // Represents number 465

        // Add the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result list
        solution.printList(result); 
    }
}

/*
 * used to another method than solve to leetcode 
 */
// public ListNode resList = new ListNode(0);
// public ListNode head = resList;
// public int carry = 0;

// public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 
//     int sum = l1.val + l2.val + carry;
//     carry  = sum / 10;
//     resList.next = new ListNode(sum % 10);
//     resList = resList.next;

//     if(l1.next != null && l2.next != null)
//         addTwoNumbers(l1.next, l2.next);  
//     else if (l1.next != null)
//         addTwoNumbers(l1.next, new ListNode(0)); 
//     else if (l2.next != null)
//         addTwoNumbers(new ListNode(0), l2.next);   
//     else if (carry > 0)
//     {
//         resList.next = new ListNode(1);
//         resList = resList.next;
//     }     
//     return head.next;
// }

