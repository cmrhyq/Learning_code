package budget;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname Budget.java
 * @project Basic
 * @package budget
 * @date 2024/7/16 23:38
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Budget {

    public static void main(String[] args) {
        int a = 1 >> 2;
        int b = -8 >> 2;
        int c = 1 << 2;
        int d = -1 << 2;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("\n");
        System.out.println(2 & 3); // 2
        System.out.println(~-2); // 1
        System.out.println(~2); // -3
        System.out.println(2 | 3); // 3
        System.out.println(2 ^ 3); // 3
    }
}
