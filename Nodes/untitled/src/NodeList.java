public class NodeList {

    Node start;

    public class Node{
        private int value;
        private Node next;

        public Node(){

        }
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public NodeList(){

    }


    public void printList(){
        Node currentNode = start;
        while(currentNode!= null){
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public void addNode(int value){
        Node newNode = new Node(value);
        if(start == null){
            start = newNode;
        } else {
            Node currentNode = start;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
    }
    public int size(){
        int size = 0;
        Node currentNode = start;
        while(currentNode != null){
            currentNode = currentNode.next;
            size++;
        }
        return size;
    }
    public void addAtPosition(int val, int position){
        int i = 1;
        if(start == null){
            Node newNode = new Node(val);
            start = newNode;
        } else {
            Node currentNode = start;
            while (currentNode != null) {
                if(i == position){
                    Node node = new Node(val, currentNode.next);
                    currentNode.next = node;
                    break;
                }
                i++;
                currentNode = currentNode.next;
            }
        }
    }
    public void inspectPostion(int position){
        int i = 0;
        Node currentNode = start;
        while(currentNode!= null){
            if(i == position){
                System.out.println("Value at the node " + i + " is " + currentNode.value);
            }
            i++;
            currentNode = currentNode.next;
        }
    }
    public void removePosition(int position) {
        int i = 0;
        if(position == 0){
            start = start.next;
            return;
        }
        Node currentNode = start;
        while (currentNode != null) {
            i++;
            if (i == position) {
                currentNode.next = currentNode.next.next;
                System.out.println("Node " + i + " has been removed");
            }
            currentNode = currentNode.next;
        }
    }
    public void setAtPosition(int val, int position){
        Node currentNode = start;
        int i = 0;
        while (currentNode != null) {
            if (i == position) {
                currentNode.value = val;
                System.out.println("Value at Node " + i + " has been replaced with " + val);
            }
            i++;
            currentNode = currentNode.next;
        }
    }

}
