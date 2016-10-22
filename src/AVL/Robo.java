    package AVL;

    import java.util.Scanner;

    /**
     * Created by chyvn on 09-10-2016.
     */
    public class Robo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            while (n > 0) {
                --n;
                int direction = scanner.next().charAt(0);
                int forwaredSteps = scanner.nextInt();
                int backwardSteps = scanner.nextInt();
                int titi = scanner.nextInt();
                int jatin = 0 - titi;

                int forwardPosition = 0;
                int backPosition = 0;
                int nowIndex = 0;

                if (direction == 'B') {
                    int temp = forwaredSteps;
                    forwaredSteps = backwardSteps;
                    backwardSteps = temp;
                }
                int steps = 0;
                while (forwardPosition != titi || backPosition != titi || backPosition != jatin || forwardPosition != jatin) {
                    ++steps;
                    if (direction == 'F') {
                        nowIndex += forwaredSteps;
                        direction = 'B';
                        forwardPosition = nowIndex;
                    } else {
                        nowIndex -= backwardSteps;
                        direction = 'F';
                        backPosition = nowIndex;
                    }
                    if (backPosition >= titi || backPosition <= jatin || forwardPosition == titi || forwardPosition == jatin) break;
                }

                if (nowIndex < 0 && nowIndex == jatin) {
                    System.out.println(steps);
                    System.out.println("Jatin");
                } else if (nowIndex == titi) {
                    System.out.println(steps);
                    System.out.println("Titi");
                }
                else System.out.println(-1);
            }
        }
    }
