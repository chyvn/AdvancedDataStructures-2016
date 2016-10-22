package AVL;

import CommonUtils.Node;

/**
 * Created by chyvn on 25-09-2016.
 */
public class AVL {

    AVLNode root;

    public void insert(int data) {
        //insert as if it's a BST.
        if (root == null) {
            root = new AVLNode(data);
        } else {
            AVLNode temp = root;
            while (1 == 1) {
                if (temp.data > data) {
                    if (temp.left != null) {
                        temp.leftHeight++;
                        temp = temp.left;

                    }
                    else {
                        AVLNode newNode = new AVLNode(data);
                        temp.left = newNode;
                        newNode.parent = temp;
                        redoBalance(newNode);
                        break;
                    }
                } else {
                    if (temp.right != null) {
                        temp.rightHeight++;
                        temp = temp.right;
                    }
                    else {
                        AVLNode newNode = new AVLNode(data);
                        temp.right = newNode;
                        newNode.parent = temp;
                        redoBalance(newNode);
                        break;
                    }
                }
            }
        }
    }

    void redoBalance(AVLNode node) {
        while (node != null) {
            node.setIsBalanced();
            if (!node.isBalanced) balance(node);
            node = node.parent;
        }
    }

    void balance(AVLNode node) {
        //find what case this is.

        int left = node.leftHeight;
        int right = node.rightHeight;

        if (left > right) {
            //this is a tree with L.
            if (node.left.leftHeight > node.left.rightHeight) {
                //this is an LL case
            }
            else {
                //this is an LR case.
            }
        }
        else {
            if (node.left.leftHeight > node.left.rightHeight) {
                //this is an RL case
            }
            else {
                //this is an RR case.
            }
        }
    }
}
