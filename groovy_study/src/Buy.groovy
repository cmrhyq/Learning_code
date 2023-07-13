import java.awt.print.Book

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname Buy.groovy
 * @project groovy_study
 * @package
 * @date 2023/7/12 23:37
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
def book = new BookDetail();
println("Book name is " + book.getBookName())
def result = book.price 12

println(result)

