package BST;

import CommonUtils.Node;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by chyvn on 25-09-2016.
 */
public class BST {
    public Node root;

    void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node temp = root;
            while (1 == 1) {
                if (temp.data > data) {
                    if (temp.left != null) temp = temp.left;
                    else {
                        Node newNode = new Node(data);
                        temp.left = newNode;
                        newNode.parent = temp;
                        break;
                    }
                } else {
                    if (temp.right != null) temp = temp.right;
                    else {
                        Node newNode = new Node(data);
                        temp.right = newNode;
                        newNode.parent = temp;
                        break;
                    }
                }
            }
        }
    }

    void remove(int data) {
        root = delete(root, data);
    }

    Node delete(Node root, int data) {
        //if the tree is empty.
        if (root == null) return root;

        //traverse till the right or left to delete
        if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);

        else {
            //I'm the single child to my parent, and I'm being deleted.
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            //I have two children
            //replace my value with my successor, and delete him.
            root.data = getSuccessor(root.right).data;
            root.right = delete(root.right, data);
        }
        return root;
    }

    Node getPredecessor(Node me) {
        if (me.left == null) {
            if (me.parent.left == me) return null;
            else {
                return me.parent;
            }
        } else {
            Node temp = me.left;
            while (temp.right != null) temp = temp.right;
            return temp;
        }
    }

    Node getSuccessor(Node me) {
        while (me.left != null) {
            me = me.left;
        }
        return me;
    }

    void traverse() {
        System.out.print("Inorder traversal : ");
        inOrder(root);
        System.out.println("");
        System.out.print("Pre-order traversal : ");
        preOrder(root);
        System.out.println("");
        System.out.print("Post-order traversal : ");
        postOrder(root);
        System.out.println("");
    }

    private void inOrder(Node temp) {
        if (temp.left != null) inOrder(temp.left);
        System.out.print(temp.data + " ");
        if (temp.right != null) inOrder(temp.right);
    }

    private void preOrder(Node temp) {
        System.out.print(temp.data + " ");
        if (temp.left != null) preOrder(temp.left);
        if (temp.right != null) preOrder(temp.right);
    }

    private void postOrder(Node temp) {
        if (temp.left != null) postOrder(temp.left);
        if (temp.right != null) postOrder(temp.right);
        System.out.print(temp.data + " ");
    }

    private void print() {
        //a linked list of levels.
        LinkedList nodeList = new LinkedList();
        //maintain a width of max level
        nodeList = getLinked(nodeList, root, 0);
        //print all the levels on a new line .

    }

    private LinkedList getLinked(LinkedList list, Node node, int index) {
        LinkedList dataList = (LinkedList) list.get(index);
        if (dataList == null) {
            dataList = new LinkedList();
            dataList.add(0, node.data);
        } else {
            dataList.add(dataList.size() + 1, node.data);
        }
        getLinked(list, node.left, index++);
        getLinked(list, node.right, index++);
        return list;
    }

    void printTree(Node root) {
        LinkedList<LinkedList<Integer>> tree = new LinkedList<>();
        LinkedList<Integer> levelList = new LinkedList<>();
        int[][] treeArray = new int[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                treeArray[i][j] = -1;
            }
        }

        treeArray = buildTreeArray(treeArray, root, 0);
        System.out.println("This is the output of Array list");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20 && treeArray[i][j] != -1; j++) {
                System.out.print(treeArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*Failed implementation using linked list of linked list. for showing a tree.
    * Must have failed to understand the way linked lists work in linking items.
    *
    *
    * TODO : revisit this, and try to implement.
    * */
    LinkedList<LinkedList<Integer>> buildTree(LinkedList<LinkedList<Integer>> tree, int levelIndex, LinkedList<Integer> levelList, Node root) {
        if (levelList == null) levelList = new LinkedList<>();
        levelList.add(levelList.size(), root.data);
        LinkedList<Integer> tempList = tree.get(levelIndex);
        tree.add(levelIndex, levelList);
        System.out.println("Inserting node " + root.data + "at level Index" + levelIndex);
        LinkedList<Integer> childLevel = new LinkedList<>();
        ++levelIndex;
        if (root.left != null) tree = buildTree(tree, levelIndex, childLevel, root.left);
        if (root.right != null) tree = buildTree(tree, levelIndex, childLevel, root.right);
        return tree;
    }

    int[][] buildTreeArray(int[][] treeArray, Node root, int levelIndex) {
        int lastIndex = 0;
        for (int i = 0; i < 20; i++) {
            if (treeArray[levelIndex][i] == -1) {
                lastIndex = i;
                break;
            }
        }
        treeArray[levelIndex][lastIndex] = root.data;
        ++levelIndex;
        if (root.left != null) treeArray = buildTreeArray(treeArray, root.left, levelIndex);
        if (root.right != null) treeArray = buildTreeArray(treeArray, root.right, levelIndex);
        return treeArray;
    }


}
