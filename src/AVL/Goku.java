package AVL;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Created by chyvn on 09-10-2016.
 */
public class Goku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        //String temp = scanner.nextLine();
        //String minutes[] = scanner.nextLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        //array[i] = Integer.parseInt(minutes[i]);

        int count = 0;
        boolean condition = false;
        for (int i = 1; i < n; i++) {
            if (array[i] - array[i - 1] <= k) {
                count += (array[i] - array[i - 1]);
            } else {
                condition = true;
                break;
            }
        }
        if (condition) count += k;
        System.out.print(count);
    }
}
