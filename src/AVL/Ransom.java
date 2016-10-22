package AVL;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by chyvn on 22-10-2016.
 */
public class Ransom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        HashMap<String, Integer> magazine = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            String temp = scanner.next();
            if (magazine.containsKey(temp)) {
                int value = magazine.get(temp);
                magazine.put(temp, ++value);
            }
            else magazine.put(temp, 0);
        }
        boolean canForm = true;
        for (int i = 0; i < n && canForm; i++) {
            String temp= scanner.next();
            if (magazine.containsKey(temp)) {
                magazine.put(temp, (magazine.get(temp) - 1));
                if (magazine.get(temp) == -1) magazine.remove(temp);
            }
            else {
                canForm = false;
            }
        }
        if (canForm) System.out.println("Yes");
        else System.out.print("No");
    }

}
