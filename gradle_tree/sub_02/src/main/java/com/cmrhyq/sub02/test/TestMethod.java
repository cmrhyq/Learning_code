package com.cmrhyq.sub02.test;

import com.cmrhyq.sub01.data.TestData;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname TestMethod.java
 * @project gradle_tree
 * @package com.cmrhyq.sub02.test
 * @date 2023/7/17 11:52
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class TestMethod {

    public static String testMethod(){
        return TestData.test("alan");
    }

    public static void main(String[] args) {
        System.out.println(testMethod());
    }
}
