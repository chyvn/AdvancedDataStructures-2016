package CommonUtils;

/**
 * Created by chyvn on 25-09-2016.
 */
public class Node {
    public int data;
    public Node left, right, parent;

    public Node (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
