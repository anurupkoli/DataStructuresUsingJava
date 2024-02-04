package ArraysAndLinkedLists.LinkedLists;
import ArraysAndLinkedLists.LinkedLists.LinkedListL;

class NewLinkedList extends LinkedListL{
    public boolean detectCycle(){
        Node slowNode = head;
        Node fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if(slowNode == fastNode){
                return true;
            }
        }
        return false;
    }
}

public class DetectingCycle {
    public static void main(String[] args) {
        NewLinkedList ll = new NewLinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        System.out.println(ll.detectCycle());
        ll.print();
    }
}
