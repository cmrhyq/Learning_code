import com.cmrhyq.sub02.test.TestMethod;
import org.junit.jupiter.api.Test;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname TestReport.java
 * @project gradle_tree
 * @package PACKAGE_NAME
 * @date 2023/7/17 14:21
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class TestReport {

    @Test
    public void testReport(){
        String result = TestMethod.testMethod();
        System.out.println("result = " + result);
        assert result.equals("Hello, alan");
    }
}
