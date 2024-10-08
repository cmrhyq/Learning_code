<div style="font-family: 'Kanit', sans-serif;text-align: center;border: 10px solid #fff;box-shadow: 1px 1px 2px #e6e6e6;background: linear-gradient(to left top, #11998e, #38ef7d); padding: 50px 0;">
<div style="color: #fff;">
    <h3 style="font-size: 25px;font-weight: 600;letter-spacing: 1px;text-transform: uppercase;margin: 0;">
       Java Basic
    </h3>
    <span style="font-size: 16px;text-transform: capitalize;">
    	Java基础
    </span>
</div>
</div>

[toc]



## 基本数据类型转换

### 自动类型转换

- 当Java在进行赋值或运算的时候，精度小的类型自动转换为精度大的数据类型，这个就是自动类型转换
- 数据类型按精度（容量）大小排序：
  - char(最小)——>int——>long——>float——>double(最大)
  - byte(最小)——>short——>int——>long——>float——>double(最大)

**案例**

```java
class dataTypeConvert.AutoConvert {
    public static void main(String[] args) {
        // case 1
        int a = 'c';
        double b = 80;
        // 输出 a=97, b=80.0
        System.out.println(a);
        System.out.println(b);
    }
}
```

### 自动类型转换注意和细节

1. 有多种类型的数据混合运算的时候，系统首先自动将所有数据转换成容量最大的那种数据类型，然后在进行计算

```java
class dataTypeConvert.AutoConvert {
    public static void main(String[] args) {
        int num2 = 10;
        // 错误原因：num2 + 1.2 的结果的类型是double，因为在运算过程中自动将数据类型转换成了double，所以赋值给float是错误的
        float f1 = num2 + 1.2;
        System.out.println(f);
        
        // 正确写法1
        double d = num2 + 1.2;
        System.out.println(d);
        
        // 正确写法2
        float f2 = num2 + 1.2F;
        System.out.println(f2);
    }
}
```

2. 当我们把精度大的数据类型赋值给精度小的数据类型时，就会报错，反之就会进行自动类型转换

```java
class dataTypeConvert.AutoConvert {
    public static void main(String[] args) {
        // 错误：精度大的double不能转换成精度小的int
        int n2 = 1.1;
    }
}
```

3. (byte, short) 和 char 之间不会互相自动抓换

```java
class dataTypeConvert.AutoConvert {
    public static void main(String[] args) {
        // byte范围：-128 ~ 127
        // 当把数值赋值给 byte 时，先判断这个数值是否在byte的范围内。
        byte b1 = 10;
        
        // 错误，不在byte范围内
        byte b3 = 1000;
        
        // 如果是按照变量赋值，则需要判断类型
        int n1 = 1;
        byte b2 = n1;
        
        // 错误，byte 和 char 之间不会互相自动抓换
        char c1 = b1;
    }
}
```

4. byte, short, char 他们三者之间可以计算（包括同类型），在计算时首先转换成int类型

```java
class dataTypeConvert.AutoConvert {
    public static void main(String[] args) {
        byte b1 = 1;
        short s1 = 1;
        // 错误，b1+s1的类型是int
        short s2 = b1+s1;
    }
}
```

5. boolean 不参与类型的自动转换
6. 自动提升原则：表达式的结果的类型自动提升为操作数中最大的类型

```java
class dataTypeConvert.AutoConvert {
    public static void main(String[] args) {
        byte b1 = 1;
        short s1 = 102;
        int n1 = 2;
        double d1 = 1.1;
        // 因为在这些变量中，double是精度最大的数据类型，所以最后的结果转换成了double
        double result = b1 + s1 + n1 + d1
    }
}
```

### 基本数据类型转String

1. 基本数据类型转String
   1. 语法：将基本数据类型的值+ ""
   2. 演示：1 + ""
2. String类型转基本数据类型
   1. 语法：通过基本类型的包装类调用parseXXX方法即可
   2. 演示：Integer.parseInt("123")

3. 在将String类型转换成基本数据类型时，要确保String类型能够转成有效的数据，比如，我们不能把 "hello" 转换成一个整数



## 运算符

运算符是一种特殊的符号，用以表示数据的运算、赋值和比较。

1. 算术运算符
2. 赋值运算符
3. 关系运算符 [比较运算符]
4. 逻辑运算符
5. 位运算符
6. 三元运算符

### 算术运算符

![image-20240715234754062](MarkdownImageUpload/image-20240715234754062.png)

1. 自增：++作为独立的语句使用时，不管是++i，还是i++都是一样的，等价
2. 前++和后++都完全等价于 i=i+1
3. ++i 先自增后赋值

```java
class ArithmeticOperator {
    public static void main(String[] args) {
        int i = 1;
        // 规则会使用临时变量
        // 先把i给临时变量 temp=i
        // 然后i = i + 1
        // 最后再把temp给i i = temp
        i = i++;
        System.out.println(i) // result = 1
    }
}
```

4. i++ 先赋值再自增

```java
class ArithmeticOperator {
    public static void main(String[] args) {
        int i = 1;
        // 规则会使用临时变量
        // 先自增：i = i + 1
        // 然后把i给临时变量：temp=i
        // 最后再把temp给i：i = temp
        i = ++i;
        System.out.println(i) // result = 1
    }
}
```

5. **当对一个数取模时，可以等价 a%b = a-a/b*b，比如：11%9 = 11 - 11/9 * 9**



**例题**

```java
class ArithmeticOperator {
    public static void main(String[] args) {
        int i1 = 10;
        int i2 = 20;
        // i1++是先复制再运算，所以先把i1赋值给i，然后i1自增，i = 10, i1 = 11
        int i = i1++;
        System.out.println(i); // result = 10
        System.out.println(i2); // result = 20
        // --i2是先运算再赋值，所以先把i2自减，然后再把i2赋值给i，i=19,i2=19
        i = --i2;
        System.out.println(i); // result = 19
        System.out.println(i2); // result = 19
    }
}
```



## 位运算符

按位与 &

- 两位全为1，结果为1，否则为0

按位或 |

- 两位有一个为1，结果为1，否则为0

按位异或 ^

- 必须是两位一个为0，一个为1，结果才为1，否则为0

按位取反 ~ 

- **运算顺序：原码 -> 反码 -> 补码 -> 补码取反 -> 再取反码 -> 再取补码**
- 正数的按位取反是本身加一再取负
- 负数的按位取反是本身减一再取正

算数右移 >>

- 低位溢出，符号位不变，并用符号位补溢出的高位
- **正数的算术右移相当于右移几位就除以几个2，有小数则忽略小数**
- **负数的取反运算顺序**：原码 -> 补码 -> 符号位不变，加1 -> 右移(高位补1) -> 按位取反 -> 加1

算数左移 <<

- 符号位不变低位补0
- **正数的的算术左移相当于左移几位就乘以几个2**

逻辑右移 >>>

- 也叫无符号右移，规则是低位溢出，高位补0



### 原码反码补码

有符号的数

1. 二进制的最高位是符号位：0表示证书，1表示复数
2. 正数的原码、反码、补码都一样
3. 负数的反码 = 它的原码符号位不变，其它位取反
4. 负数的补码 = 它的反码 + 1，负数的反码 = 负数的补码 - 1
5. 0的反码、补码都是0
6. Java没有无符号数，Java中的数都是有符号的
7. 在计算机运算的时候，它都是以补码的方式来运算
8. 当我们看运算结果的时候，要看他的原码



```java
class Budget {
    public static void main(String[] args) {
        
        int a=1>>2; // a = 0
        // -1 >> 2
        // 原码 10000001
        // 补码 11111110
        // 加一 11111111
        // 右移 11111111
        // 取反 10000000
        // 加一 10000001
        int b=-1>>2;// b = -1
        int c=1<<2; // c = 4
        int d=-1<<2; // d = -4
        
        System.out.println(2&3); // 2
        System.out.println(~-2); // 1
        System.out.println(~2); // -3
        System.out.println(2|3); // 3
        System.out.println(2^3); // 3
    }
}
```



## Switch 分支结构

- 表达式数据类型，应和case后的常量类型一致，或者是可以自动转换成可以比较的类型
- switch中表达式的返回值必须是：（byte, short, int, char, enum, String)
- case子句中的值必须是常量，不能是变量
- default子句是可选的
- break语句用来执行完一个case分支后使程序跳出switch语句块，不写则会按顺序执行到switch结尾



## for 循环

```java
class ForCycle {

    public static void main(String[] args) {
        // Question 1：打印星号直角三角形
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(j + "×" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
        
        // Question 1：打印星号金字塔
        for (int i = 1; i <= 5; i++) {
            for (int k = 1; k <= 5 - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
		// Question 1：打印星号空心星号金字塔
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
```





## 数组

1. 数组是多个相同类型数据的组合，实现对这些数据的统一管理

2. 数组中的元素可以是任何数据类型，包括基本类型和引用类型，但是不能混用。

3. 数组创建后，如果没有赋值，有默认值 

   1. int=0
   2. short=0
   3. byte=0
   4. long=0
   5. float=0.0
   6. double=0.0
   7. char=\u0000
   8. boolean=false
   9. String=null

4. 使用数组的步骤：1.声明数组并开辟空间 2.给数组各个元素赋值 3.使用数组

5. 数组的下标是从0开始的

6. 数组下标必须在指定范围内使用，否则报:下标越界异常，比如int [] arr=new int[5]; 则有效下标为 0-4

7. 数组属引用类型，数组型数据是对象(object)

### 数组赋值机制

1. 基本数据类型赋值，这个值就是具体的数据，而且互相不影响，是值拷贝。

```java
class DataTypeAssign {
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = n1;
        n2 = 80;
        System.out.println(n1) // 2
        System.out.println(n2) // 80
    }
}
```

2. 数组在默认情况下是引用传递，赋值的是地址，是引用拷贝

```java
class ArrayAssign {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = arr1;
        arr2[0] = 9;
        for(int i = 0; i< arr1.length; i++){
            System.out.println(arr1[i]) // {9,2,3}
        }
    }
}
```

### 数组拷贝

编写代码实现数组拷贝（内容赋值）

```java
class ArrayCopy {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = new int[arr1.length];
        
        for(int i = 0; i< arr1.length; i++){
            arr2[i] = arr1[i]
        }
        
        arr2[0] = 9;
        for(int i = 0; i< arr1.length; i++){
            System.out.println(arr1[i]) // {1,2,3}
        }
        
        for(int j = 0; j< arr2.length; j++){
            System.out.println(arr1[j]) // {9,2,3}
        }
    }
}
```

### 数组反转

把数组的元素内容反转，arr{1,2,3,4,5,6} -> {6,5,4,3,2,1}

```java
class ArrayReversal {
    public static void main(String[] args) {
        // method 1
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int len = arr1.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = arr1[i];
            arr1[i] = arr1[len - i - 1];
            arr1[len - i - 1] = temp;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(arr1[i] + "\t");
        }
        
        // method 2
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int arr2Length = arr2.length;
        int[] arr3 = new int[arr2Length];
        for (int i = 0; i < arr2Length; i++) {
            arr3[i] = arr2[arr2Length - i - 1];
        }

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + "\t");
        }
    }
}
```

### 数组扩容

实现动态的给数据添加元素的效果，实现对数组的扩容

1. 原始数组使用静态分配 `int[] arr = {1,2,3}`
2. 增加的元素，直接放在数组的最后 `arr = {1,2,3,4}`
3. 可以通过如下的方式来决定是否继续添加 `添加成功，是否继续？y/n`

```java
class ArrayAdd {

    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个数");
            int input = sc.nextInt();
            int[] newArr = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[newArr.length - 1] = input;
            arr = newArr;
            System.out.print("扩容结果:");
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println("\n添加成功，是否继续？y/n");
            char choose = sc.next().charAt(0);
            if (choose == 'n') {
                System.out.println("程序结束");
                break;
            } else if (choose == 'y') {
                System.out.println("程序继续");
            } else {
                System.out.println("输入错误，程序结束");
                break;
            }
        }
    }
}
```

有一个数组{1,2,3,4,5}，可以将该数组进行所见，提示是否继续缩减，每次缩减最后一个元素，只剩一个元素时提示不能再缩减

```java
class ArrayReduce {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (arr.length == 1) {
                System.out.println("只剩一个元素，不能再缩减");
                break;
            } else {
                int[] reduceArr = new int[arr.length - 1];
                for (int i = 0; i < reduceArr.length; i++) {
                    reduceArr[i] = arr[i];
                }
                arr = reduceArr;
                System.out.print("缩容结果:");
                for (int i : arr) {
                    System.out.print(i + "\t");
                }
                System.out.println("\n缩容成功，是否继续？y/n");
                char choose = sc.next().charAt(0);
                if (choose == 'n') {
                    System.out.println("程序结束");
                    break;
                } else if (choose == 'y') {
                    System.out.println("程序继续");
                } else {
                    System.out.println("输入错误，程序结束");
                    break;
                }
            }
        }
    }
}
```



### 排序

排序是将多个数据，依指定的顺序进行排列的过程。

1. 内部排序
   - 指将需要处理的所有数据都加载到内部存储器中进行排序。包括(交换式排序法、选择式排序法和插入式排序法)
2. 外部排序法
   - 数据量过大，无法全部加载到内存中，需要借助外部存储进行排序。包括(合并排序法和直接合并排序法)

#### 冒泡排序

使用冒泡排序将 [24,69,80,57,13] 排成一个从小到大的有序数列

**分析**

![image-20240726005949289](MarkdownImageUpload/image-20240726005949289.png)

![image-20240726010105727](MarkdownImageUpload/image-20240726010105727.png)

**总结**

1. 一共有5个元素
2. 一共进行了4轮排序，可以看成是外层循环
3. 每一轮排序可以确定一个数的位置
4. 当比较时，如果前面的数大于后面的数，就交换位置
5. 每一轮的比较在减少

**代码**

```java
class BubbleSort {

    public static void main(String[] args) {
        int[] bubble = {24, 69, 80, 57, 13};
        // 根据分析得知，冒泡排序只会进行 数组长度 - 1 次
        // 所以，用外层for控制排序的轮数
        for (int j = 0; j < bubble.length - 1; j++) {
            // 用内层for控制每次排序的比较次数, 每次排序的比较次数 = 数组长度 - 当前排序轮数
            for (int i = 0; i < (bubble.length - 1) - j; i++) {
                if (bubble[i] > bubble[i + 1]) {
                    // 用临时变量来实现交换
                    int temp = bubble[i];
                    bubble[i] = bubble[i + 1];
                    bubble[i + 1] = temp;
                }
            }
        }
        for (int i = 0; i < bubble.length; i++) {
            System.out.print(bubble[i] + "\t");
        }
    }
}
```



### 二维数组

![image-20240728020903289](MarkdownImageUpload/image-20240728020903289.png)

```java
class TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] arr = new int[3][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
```

**题目**：用二维数组打印10行的杨辉三角

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
...........

**提示**：

- 第一行有1个元素，第N行有N个元素
- 每一行的第一个和最后一个元素都是1
- 从第三行开始，对于非第一个元素和最后一个元素的值都是 `arr[i][j] = arr[i-1][j] + arr[i-1][j-1]`

```java
class YangHuiTriangle {

    /**
     * - 第一行有1个元素，第N行有N个元素
     * - 每一行的第一个和最后一个元素都是1
     * - 从第三行开始，对于非第一个元素和最后一个元素的值都是 arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter line number");
        int line = sc.nextInt();
        int[][] triangle = new int[line][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0 || j == triangle[i].length - 1) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
            }
        }

        for (int[] triangles : triangle) {
            for (int anInt : triangles) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
```

#### 使用细节

1. 一维数组的声明方式：int[] x 或者 int x[]
2. 二维数组的声明方式：`int[][] y` 或者 `int[] y[]` 或者 `int y[][]`
3. 二维数组实际上是由多个一个为数组组成的，它的各个一维数组的长度可以相同，也可以不同
   1. `map[][]` 是一个二维数组，`int map[][] = {{1,2},{2,4,3}}` ，map[0] 是一个含有两个元素的一维数组，map[1] 是一个含有三个元素的一维数组，也称之为列数不等的二维数组



### 例题

有一个升序的数组，要求插入一个元素，该数组顺序还是升序，比如：[10,12,45,90]，插入一个23后，数组为[10,12,23,45,90]

```java
class AscendingArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 12, 45, 90};
        System.out.print("Enter the number: ");
        int number = sc.nextInt();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (number <= arr[i]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            index = arr.length;
        }

        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            // 声明了两个指针i，j
            // i指针指向新数组的每一个位置
            // j指针指向旧数组
            // i指针的值不等于 index索引的时候，只有这个时候才能把j指针当前指向旧数组的指拿给新数组，然后 j指针指向下一位
            // i指针的指等于 index索引的时候，表明 i指针当前所在的位置是要插入的位置，就把要插入的数放到这个位置，然后 j指针不动
            if (i != index) {
                newArr[i] = arr[j];
                j++;
            } else {
                newArr[i] = number;
            }
        }
        arr = newArr;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
```



## 类与对象

![image-20240730003715897](MarkdownImageUpload/image-20240730003715897.png)

1. 从概念上看：成员变量 = 属性 = field，即成员变量是用来表示属性的
2. 属性是类的一个组成部分，一般是基本数据类型，也可以是引用类型，比如对象、数组

### 细节和注意事项

1. 属性的定义语法同变量，示例:访问修饰符 属性类型 属性名,
2. 属性的定义类型可以为任意类型，包含基本类型或引用类型
3. 属性如果不赋值，有默认值，规则和数组一致。

### 类和对象的内存分配机制

1. 栈：一般存放基本数据类型（局部变量）
2. 堆：存放对象、数组等
3. 方法区：常量池（常量、比如字符串），类加载信息

### 对象创建流程

```java
Person p = new Person();
p.name = "jack";
p.age = 10;
```

1. 首先加载类信息（属性和方法信息，只会加载一次）
2. 在堆中分配空间，进行默认初始化，把地址赋值给p，p就指向对象
3. 进行指定初始化，比如 p.name = "jack" 和 p.age = 10



## 成员方法

某些情况下，需要定义成员方法。比如人类：除了一些属性外（姓名、年龄），我们还可以有一些行为（说话、跑步）。这时候就需要用成员方法才能完成。

```java
class Person {
    String name;
    int age;
    // 成员方法
    public void speak(word){
        System.out.println("You say: " + word);
    }
}
```

### 成员方法调用机制

```java
class ClassMethod {
    public static void main(String[] args) {
    	Person p1 = new Person();
        int return = p1.getSum(10,20);
        System.out.pringln(return);
    }
    
    public int getSum(int num1, int num2){
        return num1 + num2;
    }
}
```

![image-20240801000357248](MarkdownImageUpload/image-20240801000357248.png)

**方法调用小结**

1. 当程序执行到方法的时候，就会开辟一个独立的空间（栈空间）
2. 当方法执行完毕或执行到return语句时，就会返回
3. 返回到调用方法的地方
4. 返回后，继续执行方法后面的代码

### 注意事项

- 返回类型
  1. 一个方法最多有一个返回值
  2. 返回类型可以为任意类型，包含基本类型或引用类型(数组，对象)
  3. 如果方法要求有返回数据类型，则方法体中最后的执行语句必须为return 值; 而3.且要求返回值类型必须和return的值类型一致或兼容
  4. 如果方法是void，则方法体中可以没有return语句，或者 只写return;
- 方法参数
  1. 一个方法可以有0个参数，也可以有多个参数，中间用逗号隔开
  2. 参数类型可以为任意类型，包含基本类型或引用类型
  3. 调用带参数的方法时，一定对应着参数列表传入相同类型或兼容类型的参数
  4. 方法定义时的参数称为形式参数，简称形参;方法调用时的参数称为实际参数，简称实参，实参和形参的类型要一致或兼容、个数、顺序必须一致!
- 方法调用
  1. 同一个类中的方法调用:直接调用即可。比如 print(参数)
  2. 跨类中的方法A类调用B类方法:需要通过对象名调用。比如 对象名,方法名(参数)

### 方法的递归

递归就是方法自己调用自己，每次调用都传入不同的变量

Demo 1

```java
class ClassRecursion {
    
    public void test(int n){
        if (n > 2){
            test(n - 1);
        }
        System.out.println(n);
    }
}
```

![image-20240908004440769](MarkdownImageUpload/image-20240908004440769.png)

Demo 2

```java
class ClassRecursion {
    
    public void factorial(int n){
        if(n == 1){
            return 1;
        } else {
            return factorial(n-1)*n;
        }
    }
}
```

