public class MyLinkedList {
    private Node head;
    private int size;

   public void addFirst(int data){
       Node newNode=new Node(data);
       if(head==null){
           head=newNode;
       }
       else {
           newNode.next=head;
           head=newNode;
       }
   }

   public void addLast(int data){
       Node newNode=new Node(data);
       if(head==null){
           head=newNode;
       }
       Node temp=head;
       while(temp.next!=null){
           temp = temp.next;
       }
       temp.next=newNode;
   }

   public void insertNode(int data, int insertAfter){

       Node temp=head;
       while(temp!=null) {
           if(temp.data==insertAfter) {
               Node newNode = new Node(data);
               newNode.next=temp.next;
               temp.next = newNode;
           }
           temp=temp.next;
       }

   }

   Node deleteAtEnd(){
       Node temp=head;
       if(temp==null || temp.next==null){
           head=null;
           return temp;
       }
       Node nextNode=temp.next;
       while(temp.next!=null){
           if(nextNode.next==null) {
               temp.next = null;
           }
           temp= nextNode;
           nextNode=nextNode.next;
       }
       return temp;
   }

   Node deleteAtStart(){
       Node temp=head;
       if(temp==null || temp.next==null){
           head=null;
           return temp;
       }
       if(head!=null){
          Node todelete=head;
          head=head.next;
          return todelete;
       }
       return null;
   }

   public Node delete(int data) {
       if (head == null) {  // Handle empty list
           System.out.println("List is empty");
           return null;
       }

       Node curr = head;
       while (curr.next != null) {
           if (curr.next.data == data) {  // Check next node for deletion
               Node toDelete = curr.next;
               curr.next = curr.next.next;  // Bypass the deleted node
               return toDelete;
           }
           curr = curr.next;
       }

       return null;
   }

   public void printList(){
       Node temp=head;
       while(temp!=null){
           System.out.println(temp.data);
           temp=temp.next;
       }
    System.out.println("null");
   }
}
