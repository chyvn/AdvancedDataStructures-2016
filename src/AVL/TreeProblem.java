package AVL;

import java.util.Scanner;

/**
 * Created by chyvn on 09-10-2016.
 */
public class TreeProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int treeArray[] = new int[nodes];
        treeArray[0] = 0;
        for (int i = 0; i < nodes - 1; i++) {
            treeArray[i + 1] = scanner.nextInt() - 1;
        }
        int queries = scanner.nextInt();
        while (queries > 0) {
            --queries;
            int subTree = scanner.nextInt() - 1;
            int k = scanner.nextInt();

            //value array is where all values are stored.
            int valueArray[] = new int[nodes * k];
            for (int i = 0; i < nodes * k; i++) {
                valueArray[i] = -1;
            }
            for (int i = 0; i < nodes * k; i++) {
                valueArray[i] = getValue(valueArray, i);
            }


            int total = 0;
            for (int i = subTree + 1; i < nodes; i++) {
                boolean isSubtree = isParent(treeArray, i, subTree);
                if (isSubtree) total += valueArray[treeArray[i] + k];
                else total += valueArray[1];
                if (1==1) {}
            }
            if (subTree != 0) total += valueArray[subTree];
            System.out.println(total);
        }

    }

    static int getValue(int[] valueArray, int i) {
        if (i == 1 || i == 0) {
            valueArray[i] = 1;
            return 1;
        }
        if (valueArray[i] != -1) return valueArray[i];
        else {
            return (getValue(valueArray, i - 1) * 2 + getValue(valueArray, i - 2) * 3);
        }
    }

    static boolean isParent(int[] treeArray, int me, int maxParent) {
        if (treeArray[me] == maxParent) return true;
        else if (treeArray[me] > maxParent) return isParent(treeArray, treeArray[me], maxParent);
        else return false;
    }
}
