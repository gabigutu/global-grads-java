public class Main {

    public static void main(String[] args) {

        NodeList lista = new NodeList();

        lista.addNode(5);
        lista.addNode(12);
        lista.addNode(4);
        lista.addNode(6);
        lista.addNode(8);
        lista.addNode(16);
        lista.addAtPosition(121,3);
        lista.addAtPosition(126,7);

        lista.removePosition(3);
     //   lista.setAtPosition(45, 3);
      //  lista.setAtPosition(76, 3);

        lista.printList();
        System.out.println("The list has " + lista.size() + " elements.");
        lista.inspectPostion(4);
    }

}
