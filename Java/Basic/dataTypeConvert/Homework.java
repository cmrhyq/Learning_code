package dataTypeConvert;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname Homework.java
 * @project Basic
 * @package dataTypeConvert
 * @date 2024/7/15 23:35
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class Homework {

    public static void main(String[] args) {
//        System.out.println("\n"); // 换行
//        System.out.println("\t"); // 制表位
//        System.out.println("\r"); // 回车
//        System.out.println("\\"); // 第一个代表啊转义，第二个代表斜杠

        String name = "alan";
        int age = 13;
        double score = 43.1;
        char gender = '男';
        String hobby = "code";
        System.out.println("姓名\t年龄\t成绩\t性别\t爱好\n" + name + "\t" + age + "\t" + score + "\t" + gender + "\t" + hobby);
    }
}
