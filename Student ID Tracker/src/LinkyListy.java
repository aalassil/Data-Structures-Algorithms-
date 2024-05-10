public class LinkyListy extends Object  {

    Node head;
    Node tail;
    int size =0;
    Node counter = head;
//    public LinkyListy(long studentId){
//        Node newNode = new Node(studentId);
//        head = newNode;
//        tail = newNode;
//        newNode.prev= head;
//        size++;
//    }
    public LinkyListy(){
    }

    public Node add(int studentId){
            Node newNode = new Node(studentId);
        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.prev= head;
            size++;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
            size++;
        }
            return newNode;
    }

    public void listToString(){
        Node temp = head;
        if(head == null){
            System.out.println("head is null / list is empty");
        }else{
                System.out.println("Displaying all nodes in the linked list");
            while(null != temp){
                System.out.println(temp.studentId + "-->");
                temp = temp.next;
            }
        }
    }

    public Node removelast(){
            Node temp = tail;
        if(head == null){
            System.out.println("list is empty nothing to be removed");
            return null;
        }
        else if(size ==1){
            head.prev = null;
            head = null;
            size--;
        }
        else{
            tail = tail.prev;
            size--;
            tail.next = null;
            temp.prev = null;
        }
            return temp;
    }

    public Node popNode(){
        if(head == null){
            System.out.println("there is a problem with pushNode Function look into linky listy class");
        }
        Node temp = counter;
        if(counter != null){

            counter = counter.next;
            return temp;
        }
        System.out.println("list has successfully done");
        return null;
    }
    //****************************************************************************
//    public Node itirateList(LinkyListy l){
//        Node temp = l.head;
//        while(temp !=null){
//
//        }
//    }
//    public long getStudentId() {;
//
//    }
    public long getStudentId(Node node) {
        if (node != null) {
            return node.getPrivateStudentId();
        } else {
            // You can handle the case where the node is null
            System.out.println("Node is null");
            return -1; // or any other value that indicates an error or absence of a student ID
        }
    }
    public int getSize(){
        return size;
    }

}
