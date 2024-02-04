package ArraysAndLinkedLists.LinkedLists;

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

    //removing cycle
    public void removeCycle(){
        Node slowNode = head;
        Node fastNode = head;
        boolean isCycle = false;
        
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(fastNode == slowNode){
                isCycle = true;
                break;
            }
        }

        if(!isCycle){
            System.out.println("Is not a cycle");
            return;
        }

        slowNode = head;
        Node prevNode = null;
        while (fastNode != slowNode) {
            prevNode = fastNode;
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        prevNode.next = null;
    }
}

public class DetectingCycle {
    public static void main(String[] args) {
        NewLinkedList ll = new NewLinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.removeCycle();
        ll.print();
    }
}
