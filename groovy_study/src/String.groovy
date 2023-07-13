/**
 * <p>
 *     Groovy字符串相关
 * </p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname String.groovy
 * @project groovy_study
 * @package
 * @date 2023/7/13 0:12
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
def desc = "测试";
def str1 = '单引号，不支持变量引用，不支持换行操作，${desc}';
def str2 = "双引号，支持变量引用，不支持换行操作，${desc}"
def str3 = """双引号模板字符串，支持变量引用，支持换
                    行操作，${desc}"""
def str4 = '''双引号模板字符串，不支持变量引用，支持换
                    行操作，${desc}'''
println(str1)
println(str2)
println(str3)
println(str4)