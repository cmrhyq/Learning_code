package cycle;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname ForCycle.java
 * @project Basic
 * @package cycle
 * @date 2024/7/18 23:43
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ForCycle {

    public static void main(String[] args) {
        for (int x = 0; x < 6; x++) {
            System.out.println(x + "+" + (5 - x) + "=5");
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(j + "×" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }

        for (int i = 1; i <= 5; i++) {
            for (int k = 1; k <= 5 - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        int total_loop = 50;
        for (int i = 1; i <= total_loop; i++) {
            for (int k = 1; k <= total_loop - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == total_loop) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
