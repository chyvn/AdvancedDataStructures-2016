package BST;

/**
 * Created by chyvn on 18-09-2016.
 * <p>
 * this is the driver / tester class for the assignment.
 */
public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        //write a function to randomly do some stuff..
        tree.insert(13);
        tree.insert(3);
        tree.insert(4);
        tree.insert(12);
        tree.insert(14);
        tree.insert(10);
        tree.insert(5);
        tree.insert(1);
        tree.insert(8);
        tree.insert(2);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(6);
        tree.insert(18);
        tree.printTree(tree.root);

        tree.traverse();
        tree.remove(34);
        tree.traverse();

        tree.printTree(tree.root);
    }
}
