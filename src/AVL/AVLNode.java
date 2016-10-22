package AVL;

import CommonUtils.Node;

/**
 * Created by chyvn on 25-09-2016.
 */
public class AVLNode {

    int data;
    AVLNode left, right, parent;
    int leftHeight;
    int rightHeight;
    boolean isBalanced;

    AVLNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.leftHeight = 0;
        this.rightHeight = 0;
    }

    void setIsBalanced() {
        if (leftHeight > rightHeight  && leftHeight - rightHeight == 1) isBalanced = true;
        else if (rightHeight - leftHeight <= 1) isBalanced = true;
        else isBalanced = false;
    }
}
