public class Main {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.addFirst(12);
        list.addFirst(23);
        list.addLast(67);
        list.insertNode(56,23);
        list.insertNode(34,12);
        list.deleteAtEnd();
        list.deleteAtStart();
        list.delete(34);
        list.printList();
    }
}

//output: 
56
12
null
