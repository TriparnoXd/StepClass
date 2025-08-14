
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;

    void append(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node curr = this.head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    void pop(){
        if(this.head == null){
            System.out.println("The linked list is already empty!!");
        }else if (this.head.next == null) {
            this.head = null;
        }
        else{
            Node curr = this.head;
            while(curr.next.next != null){
                curr = curr.next;
            }
            curr.next = null;
        }
    }

    void printLL(){
        if(this.head == null){
            System.out.println("The linked list is already empty !!");
        }else{
            Node curr = this.head;
            while(curr != null){
                System.out.print(curr.data + "->");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    boolean isEmpty(){
        return this.head == null;
    }
}

public class Main{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        int n=5;
        for(int i=0;i<n;i++){
            ll.append(i+1);
        }
        while(!ll.isEmpty()){
            ll.pop();
            ll.printLL();
        }
    }
}