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

