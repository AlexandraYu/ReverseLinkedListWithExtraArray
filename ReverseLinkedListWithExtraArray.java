public class ReverseLinkedListWithExtraArray{
    public static LinkedNode reverse(LinkedNode head) {
        LinkedNode tmp=null;
        int count=0; 
        if (head==null) return null; 
        tmp=head; 
        while(tmp!=null) { //first count how many "linked nodes" there are
            tmp=tmp.next; 
            count++; //for counting how many nodes there are
        }
        LinkedNode[] array = new LinkedNode[count]; 
        tmp=head; 
        for(int i=0; i<count; i++) { //we save each node into an array with the size of "count"
            array[i] = tmp; 
            tmp=tmp.next; 
        }
        LinkedNode newHead=null;  
        for(int i=count-1; i>=0; i--) { //then we start from the last element of the array and "linked" back each element to construct a new linked list
            if (newHead==null){
                newHead=array[i]; 
            }
            if(i==0) {
                array[i].next = null; 
            }
            else {
                array[i].next = array[i-1]; 
            }

        }
        return newHead; 
    }
    public static void main(String []args){
        LinkedNode n1 = new LinkedNode(1);
        LinkedNode n2 = new LinkedNode(2);
        LinkedNode n3 = new LinkedNode(3);
        LinkedNode n4 = new LinkedNode(4);
        LinkedNode myHead = null; 
        n1.next = n2; 
        n2.next = n3; 
        n3.next = n4; 
        n4.next=null; 
        myHead = reverse(n1);
        while (myHead!=null) {
            System.out.print("node is: "+myHead.data+"\n");
            myHead = myHead.next; 
        }
    }
}


class LinkedNode {
        int data; 
        LinkedNode next; 
        LinkedNode() {}
        LinkedNode(int input) {
            this.data = input; 
        }
    }